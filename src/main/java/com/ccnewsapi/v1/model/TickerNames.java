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
public class TickerNames extends BaseObject implements BaseInterface{

    TickerNamesData data;

    public TickerNames() {
        super();
        this.data = null;
    }

    public TickerNames(TickerNamesData data) {
        super();
        this.data = data;
    }

    public TickerNames(TickerNamesData data, MetaData meta_data) {
        super(meta_data);
        this.data = data;
    }

    public TickerNamesData getData() {
        return data;
    }

    public void setData(TickerNamesData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TickerNames{" + "data=" + data + '}';
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
