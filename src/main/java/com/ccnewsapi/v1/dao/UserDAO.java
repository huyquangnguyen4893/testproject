/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.dao;

import com.ccnewsapi.v1.connector.DBConnector;
import com.ccnewsapi.v1.model.BaseObject;
import com.ccnewsapi.v1.model.MetaData;
import com.ccnewsapi.v1.model.User;
import com.ccnewsapi.v1.model.UserInfo;
import com.ccnewsapi.v1.utils.Utils;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author nguyenhuyquang
 */
public class UserDAO {
    private final String collectionName = "Users";
    private final MongoCollection<Document> collection;

    public UserDAO() {
        this.collection = DBConnector.sharedInstance().getCollection(collectionName);
    }
    
    public User getUserInfo(String token, String userId)
    {
        User user = new User();
        try
        {
            Bson filter = Filters.and(Filters.eq("id", userId),Filters.all("tokens", token));
            FindIterable<Document> results = this.collection.find(filter);
            MongoCursor<Document> cursor = results.iterator();
            if (cursor.hasNext())
            {
                Document doc = cursor.next();
                user.parseResultSet(doc);                
            }
            else
            {
                user.makeError(-2, "User info is incorrect. Please try again");
            }
        }catch(Exception ex)
        {
            user.makeError(-1, "Something went wrong. Please try again");
        }
        return user;
    }
    
    public User login(String id, String device_token)
    {
        User user = new User();
        try
        {
            Bson filter = Filters.eq("id", id);
            FindIterable<Document> results = this.collection.find(filter).limit(1);
            MongoCursor<Document> cursor = results.iterator();
            if (cursor.hasNext())
            {
                Document doc = cursor.next();
                user.parseResultSet(doc);
                Date today = new Date();
                long miniseconds = today.getTime();
                String token = Utils.sha256(user.getData().getId() + user.getData().getEmail() + user.getData().getName() + String.valueOf(miniseconds));
                this.collection.findOneAndUpdate(filter, Updates.combine(Updates.addToSet("tokens", token),Updates.addToSet("device_tokens", device_token)));
                user.setToken(token);
            }
            else
            {
                user.makeError(-2, "User info is incorrect. Please try again");
            }
        }catch(Exception ex)
        {
            user.makeError(-1, "Something went wrong. Please try again!");
        }
        return user;
    }
    
    public User insertUser(UserInfo userInfo)
    {
        User user = new User();
        Document doc = new Document();
        doc.put("id", userInfo.getId());
        doc.put("name", userInfo.getName());
        doc.put("email", userInfo.getEmail());
        doc.put("avatar", userInfo.getAvatar());
        doc.put("enable_notification", userInfo.isEnable_notification());
        List<String> deviceTokens = Arrays.asList(userInfo.getToken());
        doc.put("device_tokens", deviceTokens);
        Date today = new Date();
	long miniseconds = today.getTime();
        String token = Utils.sha256(userInfo.getId() + userInfo.getEmail() + userInfo.getName() + String.valueOf(miniseconds));
        List<String> tokens = Arrays.asList(token);
        doc.put("tokens", tokens);
        try
        {
            this.collection.insertOne(doc);
            UserInfo data = new UserInfo(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAvatar(), token, true);
            user.setData(data);
        }
        catch(Exception ex)
        {
            user.makeError(-1, "Something went wrong. Please try again!");
        }
        return user;
    }
    
    public boolean UserIsExist(String id)
    {
        boolean isExist = false;
        try
        {
            Bson filter = Filters.eq("id", id);
            isExist = this.collection.find(filter).iterator().hasNext();
        }catch(Exception ex)
        {
            isExist = false;
        }
        return isExist;
    }
    
    public BaseObject logout(String user_id, String device_token, String token)
    {
        BaseObject response = new BaseObject();
        try
        {
            Bson filters = Filters.eq("id", user_id);
            Bson update = Updates.combine(Updates.pull("device_tokens", device_token),Updates.pull("tokens", token));
            this.collection.findOneAndUpdate(filters, update);
        }catch(Exception ex)
        {
            response.setMeta_data(new MetaData("Something went wrong. Please try again", -1));
        }
        return response;
    }
    
    public boolean tokenIsAuthorized(String token, String user_id)
    {
        try
        {
            Bson filters = Filters.and(Filters.eq("id", user_id),Filters.all("tokens", token));
            return this.collection.find(filters).iterator().hasNext();
        }catch(Exception ex){
            return false;
        }
    }
}
