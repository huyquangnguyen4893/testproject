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
public class TickerPrice extends BaseObject implements BaseInterface
{
    public TickerPriceData data;

    public TickerPrice() {
        super();
        this.data = null;
    }

    public TickerPrice(TickerPriceData data) {
        super();
        this.data = data;
    }

    public TickerPrice(TickerPriceData data, MetaData meta_data) {
        super(meta_data);
        this.data = data;
    }

    public TickerPriceData getData() {
        return data;
    }

    public void setData(TickerPriceData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TickerPrice{" + "data=" + data + '}';
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
