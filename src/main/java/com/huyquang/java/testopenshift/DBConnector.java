/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyquang.java.testopenshift;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
/**
 *
 * @author nguyenhuyquang
 */
public class DBConnector {
    
    private String dbName = "db_ccnews";
    private MongoDatabase database;
    private static DBConnector instance = null;

    private DBConnector() {
        try 
        {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://admin:admin@mongodb/db_ccnews"));
            database = mongoClient.getDatabase(dbName);
        }catch(Exception ex)
        {
            System.out.println(ex.getLocalizedMessage());
        }
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
