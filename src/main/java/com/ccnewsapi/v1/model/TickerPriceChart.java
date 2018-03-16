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
public class TickerPriceChart extends BaseObject implements BaseInterface {
    
    TickerPriceChartData data;

    public TickerPriceChart() {
        super();
        this.data = null;
    }

    public TickerPriceChart(TickerPriceChartData data) {
        super();
        this.data = data;
    }

    public TickerPriceChart(TickerPriceChartData data, MetaData meta_data) {
        super(meta_data);
        this.data = data;
    }

    public TickerPriceChartData getData() {
        return data;
    }

    public void setData(TickerPriceChartData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TickerPriceChart{" + "data=" + data + '}';
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
