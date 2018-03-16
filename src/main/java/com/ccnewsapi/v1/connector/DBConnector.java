/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.connector;

import com.ccnewsapi.v1.crawler.Crawler;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
/**
 *
 * @author nguyenhuyquang
 */
public class DBConnector {
    
    private String username = "admin";
    private String password = "123456";
    private String host = "localhost";
    private int port = 27017;
    private String dbName = "db_ccnews";
    private MongoDatabase database;
    private static DBConnector instance = null;

    private DBConnector() {
        try 
        {
//            MongoCredential credential = MongoCredential.createCredential(username, dbName, password.toCharArray());
//            MongoClientOptions options = MongoClientOptions.builder().sslEnabled(false).build();
//            MongoClient mongoClient = new MongoClient(new ServerAddress(host, port), credential, options);
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://admin:123456@mongodb/db_ccnews"));
            database = mongoClient.getDatabase(dbName);
        }catch(Exception ex)
        {
            System.out.println(ex.getLocalizedMessage());
        }
//        Crawler.getInstance().beginCrawl();
    }
    
    public static DBConnector sharedInstance()
    {
        if (instance == null)
        {
            instance = new DBConnector();
        }
        return instance;
    }
    
    public MongoCollection<Document> getCollection(String name)
    {
        return database.getCollection(name);
    }
}
