/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.dao;

import com.ccnewsapi.v1.connector.DBConnector;
import com.ccnewsapi.v1.model.BaseObject;
import com.ccnewsapi.v1.model.MetaData;
import com.ccnewsapi.v1.model.UserCoinTracking;
import com.ccnewsapi.v1.model.UserCoinTrackingData;
import com.ccnewsapi.v1.model.request.SaveCoinTrackingRequestObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author nguyenhuyquang
 */
public class UserCoinTrackingDAO {
    private final String collectionName = "UserCoinTracking";
    private final MongoCollection<Document> collection;

    public UserCoinTrackingDAO() {
        this.collection = DBConnector.sharedInstance().getCollection(collectionName);
    }
    
    public UserCoinTracking getUserCoinsTracking(String user_id)
    {
        UserCoinTracking response = new UserCoinTracking();
        try
        {
            Bson filters = Filters.eq("user_id", user_id);
            FindIterable<Document> results = this.collection.find(filters);
            MongoCursor<Document> cursor = results.iterator();
            if(cursor.hasNext())
            {
                Document doc = cursor.next();
                response.parseResultSet(doc);
            }
            else
            {
                response.setData(new UserCoinTrackingData());
            }
        }catch(Exception ex)
        {
            response.makeError(-1, "Something went wrong. Please try again!");
        }
        return response;
    }
    
    public BaseObject insertNewCoinToTracking(SaveCoinTrackingRequestObject coinInfo, String user_id)
    {
        BaseObject response = new BaseObject();
        try
        {
            Bson filters = Filters.eq("user_id", user_id);
            FindIterable<Document> results = this.collection.find(filters);
            if (results.iterator().hasNext())
            {
                Document result = results.iterator().next();
                List<Document> items = result.get("items", List.class);
                if (new PremiumUsersDAO().userIsPremium(user_id))
                {
                    boolean isExist = false;
                    for (Document item: items)
                    {
                        if (item.getString("id").equals(coinInfo.getId()))
                        {
                            isExist = true;
                            break;
                        }
                    }
                    if (isExist)
                    {
                        response.setMeta_data(new MetaData("This coin is in your tracking.", -1));
                    }
                    else
                    {
                        Document item = new Document();
                        item.put("id", coinInfo.getId());
                        item.put("name", coinInfo.getName());
                        item.put("symbol", coinInfo.getSymbol());
                        item.put("icon", coinInfo.getIcon());
                        Bson update = Updates.addToSet("items", item);
                        this.collection.findOneAndUpdate(filters, update);
                        response.setMeta_data(new MetaData());
                    }
                }
                else
                {
                    if (items.size() >= 5)
                    {
                        response.setMeta_data(new MetaData("You has reached to limit. Please upgrade to Premium Account to remove limit tracking coins", -10));
                    }
                    else
                    {
                        Document item = new Document();
                        item.put("id", coinInfo.getId());
                        item.put("name", coinInfo.getName());
                        item.put("symbol", coinInfo.getSymbol());
                        item.put("icon", coinInfo.getIcon());
                        Bson update = Updates.addToSet("items", item);
                        this.collection.findOneAndUpdate(filters, update);
                        response.setMeta_data(new MetaData());
                    }
                }
            }
            else
            {
                Document doc = new Document();
                doc.put("user_id", user_id);
                List<Document> items = new LinkedList<>();
                Document item = new Document();
                item.put("id", coinInfo.getId());
                item.put("name", coinInfo.getName());
                item.put("symbol", coinInfo.getSymbol());
                item.put("icon", coinInfo.getIcon());
                items.add(item);
                doc.put("items", items);
                this.collection.insertOne(doc);
                response.setMeta_data(new MetaData());
            }
        }catch(Exception ex)
        {
            response.setMeta_data(new MetaData("Something went wrong. Please try again!", -1));
        }
        return response;
    }
    
    public BaseObject removeCoinFromTracking(String coin_id, String user_id)
    {
        BaseObject response = new BaseObject();
        try
        {
            Bson filters = Filters.eq("user_id", user_id);
            Bson update = Updates.pull("items", Filters.eq("id", coin_id));
            this.collection.findOneAndUpdate(filters, update);
            response.setMeta_data(new MetaData());
        }catch(Exception ex)
        {
            response.setMeta_data(new MetaData("Something went wrong. Please try again!", -1));
        }
        return response;
    }
}
