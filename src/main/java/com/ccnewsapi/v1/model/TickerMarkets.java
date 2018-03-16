/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.model;

import java.util.LinkedList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author nguyenhuyquang
 */
public class TickerMarkets extends BaseObject implements BaseInterface{

    TickerMarketsData data;

    public TickerMarkets() {
        super();
        this.data = null;
    }

    public TickerMarkets(TickerMarketsData data) {
        super();
        this.data = data;
    }

    public TickerMarkets(TickerMarketsData data, MetaData meta_data) {
        super(meta_data);
        this.data = data;
    }

    public TickerMarketsData getData() {
        return data;
    }

    public void setData(TickerMarketsData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TickerMarkets{" + "data=" + data + '}';
    }
    
    
    @Override
    public void parseResultSet(Document rs) {
        this.data = new TickerMarketsData();
        List<Document> docMarkets = rs.get("markets", List.class);
        List<TickerMarketsDataInfo> markets = new LinkedList<>();
        for (Document docMarket: docMarkets)
        {
            int order = docMarket.getInteger("order");
            String source = docMarket.getString("source");
            String pair = docMarket.getString("pair");
            String volume_24h = docMarket.getString("volume_24h");
            String price = docMarket.getString("price");
            String volume_percent = docMarket.getString("volume_percent");
            TickerMarketsDataInfo market = new TickerMarketsDataInfo(order, source, pair, volume_24h, price, volume_percent);
            markets.add(market);
        }
        this.data.setItems(markets);
    }

    @Override
    public void makeError(int code, String message) {
        this.meta_data.setCode(code);
        this.meta_data.setMessage(message);
    }
    
}
