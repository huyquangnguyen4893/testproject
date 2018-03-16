/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.model;

import com.ccnewsapi.v1.model.request.CoinFavoriteInfo;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author nguyenhuyquang
 */
public class FavoriteCurrencies extends BaseObject implements BaseInterface {
    public FavoriteCurrenciesData data;

    public FavoriteCurrencies() {
        super();
        this.data = null;
    }

    public FavoriteCurrencies(FavoriteCurrenciesData data) {
        super();
        this.data = data;
    }

    public FavoriteCurrencies(FavoriteCurrenciesData data, MetaData meta_data) {
        super(meta_data);
        this.data = data;
    }

    @Override
    public void parseResultSet(Document rs) {
        this.data = new FavoriteCurrenciesData();
        List<Document> items = rs.get("items", List.class);
        List<CoinFavoriteInfo> itemsObject = new LinkedList<>();
        for(Document item: items)
        {
            CoinFavoriteInfo itemObject = new CoinFavoriteInfo();
            itemObject.setId(item.getString("id"));
            itemObject.setName(item.getString("name"));
            itemObject.setSymbol(item.getString("symbol"));
            itemObject.setIcon(item.getString("icon"));
            itemsObject.add(itemObject);
        }
        this.data.setItems(itemsObject);
    }

    @Override
    public void makeError(int code, String message) {
        this.meta_data.setCode(code);
        this.meta_data.setMessage(message);
    }

    public FavoriteCurrenciesData getData() {
        return data;
    }

    public void setData(FavoriteCurrenciesData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FavoriteCurrencies{" + "data=" + data + '}';
    }
    
    
}
