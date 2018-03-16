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
public class Config extends BaseObject implements BaseInterface{

    public ConfigData data;
    
    public Config() {
        super(); 
        data = null;
    }

    public Config(MetaData meta_data) {
        super(meta_data);
        data = null;
    }

    public ConfigData getData() {
        return data;
    }

    public void setData(ConfigData data) {
        this.data = data;
    }
    
    public Document toDefaultDocument()
    {
        Document doc = new Document();
        doc.put("version", 1);
        doc.put("current_version", 1);
        doc.put("update_status", false);
        doc.put("force_update", false);
        doc.put("publish_status", true);
        doc.put("update_message", "");
        doc.put("maintain_status", false);
        doc.put("maintain_message", "");
        doc.put("ads_enabled", true);
        doc.put("ads_banner_key", "ca-app-pub-9993147662149743/8427633401");
        doc.put("ads_interstitial_key", "ca-app-pub-9993147662149743/7041920611");
        
        return doc;
    }
    
    @Override
    public void parseResultSet(Document rs) {
        this.meta_data = new MetaData();
        data = new ConfigData();
        data.setVersion(rs.getInteger("version", 1));
        data.setCurrent_version(rs.getInteger("current_version", 1));
        data.setUpdate_status(rs.getBoolean("update_status", false));
        data.setForce_update(rs.getBoolean("force_update", false));
        data.setPublish_status(rs.getBoolean("publish_status", true));
        data.setUpdate_message(rs.getString("update_message"));
        data.setMaintain_status(rs.getBoolean("maintain_status", false));
        data.setMaintain_message(rs.getString("maintain_message"));
        data.setAds_enabled(rs.getBoolean("ads_enabled", true));
        data.setAds_banner_key(rs.getString("ads_banner_key"));
        data.setAds_interstitial_key(rs.getString("ads_interstitial_key"));
    }

    @Override
    public void makeError(int code, String message) {
        this.meta_data.setCode(code);
        this.meta_data.setMessage(message);
    }
    
}

