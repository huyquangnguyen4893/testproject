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
public class UserCoinTracking extends BaseObject implements BaseInterface{
    UserCoinTrackingData data;

    public UserCoinTracking() {
        super();
        this.data = null;
    }

    public UserCoinTracking(UserCoinTrackingData data) {
        super();
        this.data = data;
    }

    public UserCoinTracking(UserCoinTrackingData data, MetaData meta_data) {
        super(meta_data);
        this.data = data;
    }

    
    @Override
    public void parseResultSet(Document rs) {
        if (rs.containsKey("items"))
        {
            List<Document> items = rs.get("items", List.class);
            List<UserCoinTrackingInfo> itemInfos = new LinkedList<>();
            for (Document item: items)
            {
                String id = item.getString("id");
                String name = item.getString("name");
                String symbol = item.getString("symbol");
                String icon = item.getString("icon");
                UserCoinTrackingInfo itemInfo = new UserCoinTrackingInfo(id, name, symbol, icon);
                itemInfos.add(itemInfo);
            }
            this.data = new UserCoinTrackingData(itemInfos);
        }
        else
        {
            this.data = new UserCoinTrackingData();
        }
    }

    @Override
    public void makeError(int code, String message) {
        this.meta_data.setCode(code);
        this.meta_data.setMessage(message);
    }

    public UserCoinTrackingData getData() {
        return data;
    }

    public void setData(UserCoinTrackingData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserCoinTracking{" + "data=" + data + '}';
    }
    
    
}
