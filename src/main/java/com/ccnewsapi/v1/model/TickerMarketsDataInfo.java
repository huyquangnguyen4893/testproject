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
public class TickerMarketsDataInfo {
    int order;
    String source;
    String pair;
    String volume_24h;
    String price;
    String volume_percent;

    public TickerMarketsDataInfo() {
    }

    public TickerMarketsDataInfo(int order, String source, String pair, String volume_24h, String price, String volume_percent) {
        this.order = order;
        this.source = source;
        this.pair = pair;
        this.volume_24h = volume_24h;
        this.price = price;
        this.volume_percent = volume_percent;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public String getVolume_24h() {
        return volume_24h;
    }

    public void setVolume_24h(String volume_24h) {
        this.volume_24h = volume_24h;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVolume_percent() {
        return volume_percent;
    }

    public void setVolume_percent(String volume_percent) {
        this.volume_percent = volume_percent;
    }

    @Override
    public String toString() {
        return "TickerMarketsDataInfo{" + "order=" + order + ", source=" + source + ", pair=" + pair + ", volume_24h=" + volume_24h + ", price=" + price + ", volume_percent=" + volume_percent + '}';
    }
    
    
}
