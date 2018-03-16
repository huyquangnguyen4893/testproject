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
public class TickerNamesData {
    List<String> names;

    public TickerNamesData() {
        this.names = new LinkedList<>();
    }

    public TickerNamesData(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "TickerNamesData{" + "names=" + names + '}';
    }
    
    
}
