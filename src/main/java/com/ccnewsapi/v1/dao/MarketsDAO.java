/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.dao;

import com.ccnewsapi.v1.connector.DBConnector;
import com.ccnewsapi.v1.model.TickerMarkets;
import com.ccnewsapi.v1.model.TickerMarketsData;
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
public class MarketsDAO {
    private final String collectionName = "CoinMarkets";
    private final MongoCollection<Document> collection;

    public MarketsDAO() {
        this.collection = DBConnector.sharedInstance().getCollection(collectionName);
    }
    
    public void insertNewMarket(Document doc)
    {
        try
        {
            this.collection.insertOne(doc);
        }catch(Exception ex)
        {
            
        }
    }
    
    public TickerMarkets getCoinMarkets(String id)
    {
        TickerMarkets response = new TickerMarkets();
        try
        {
            Bson filter = Filters.eq("id", id);
            FindIterable<Document> results = this.collection.find(filter);
            MongoCursor<Document> cursor = results.iterator();
            if (cursor.hasNext())
            {
                Document doc = cursor.next();
                response.parseResultSet(doc);
            }else
            {
                response.setData(new TickerMarketsData());
            }
        }catch(Exception ex)
        {
            response.makeError(-1, "Something went wrong. Please try again");
        }
        return response;
    }
}
