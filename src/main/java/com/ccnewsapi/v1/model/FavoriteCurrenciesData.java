/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.model;

import com.ccnewsapi.v1.model.request.CoinFavoriteInfo;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nguyenhuyquang
 */
public class FavoriteCurrenciesData {
    List<CoinFavoriteInfo> items;

    public FavoriteCurrenciesData() {
        this.items = new LinkedList<>();
    }

    public FavoriteCurrenciesData(List<CoinFavoriteInfo> items) {
        this.items = items;
    }

    public List<CoinFavoriteInfo> getItems() {
        return items;
    }

    public void setItems(List<CoinFavoriteInfo> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "FavoriteCurrenciesData{" + "items=" + items + '}';
    }
    
    
}
