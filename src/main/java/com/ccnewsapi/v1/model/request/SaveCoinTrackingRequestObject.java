/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.model.request;

/**
 *
 * @author nguyenhuyquang
 */
public class SaveCoinTrackingRequestObject {
    String id;
    String name;
    String symbol;
    String icon;

    public SaveCoinTrackingRequestObject() {
    }

    public SaveCoinTrackingRequestObject(String id, String name, String symbol, String icon) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "SaveCoinTrackingRequestObject{" + "id=" + id + ", name=" + name + ", symbol=" + symbol + ", icon=" + icon + '}';
    }
    
    
}
