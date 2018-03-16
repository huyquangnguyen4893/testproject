/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.dao;

import com.ccnewsapi.v1.connector.DBConnector;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author nguyenhuyquang
 */
public class PremiumUsersDAO 
{
    private final String collectionName = "PremiumUsers";
    private final MongoCollection<Document> collection;

    public PremiumUsersDAO() {
        this.collection = DBConnector.sharedInstance().getCollection(collectionName);
    }

    public boolean userIsPremium(String user_id)
    {
        boolean isPremium;
        try
        {
            Bson filters = Filters.and(Filters.eq("id", user_id), Filters.eq("is_premium", true));
            isPremium = this.collection.find(filters).iterator().hasNext();
        }catch(Exception ex)
        {
            isPremium = false;
        }
        return isPremium;
    }
    
    public boolean checkAndSetToPremium(String user_id, String receipt)
    {
        return false;
    }
    
}
