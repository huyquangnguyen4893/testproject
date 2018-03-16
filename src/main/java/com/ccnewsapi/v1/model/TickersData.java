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
public class TickersData {
    List<TickersDataInfo> items;

    public TickersData() {
        this.items = new LinkedList<>();
    }

    public TickersData(List<TickersDataInfo> items) {
        this.items = items;
    }

    public List<TickersDataInfo> getItems() {
        return items;
    }

    public void setItems(List<TickersDataInfo> items) {
        this.items = items;
    }
    
    public void addItem(TickersDataInfo item)
    {
        this.items.add(item);
    }

    @Override
    public String toString() {
        return "TickersData{" + "items=" + items + '}';
    }
    
    public List<Document> toListDocs()
    {
        List<Document> docs = new LinkedList<>();
        for (TickersDataInfo ticker: items)
        {
            docs.add(ticker.toDocument());
        }
        return docs;
    }
}
