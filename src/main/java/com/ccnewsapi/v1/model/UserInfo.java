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
public class UserInfo {
    String id;
    String name;
    String email;
    String avatar;
    String token;
    boolean enable_notification;

    public UserInfo() {
    }

    public UserInfo(String id, String name, String email, String avatar, String token, boolean enable_notification) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
        this.token = token;
        this.enable_notification = enable_notification;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isEnable_notification() {
        return enable_notification;
    }

    public void setEnable_notification(boolean enable_notification) {
        this.enable_notification = enable_notification;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "id=" + id + ", name=" + name + ", email=" + email + ", avatar=" + avatar + ", token=" + token + ", enable_notification=" + enable_notification + '}';
    }
    
    
}
