/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.model.request;

/**
 *
 * @author nguyenhuyquang
 */
public class UserLoginRequestObject {
    String access_token;
    String device_token;
    String user_id;

    public UserLoginRequestObject() {
    }

    public UserLoginRequestObject(String access_token, String device_token, String user_id) {
        this.access_token = access_token;
        this.device_token = device_token;
        this.user_id = user_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getDevice_token() {
        return device_token;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "UserLoginRequestObject{" + "access_token=" + access_token + ", device_token=" + device_token + ", user_id=" + user_id + '}';
    }
    
    
}
