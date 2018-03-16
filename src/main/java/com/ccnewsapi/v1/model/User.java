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
public class User extends BaseObject implements BaseInterface{
    UserInfo data;

    public User() {
        super();
        data = null;
    }

    public User(UserInfo data) {
        this.data = data;
    }

    public User(UserInfo data, MetaData meta_data) {
        super(meta_data);
        this.data = data;
    }

    public UserInfo getData() {
        return data;
    }

    public void setData(UserInfo data) {
        this.data = data;
    }

    public void setToken(String token)
    {
        this.data.setToken(token);
    }
    @Override
    public String toString() {
        return "User{" + "data=" + data + '}';
    }

    @Override
    public void parseResultSet(Document rs) {
        this.data = new UserInfo();
        this.data.setId(rs.getString("id"));
        this.data.setName(rs.getString("name"));
        this.data.setEmail(rs.getString("email"));
        this.data.setAvatar(rs.getString("avatar"));
        this.data.setEnable_notification(rs.getBoolean("enable_notification", true));
        this.data.token = null;
    }

    @Override
    public void makeError(int code, String message) {
        this.data = null;
        this.meta_data.setCode(code);
        this.meta_data.setMessage(message);
    }
    
    
}
