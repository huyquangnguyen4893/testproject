/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.dao;

import com.ccnewsapi.v1.connector.DBConnector;
import com.ccnewsapi.v1.model.Config;
import com.ccnewsapi.v1.model.ConfigData;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author nguyenhuyquang
 */
public class ConfigDAO {
    
    private final String collectionName = "Config";
    private final MongoCollection<Document> collection;

    public ConfigDAO() {
        collection = DBConnector.sharedInstance().getCollection(collectionName);
    }
    
    public Config getConfig(int version)
    {
        Config config = new Config();
        try
        {
            Bson filter = Filters.eq("version", version);
            FindIterable<Document> result = collection.find(filter);
            MongoCursor<Document> cursor = result.iterator();
            if(cursor.hasNext())
            {
                config.parseResultSet(cursor.next());
            }
            else
            {
                config.setData(new ConfigData());
                this.collection.insertOne(config.toDefaultDocument());
            }
        }catch(Exception ex)
        {
            config.makeError(-1, "Something went wrong! Please try again later");
        }
        return config;
    }
}
