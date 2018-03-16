/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.model;

/**
 *
 * @author nguyenhuyquang
 */
public class TickerPriceDataInfo {
    int order;
    String source_name;
    String pair;
    String volume_24h;
    String price;
    String volume_percent;

    public TickerPriceDataInfo(String source_name, String pair, String volume_24h, String price, String volume_percent) {
        this.source_name = source_name;
        this.pair = pair;
        this.volume_24h = volume_24h;
        this.price = price;
        this.volume_percent = volume_percent;
    }

    public TickerPriceDataInfo(int order, String source_name, String pair, String volume_24h, String price, String volume_percent) {
        this.order = order;
        this.source_name = source_name;
        this.pair = pair;
        this.volume_24h = volume_24h;
        this.price = price;
        this.volume_percent = volume_percent;
    }

    public TickerPriceDataInfo() {
    }

    public String getPair() {
        return pair;
    }

    public String getPrice() {
        return price;
    }

    public String getSource_name() {
        return source_name;
    }

    public String getVolume_24h() {
        return volume_24h;
    }

    public String getVolume_percent() {
        return volume_percent;
    }

    public int getOrder() {
        return order;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public void setVolume_24h(String volume_24h) {
        this.volume_24h = volume_24h;
    }

    public void setVolume_percent(String volume_percent) {
        this.volume_percent = volume_percent;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "TickerPriceData{" + "order=" + order + ", source_name=" + source_name + ", pair=" + pair + ", volume_24h=" + volume_24h + ", price=" + price + ", volume_percent=" + volume_percent + '}';
    }

 
    
    
}
