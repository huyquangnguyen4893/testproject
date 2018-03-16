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
public class LiveNews extends BaseObject implements BaseInterface{

    public LiveNewsData data;

    public LiveNews() {
        super();
        data = null;
    }

    public LiveNews(LiveNewsData data) {
        super();
        this.data = data;
    }

    public LiveNews(LiveNewsData data, MetaData meta_data) {
        super(meta_data);
        this.data = data;
    }

    public LiveNewsData getData() {
        return data;
    }

    public void setData(LiveNewsData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Twitter{" + "data=" + data + '}';
    }
    
    
    
    @Override
    public void parseResultSet(Document rs) {
        if (data == null)
        {
            data = new LiveNewsData();
        }
        data.parseData(rs);
        this.meta_data = new MetaData();
    }

    @Override
    public void makeError(int code, String message) {
        this.meta_data.setCode(code);
        this.meta_data.setMessage(message);
    }
    
}
