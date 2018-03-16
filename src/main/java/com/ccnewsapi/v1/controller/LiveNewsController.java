/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.controller;

import com.ccnewsapi.v1.dao.LiveNewsDAO;
import com.ccnewsapi.v1.model.LiveNews;

/**
 *
 * @author nguyenhuyquang
 */
public class LiveNewsController {
    public static LiveNews getTwitters(int page)
    {
        LiveNewsDAO dao = new LiveNewsDAO();
        return dao.getTwitters(page);
    }
    
    public static LiveNews getFacebookNews(int page)
    {
        LiveNewsDAO dao = new LiveNewsDAO();
        return dao.getFacebookNews(page);
    }
}
