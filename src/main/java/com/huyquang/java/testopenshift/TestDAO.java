/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyquang.java.testopenshift;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author nguyenhuyquang
 */
public class TestDAO {
    private final String collectionName = "Test";
    private final MongoCollection<Document> collection;

    public TestDAO() {
        this.collection = DBConnector.sharedInstance().getCollection(collectionName);
    }
    
    public boolean testAdd()
    {
        Document doc = new Document();
        doc.put("key", "Test");
        doc.put("value", "Quang");
        try
        {
            this.collection.insertOne(doc);
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
    public List<Document> testGet()
    {
        List<Document> response = new LinkedList<>();
        
        try
        {
            FindIterable<Document> results = this.collection.find();
            MongoCursor<Document> cursor = results.iterator();
            while(cursor.hasNext())
            {
                Document doc = cursor.next();
                response.add(doc);
            }
        }catch(Exception ex)
        {
            
        }
        return response;
    }
}
