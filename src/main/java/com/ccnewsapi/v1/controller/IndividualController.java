/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.controller;

import com.ccnewsapi.v1.connector.HTTPSConnector;
import com.ccnewsapi.v1.dao.FavoriteCurrenciesDAO;
import com.ccnewsapi.v1.dao.UserDAO;
import com.ccnewsapi.v1.model.BaseObject;
import com.ccnewsapi.v1.model.FavoriteCurrencies;
import com.ccnewsapi.v1.model.MetaData;
import com.ccnewsapi.v1.model.User;
import com.ccnewsapi.v1.model.UserInfo;
import com.ccnewsapi.v1.model.request.CoinFavoriteInfo;
import com.ccnewsapi.v1.model.request.UserLoginRequestObject;
import javax.ws.rs.core.HttpHeaders;
import org.json.JSONObject;

/**
 *
 * @author nguyenhuyquang
 */
public class IndividualController {
//    public static void main(String[] args) {
//        login(new UserLoginRequestObject("EAAa5DyR25cYBAI06JFZC9V5qeZCasEfmqZB5taBUjGrCVz3V5kiuuFLOK12zkVvbUGaDBn3V88xVW9nmmcxJXgAZAuF6HP0XZAawBQO49VCwB9FvFfxZAZB59tU0lu5xpqEjt3gMpuCNZBgN6wZCh54lsn5P3baYN8vJFqqgrfW3c6fZC90OkVdKndQQZCYZCO0slVHQWZBRJ0ZAUPmAZDZD", "abc", "1600999946651939"));
//    }
    public static User login(UserLoginRequestObject request)
    {
        String device_token = request.getDevice_token();
        String access_token = request.getAccess_token();
        String userID = request.getUser_id();
        
        String urlGraphFB = "https://graph.facebook.com/me?fields=id,name,email,picture.type(large).width(320)&access_token=" + access_token;
        String userInfoString = HTTPSConnector.GETRequest(urlGraphFB);
        JSONObject jsonObject = new JSONObject(userInfoString);
        String retrievedID = jsonObject.getString("id");
        String name = jsonObject.getString("name");
        String email = jsonObject.getString("email");
        JSONObject picture = jsonObject.getJSONObject("picture");
        JSONObject pictureData = picture.getJSONObject("data");
        String avatar = pictureData.getString("url");
        
        UserDAO dao = new UserDAO();
        User response = new User();
        if (dao.UserIsExist(userID) && retrievedID.equals(userID))
        {
            response = dao.login(retrievedID,device_token);
        }
        else if (retrievedID.equals(userID))
        {
            UserInfo userInfo = new UserInfo(retrievedID, name, email, avatar, device_token, true);
            response = dao.insertUser(userInfo);
        }
        else
        {
            response.makeError(-1, "User info is incorrect! Please try again");
        }
        return response;
    }
    
    public static BaseObject logout(String user_id, String device_token, HttpHeaders header)
    {
        if (header.getRequestHeaders().containsKey("token"))
        {
            String token = header.getRequestHeaders().getFirst("token");
            if (IndividualController.checkTokenIsAuthorized(user_id, token))
            {
                UserDAO dao = new UserDAO();
                return dao.logout(user_id, device_token, token);
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
    
    public static User getUserInfo(String userID, HttpHeaders header)
    {
        String token = null;
        if (header.getRequestHeaders().containsKey("token"))
        {
            token = header.getRequestHeaders().getFirst("token");
        }
        UserDAO dao = new UserDAO();
        return dao.getUserInfo(token, userID);
    }
    
    public static boolean checkTokenIsAuthorized(String user_id, String token)
    {
        boolean authorized = false;
        UserDAO dao = new UserDAO();
        authorized = dao.tokenIsAuthorized(token, user_id);
        return authorized;
    }
    
    public static FavoriteCurrencies getFavorites(String user_id, HttpHeaders header)
    {
        if (header.getRequestHeaders().containsKey("token"))
        {
            String token = header.getRequestHeaders().getFirst("token");
            if (IndividualController.checkTokenIsAuthorized(user_id, token))
            {
                FavoriteCurrenciesDAO dao = new FavoriteCurrenciesDAO();
                return dao.getUserFavorites(user_id);
            }
            else
            {
                return new FavoriteCurrencies(null, new MetaData("Token is unauthorized", -1));
            }
            
        }
        else
        {
            return new FavoriteCurrencies(null, new MetaData("Token is unauthorized", -1));
        }
        
    }
    
    public static BaseObject addCoinToFavorites(String user_id, CoinFavoriteInfo coin_info, HttpHeaders header)
    {
        if (header.getRequestHeaders().containsKey("token"))
        {
            String token = header.getRequestHeaders().getFirst("token");
            if (IndividualController.checkTokenIsAuthorized(user_id, token))
            {
                FavoriteCurrenciesDAO dao = new FavoriteCurrenciesDAO();
                return dao.addCoinToFavorite(user_id, coin_info);
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
    
    public static BaseObject removeCoinFromFavorites(String user_id, String coin_id, HttpHeaders header)
    {
        if (header.getRequestHeaders().containsKey("token"))
        {
            String token = header.getRequestHeaders().getFirst("token");
            if (IndividualController.checkTokenIsAuthorized(user_id, token))
            {
                FavoriteCurrenciesDAO dao = new FavoriteCurrenciesDAO();
                return dao.removeCoinFromFavorite(user_id, coin_id);
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
