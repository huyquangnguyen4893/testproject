/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.model;

/**
 *
 * @author nguyenhuyquang
 */
public class BaseObject {
    protected MetaData meta_data;

    public BaseObject(MetaData meta_data) {
        this.meta_data = meta_data;
    }

    public BaseObject() {
        this.meta_data = new MetaData();
    }
    
    public MetaData getMeta_data() {
        return meta_data;
    }

    public void setMeta_data(MetaData meta_data) {
        this.meta_data = meta_data;
    }

    
    @Override
    public String toString() {
        return "BaseObject{" + "meta_data=" + meta_data + '}';
    }
    
    
}
