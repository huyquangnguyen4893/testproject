/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.controller;

import com.ccnewsapi.v1.dao.MarketsDAO;
import com.ccnewsapi.v1.dao.TickerDAO;
import com.ccnewsapi.v1.model.BaseObject;
import com.ccnewsapi.v1.model.TickerPriceChart;
import com.ccnewsapi.v1.model.Tickers;
/**
 *
 * @author nguyenhuyquang
 */
public class MarketController {
    
    public static BaseObject getTickerNames(int page)
    {
        TickerDAO dao = new TickerDAO();
        return dao.getTickerNames(page, 50);
    }
    
    public static BaseObject getTickerPriceInfo(String id)
    {
        MarketsDAO dao = new MarketsDAO();
        return dao.getCoinMarkets(id);
    }
    
    public static BaseObject getTickers(int page)
    {
        TickerDAO dao = new TickerDAO();
        return dao.getTickers(page, 50);
    }
    
    public static Tickers search(String key)
    {
        TickerDAO dao = new TickerDAO();
        return dao.findTickers(key);
    }
    
    public static Tickers getTickerInfo(String id)
    {
        TickerDAO dao = new TickerDAO();
        return dao.getTickerInfo(id);
    }
    
    public static Tickers getTickersInfo(String[] ids)
    {
        TickerDAO dao = new TickerDAO();
        return dao.getTickersInfo(ids);
    }
    
    public static TickerPriceChart get24hPriceChart(String id)
    {
        TickerDAO dao = new TickerDAO();
        return dao.get24hPriceChart(id);
    }
}
