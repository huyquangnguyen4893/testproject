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
public class UserCoinTrackingInfo {
    String id;
    String name;
    String symbol;
    String icon;

    public UserCoinTrackingInfo() {
    }

    public UserCoinTrackingInfo(String id, String name, String symbol, String icon) {
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
        return "UserCoinTrackingInfo{" + "id=" + id + ", name=" + name + ", symbol=" + symbol + ", icon=" + icon + '}';
    }
    
    
}
