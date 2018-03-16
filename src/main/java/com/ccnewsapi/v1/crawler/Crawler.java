/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.crawler;

import com.ccnewsapi.v1.connector.HTTPSConnector;
import com.ccnewsapi.v1.dao.MarketsDAO;
import com.ccnewsapi.v1.dao.TickerDAO;
import com.ccnewsapi.v1.model.TickersDataInfo;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author nguyenhuyquang
 */
public class Crawler {

    public void crawlTickers()
    {
        String url = "https://api.coinmarketcap.com/v1/ticker/?start=0&limit=2000";
        String response = HTTPSConnector.GETRequest(url);
        JSONArray tickers = new JSONArray(response);
        TickerDAO tickerDAO = new TickerDAO();
        for (int i=0; i<tickers.length(); i++)
        {
            JSONObject ticker = tickers.getJSONObject(i);
            TickersDataInfo tickerInfo = new TickersDataInfo();
            tickerInfo.parseJSONObject(ticker);
            tickerDAO.insertOrUpdateTicker(tickerInfo);
//            String urlSpecificTicker = "https://coinmarketcap.com/currencies/"+tickerInfo.getId()+"/#markets";
//            try {
//                Document doc = Jsoup.connect(urlSpecificTicker).get();
//                Element bodyNode = doc.selectFirst("body");
//                Element iconNode = bodyNode.getElementsByClass("currency-logo-32x32").first();
//                if (iconNode != null) {
//                    String image = iconNode.attr("src");
//                    System.out.println(String.valueOf(i) + " | " + tickerInfo.getId() + " | " + image);
//                    tickerDAO.updateCoinIcon(tickerInfo.getId(), image);
//                }
//            } catch (Exception ex) {
//
//            }
        }
    }

    public void crawlTickersIcon(int page)
    {
        TickerDAO tickerDAO = new TickerDAO();
        List<String> ids = tickerDAO.getAllTickerNames();
        int start = (page - 1)*100;
        int next = page * 100;
        for (int i=start; i<next; i++)
        {
            String id = ids.get(i);
            String urlSpecificTicker = "https://coinmarketcap.com/currencies/"+id+"/#markets";
            try {
                Document doc = Jsoup.connect(urlSpecificTicker).get();
                Element bodyNode = doc.selectFirst("body");
                Element iconNode = bodyNode.getElementsByClass("currency-logo-32x32").first();
                if (iconNode != null) {
                    String image = iconNode.attr("src");
                    tickerDAO.updateCoinIcon(id, image);
                }
            } catch (Exception ex) {

            }
        }
    }
}