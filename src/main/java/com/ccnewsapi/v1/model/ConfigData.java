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
public class ConfigData {
    private int version = 1;
    private int current_version = 1;
    private boolean publish_status = true;
    private boolean update_status = false;
    private boolean force_update = false;
    private String update_message = "";
    private boolean maintain_status = false;
    private String maintain_message = "";
    private boolean ads_enabled = true;
    private String ads_banner_key = "ca-app-pub-9993147662149743/8427633401";
    private String ads_interstitial_key = "ca-app-pub-9993147662149743/7041920611";

    public ConfigData() {
    }

    public ConfigData(int version, int current_version, boolean publish_status, boolean update_status, boolean force_update, String update_message, boolean maintain_status, String maintain_message) {
        this.version = version;
        this.current_version = current_version;
        this.publish_status = publish_status;
        this.update_status = update_status;
        this.force_update = force_update;
        this.update_message = update_message;
        this.maintain_status = maintain_status;
        this.maintain_message = maintain_message;
    }

    public ConfigData(int version, int current_version, boolean publish_status, boolean update_status, boolean force_update, String update_message, boolean maintain_status, String maintain_message, boolean ads_enabled, String ads_banner_key, String ads_interstitial_key) {
        this.version = version;
        this.current_version = current_version;
        this.publish_status = publish_status;
        this.update_status = update_status;
        this.force_update = force_update;
        this.update_message = update_message;
        this.maintain_status = maintain_status;
        this.maintain_message = maintain_message;
        this.ads_enabled = ads_enabled;
        this.ads_banner_key = ads_banner_key;
        this.ads_interstitial_key = ads_interstitial_key;
    }
    

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getCurrent_version() {
        return current_version;
    }

    public void setCurrent_version(int current_version) {
        this.current_version = current_version;
    }

    public boolean isPublish_status() {
        return publish_status;
    }

    public void setPublish_status(boolean publish_status) {
        this.publish_status = publish_status;
    }

    public boolean isUpdate_status() {
        return update_status;
    }

    public void setUpdate_status(boolean update_status) {
        this.update_status = update_status;
    }

    public boolean isForce_update() {
        return force_update;
    }

    public void setForce_update(boolean force_update) {
        this.force_update = force_update;
    }

    public String getUpdate_message() {
        return update_message;
    }

    public void setUpdate_message(String update_message) {
        this.update_message = update_message;
    }

    public boolean isMaintain_status() {
        return maintain_status;
    }

    public void setMaintain_status(boolean maintain_status) {
        this.maintain_status = maintain_status;
    }

    public String getMaintain_message() {
        return maintain_message;
    }

    public void setMaintain_message(String maintain_message) {
        this.maintain_message = maintain_message;
    }

    public boolean isAds_enabled() {
        return ads_enabled;
    }

    public void setAds_enabled(boolean ads_enabled) {
        this.ads_enabled = ads_enabled;
    }

    public String getAds_banner_key() {
        return ads_banner_key;
    }

    public void setAds_banner_key(String ads_banner_key) {
        this.ads_banner_key = ads_banner_key;
    }

    public String getAds_interstitial_key() {
        return ads_interstitial_key;
    }

    public void setAds_interstitial_key(String ads_interstitial_key) {
        this.ads_interstitial_key = ads_interstitial_key;
    }

    @Override
    public String toString() {
        return "ConfigData{" + "version=" + version + ", current_version=" + current_version + ", publish_status=" + publish_status + ", update_status=" + update_status + ", force_update=" + force_update + ", update_message=" + update_message + ", maintain_status=" + maintain_status + ", maintain_message=" + maintain_message + ", ads_enabled=" + ads_enabled + ", ads_banner_key=" + ads_banner_key + ", ads_interstitial_key=" + ads_interstitial_key + '}';
    }

    
    
    
    
}
