/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nguyenhuyquang
 */
public class TickerPriceChartData {
    List<TickerPriceChartDataInfo> items;

    public TickerPriceChartData() {
        this.items = new LinkedList<>();
    }

    public TickerPriceChartData(List<TickerPriceChartDataInfo> items) {
        this.items = items;
    }

    public List<TickerPriceChartDataInfo> getItems() {
        return items;
    }

    public void setItems(List<TickerPriceChartDataInfo> items) {
        this.items = items;
    }
    
    public void addItem(TickerPriceChartDataInfo item)
    {
        this.items.add(item);
    }

    @Override
    public String toString() {
        return "TickerPriceChartData{" + "items=" + items + '}';
    }
    
    
}
