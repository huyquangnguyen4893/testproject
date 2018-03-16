/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.dao;

import com.ccnewsapi.v1.connector.DBConnector;
import com.ccnewsapi.v1.model.TickerNames;
import com.ccnewsapi.v1.model.TickerNamesData;
import com.ccnewsapi.v1.model.TickerPriceChart;
import com.ccnewsapi.v1.model.TickerPriceChartData;
import com.ccnewsapi.v1.model.TickerPriceChartDataInfo;
import com.ccnewsapi.v1.model.Tickers;
import com.ccnewsapi.v1.model.TickersData;
import com.ccnewsapi.v1.model.TickersDataInfo;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;


/**
 *
 * @author nguyenhuyquang
 */
public class TickerDAO {
    private final String collectionName = "Tickers";
    private final MongoCollection<Document> collection;

    public TickerDAO() {
        this.collection = DBConnector.sharedInstance().getCollection(collectionName);
    }
    
    public List<String> getAllTickerNames()
    {
        List<String> tickerNames = new LinkedList<>();
        try
        {
            FindIterable<Document> results = this.collection.find().sort(Sorts.ascending("rank"));
            MongoCursor<Document> cursor = results.iterator();
            while(cursor.hasNext())
            {
                Document doc = cursor.next();
                String name = doc.getString("id");
                tickerNames.add(name);
            }
        }catch(Exception ex)
        {
            
        }
        return tickerNames;
    }
    
    public TickerNames getTickerNames(int page, int limit)
    {
        TickerNames response = new TickerNames();
        try
        {
            List<String> tickerNames = new LinkedList<>();
            FindIterable<Document> results = this.collection.find().sort(Sorts.ascending("rank")).skip(page > 0 ? (page - 1)*limit:0).limit(limit);
            MongoCursor<Document> cursor = results.iterator();
            while(cursor.hasNext())
            {
                Document doc = cursor.next();
                String name = doc.getString("symbol");
                tickerNames.add(name);
            }
            response.setData(new TickerNamesData(tickerNames));
        }catch(Exception ex)
        {
            response.makeError(-1, "Something went wrong. Please try again");
        }
        return response;
    }
    
    public Tickers getTickers(int page, int limit)
    {
        Tickers tickers = new Tickers();
        try
        {
            FindIterable<Document> results = collection.find().sort(Sorts.ascending("rank")).skip(page > 0 ? (page - 1)*limit:0).limit(limit);
            MongoCursor<Document> cursor = results.iterator();
            TickersData data = new TickersData();
            while(cursor.hasNext())
            {
                Document doc = cursor.next();
                TickersDataInfo ticker = new TickersDataInfo();
                ticker.parseResponse(doc);
                data.addItem(ticker);
            }
            tickers.setData(data);
        }catch(Exception ex)
        {
            tickers.makeError(-1, "Something went wrong! Please try again later");
        }
        return tickers;
    }
    
    public void insertTickers(List<Document> docs)
    {
        this.collection.insertMany(docs);
    }
    
    public Tickers findTickers(String key)
    {
        Tickers tickers = new Tickers();
        try
        {
            Bson filter = Filters.text(key);
            FindIterable<Document> results = collection.find(filter).sort(Sorts.ascending("rank"));
            MongoCursor<Document> cursor = results.iterator();
            TickersData data = new TickersData();
            while(cursor.hasNext())
            {
                Document doc = cursor.next();
                TickersDataInfo ticker = new TickersDataInfo();
                ticker.parseResponse(doc);
                data.addItem(ticker);
            }
            tickers.setData(data);
        }catch(Exception ex)
        {
            tickers.makeError(-1, "Something went wrong! Please try again later");
        }
        return tickers;
    }
    
    public Tickers getTickersInfo(String[] ids)
    {
        Tickers tickers = new Tickers();
        try
        {
            Bson filter = Filters.in("id", ids);
            FindIterable<Document> results = collection.find(filter);
            MongoCursor<Document> cursor = results.iterator();
            TickersData data = new TickersData();
            while(cursor.hasNext())
            {
                Document doc = cursor.next();
                TickersDataInfo ticker = new TickersDataInfo();
                ticker.parseResponse(doc);
                data.addItem(ticker);
            }
            tickers.setData(data);
        }catch(Exception ex)
        {
            tickers.makeError(-1, "Something went wrong! Please try again later");
        }
        return tickers;
    }
    
    public Tickers getTickerInfo(String id)
    {
        Tickers tickers = new Tickers();
        try
        {
            Bson filter = Filters.eq("id", id);
            FindIterable<Document> results = collection.find(filter);
            MongoCursor<Document> cursor = results.iterator();
            TickersData data = new TickersData();
            if (cursor.hasNext())
            {
                Document doc = cursor.next();
                TickersDataInfo ticker = new TickersDataInfo();
                ticker.parseResponse(doc);
                data.addItem(ticker);
                tickers.setData(data);
            }else
            {
                tickers.setData(new TickersData(new LinkedList<TickersDataInfo>()));
            }
        }catch(Exception ex)
        {
            tickers.makeError(-1, "Something went wrong. Please try again");
        }
        return tickers;
    }
    
    public TickerPriceChart get24hPriceChart(String id)
    {
        TickerPriceChart response = new TickerPriceChart();
        try
        {
            Bson filter = Filters.eq("id", id);
            FindIterable<Document> results = collection.find(filter);
            MongoCursor<Document> cursor = results.iterator();
            TickerPriceChartData data = new TickerPriceChartData();
            while(cursor.hasNext())
            {
                Document doc = cursor.next();
                List<Document> prices = doc.get("prices", List.class);
                Date now = new Date();
                for (Document priceInfo: prices)
                {
                    String time = priceInfo.getString("time");
                    String price = priceInfo.getString("price");
                    DateFormat dateFormat = new SimpleDateFormat("HH dd-MM-yyyy");
                    try
                    {
                        Date date = dateFormat.parse(time);
                        long period = (now.getTime() - date.getTime())/3600000;
                        if (period <= 24 && period >= 0)
                        {
                            TickerPriceChartDataInfo priceDataInfo = new TickerPriceChartDataInfo(time, price);
                            data.addItem(priceDataInfo);
                        }
                    }catch(Exception ex)
                    {
                        
                    }
                }
            }
            response.setData(data);
        }catch(Exception ex)
        {
            response.makeError(-1, "Something went wrong. Please try again");
        }
        return response;
    }
    
    public void updateCoinIcon(String id, String icon)
    {
        try
        {
            Bson filter = Filters.eq("id", id);
            Bson update = Updates.set("icon", icon);
            this.collection.findOneAndUpdate(filter, update);
            
        }catch(Exception ex)
        {
        }
    }
    
    public void updateCoinPriceInfo(String id,Document doc, String time, String price)
    {
        try
        {
            Document prices = new Document();
            prices.put("time", time);
            prices.put("price", price);
            Bson filter = Filters.eq("id", id);
            Bson updates = Updates.combine(doc, Updates.addToSet("prices", prices));
            this.collection.findOneAndUpdate(filter, updates);
        }catch(Exception ex)
        {
            
        }
    }
    
    public void insertOrUpdateTicker(TickersDataInfo ticker)
    {
        try
        {
            String id = ticker.getId();
            Bson filters = Filters.eq("id", id);
            Bson update = ticker.toBsonUpdates();
            if (this.collection.findOneAndUpdate(filters, update) == null)
            {
                Document insertDoc = ticker.toDocument();
                this.collection.insertOne(insertDoc);
            }
        }catch(Exception ex)
        {
            System.out.println("insertOrUpdateTicker: " + ex.getMessage());
        }
    }
    
    
}
