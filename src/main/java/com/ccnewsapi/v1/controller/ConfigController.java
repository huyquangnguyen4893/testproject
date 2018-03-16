/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.controller;

import com.ccnewsapi.v1.dao.ConfigDAO;
import com.ccnewsapi.v1.model.Config;

/**
 *
 * @author nguyenhuyquang
 */
public class ConfigController {
    public static Config getConfig(int version)
    {
        ConfigDAO dao = new ConfigDAO();
        return dao.getConfig(version);
    }
}
