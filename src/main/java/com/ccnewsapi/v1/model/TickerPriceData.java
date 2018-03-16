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
public class TickerPriceData {
    List<TickerPriceDataInfo> items;

    public TickerPriceData() {
        items = new LinkedList<>();
    }

    public TickerPriceData(List<TickerPriceDataInfo> items) {
        this.items = items;
    }

    public List<TickerPriceDataInfo> getItems() {
        return items;
    }

    public void setItems(List<TickerPriceDataInfo> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "TickerPriceData{" + "items=" + items + '}';
    }
    
    public void addItem(TickerPriceDataInfo item)
    {
        this.items.add(item);
    }
}
