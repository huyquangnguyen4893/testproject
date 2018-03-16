/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author nguyenhuyquang
 */
public class LiveNewsData {
    public List<HashMap<String, Object>> items;

    public LiveNewsData() {
        items = new LinkedList<>();
    }

    public LiveNewsData(List<HashMap<String, Object>> items) {
        this.items = items;
    }

    public void setItems(List<HashMap<String, Object>> items) {
        this.items = items;
    }

    public List<HashMap<String, Object>> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "LiveNewsData{" + "items=" + items + '}';
    }
    
    public void parseData(Document doc)
    {
        String nickname = doc.getString("nickname");
        String avatar = doc.getString("avatar");
        long timestamp = doc.getLong("timestamp");
        String description = doc.getString("description");
        String translation = doc.getString("translation");
        long sort = doc.getLong("sort");
        String detail_link = doc.getString("detail_link");
        List<HashMap<String, String>> images = doc.get("images", List.class);
        HashMap<String, Object> item = new HashMap<>();
        item.put("nickname", nickname);
        item.put("avatar", avatar);
        item.put("timestamp", timestamp);
        item.put("description", description);
        item.put("translation", translation);
        item.put("sort", sort);
        item.put("detail_link", detail_link);
        item.put("images", images);
        items.add(item);
    }
}
