/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.controller;

import com.ccnewsapi.v1.dao.UserCoinTrackingDAO;
import com.ccnewsapi.v1.model.BaseObject;
import com.ccnewsapi.v1.model.MetaData;
import com.ccnewsapi.v1.model.UserCoinTracking;
import com.ccnewsapi.v1.model.request.SaveCoinTrackingRequestObject;
import javax.ws.rs.core.HttpHeaders;

/**
 *
 * @author nguyenhuyquang
 */
public class TrackingController {
    public static UserCoinTracking getUserCoinsTracking(String user_id, HttpHeaders header)
    {
        if (header.getRequestHeaders().containsKey("token"))
        {
            String token = header.getRequestHeaders().getFirst("token");
            if (IndividualController.checkTokenIsAuthorized(user_id, token))
            {
                UserCoinTrackingDAO dao = new UserCoinTrackingDAO();
        
                return dao.getUserCoinsTracking(user_id);
            }
            else
            {
                return new UserCoinTracking(null, new MetaData("Token is unauthorized", -1));
            }
            
        }
        else
        {
            return new UserCoinTracking(null, new MetaData("Token is unauthorized", -1));
        }
        
    }
    
    public static BaseObject addCoinTracking(String user_id, SaveCoinTrackingRequestObject coin_info, HttpHeaders header)
    {
        if (header.getRequestHeaders().containsKey("token"))
        {
            String token = header.getRequestHeaders().getFirst("token");
            if (IndividualController.checkTokenIsAuthorized(user_id, token))
            {
                UserCoinTrackingDAO dao = new UserCoinTrackingDAO();
        return dao.insertNewCoinToTracking(coin_info, user_id);
            }
            else
            {
                return new BaseObject(new MetaData("Token is unauthorized", -1));
            }
            
        }
        else
        {
            return new BaseObject(new MetaData("Token is unauthorized", -1));
        }
        
    }
    
    public static BaseObject removeCoinFromTracking(String user_id, String coin_id, HttpHeaders header)
    {
        if (header.getRequestHeaders().containsKey("token"))
        {
            String token = header.getRequestHeaders().getFirst("token");
            if (IndividualController.checkTokenIsAuthorized(user_id, token))
            {
                UserCoinTrackingDAO dao = new UserCoinTrackingDAO();
                return dao.removeCoinFromTracking(coin_id, user_id);
            }
            else
            {
                return new BaseObject(new MetaData("Token is unauthorized", -1));
            }
            
        }
        else
        {
            return new BaseObject(new MetaData("Token is unauthorized", -1));
        }
    }
}
