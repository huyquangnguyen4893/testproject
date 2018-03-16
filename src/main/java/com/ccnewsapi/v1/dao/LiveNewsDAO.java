/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.dao;

import com.ccnewsapi.v1.connector.DBConnector;
import com.ccnewsapi.v1.model.LiveNews;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

/**
 *
 * @author nguyenhuyquang
 */
public class LiveNewsDAO {
    private final String twitterCollectionName = "LiveTwitterNews";
    private final MongoCollection<Document> twitterCollection;
    private final String facebookCollectionName = "LiveFacebookNews";
    private final MongoCollection<Document> facebookCollection;

    public LiveNewsDAO() {
        this.twitterCollection = DBConnector.sharedInstance().getCollection(twitterCollectionName);
        this.facebookCollection = DBConnector.sharedInstance().getCollection(facebookCollectionName);
    }
    
    public LiveNews getTwitters(int page)
    {
        LiveNews liveNews = new LiveNews();
        try
        {
            FindIterable<Document> results = twitterCollection.find().skip(page > 0 ? (page - 1)*25:0).limit(25);
            MongoCursor<Document> cursor = results.iterator();
            while(cursor.hasNext())
            {
                Document result = cursor.next();
                liveNews.parseResultSet(result);
            }
        }catch(Exception ex)
        {
            liveNews.makeError(-1, "Something went wrong! Please try again later");
        }
        return liveNews;
    }
    
    public LiveNews getFacebookNews(int page)
    {
        LiveNews liveNews = new LiveNews();
        try
        {
            FindIterable<Document> results = facebookCollection.find().skip(page > 0 ? (page - 1)*25:0).limit(25);
            MongoCursor<Document> cursor = results.iterator();
            while(cursor.hasNext())
            {
                Document result = cursor.next();
                liveNews.parseResultSet(result);
            }
        }catch(Exception ex)
        {
            liveNews.makeError(-1, "Something went wrong! Please try again later");
        }
        return liveNews;
    }
}
