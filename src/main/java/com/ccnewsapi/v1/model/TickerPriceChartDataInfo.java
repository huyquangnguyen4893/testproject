/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.model;

import org.bson.Document;

/**
 *
 * @author nguyenhuyquang
 */
public class TickerPriceChartDataInfo {
    String time;
    String price;

    public TickerPriceChartDataInfo() {
    }

    public TickerPriceChartDataInfo(String time, String price) {
        this.time = time;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public String getTime() {
        return time;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TickerPriceChartDataInfo{" + "time=" + time + ", price=" + price + '}';
    }
    
    public void parseResponse(Document doc)
    {
        this.time = doc.getString("time");
        this.price = doc.getString("price");
    }
}
