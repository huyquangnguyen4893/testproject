/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.model;

import java.util.List;

/**
 *
 * @author nguyenhuyquang
 */
public class TickerMarketsData {
    List<TickerMarketsDataInfo> markets;

    public TickerMarketsData() {
        this.markets = null;
    }

    public TickerMarketsData(List<TickerMarketsDataInfo> items) {
        this.markets = items;
    }

    public List<TickerMarketsDataInfo> getItems() {
        return markets;
    }

    public void setItems(List<TickerMarketsDataInfo> items) {
        this.markets = items;
    }

    @Override
    public String toString() {
        return "TickerMarketsData{" + "markets=" + markets + '}';
    }
    
    
    
}
