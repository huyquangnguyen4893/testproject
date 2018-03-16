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
public class UserCoinTrackingData {
    List<UserCoinTrackingInfo> items;

    public UserCoinTrackingData() {
        this.items = new LinkedList<>();
    }

    public UserCoinTrackingData(List<UserCoinTrackingInfo> items) {
        this.items = items;
    }


    public List<UserCoinTrackingInfo> getItems() {
        return items;
    }

    public void setItems(List<UserCoinTrackingInfo> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "UserCoinTrackingData{" + ", items=" + items + '}';
    }
    
    
}
