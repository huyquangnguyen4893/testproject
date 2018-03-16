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
public class Tickers extends BaseObject implements BaseInterface{
    public TickersData data;

    public Tickers() {
        super();
        this.data = null;
    }

    public Tickers(TickersData data) {
        this.data = data;
    }

    public TickersData getData() {
        return data;
    }

    public void setData(TickersData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Tickers{" + "data=" + data + '}';
    }

    @Override
    public void parseResultSet(Document rs) {
    }

    @Override
    public void makeError(int code, String message) {
        this.meta_data.setCode(code);
        this.meta_data.setMessage(message);
    }
    
    
}
