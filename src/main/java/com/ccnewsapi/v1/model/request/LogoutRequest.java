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
public class LogoutRequest {
    String device_token;

    public LogoutRequest() {
    }

    public LogoutRequest(String device_token) {
        this.device_token = device_token;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

    @Override
    public String toString() {
        return "LogoutRequest{" + "device_token=" + device_token + '}';
    }
    
    
}
