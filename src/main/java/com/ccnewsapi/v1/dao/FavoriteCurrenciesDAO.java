/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.dao;

import com.ccnewsapi.v1.connector.DBConnector;
import com.ccnewsapi.v1.model.BaseObject;
import com.ccnewsapi.v1.model.FavoriteCurrencies;
import com.ccnewsapi.v1.model.FavoriteCurrenciesData;
import com.ccnewsapi.v1.model.MetaData;
import com.ccnewsapi.v1.model.request.CoinFavoriteInfo;
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
public class FavoriteCurrenciesDAO {
    
    private final String collectionName = "FavoriteCurrencies";
    private final MongoCollection<Document> collection;

    public FavoriteCurrenciesDAO() {
        this.collection = DBConnector.sharedInstance().getCollection(collectionName);
    }
    
    public FavoriteCurrencies getUserFavorites(String user_id)
    {
        FavoriteCurrencies response = new FavoriteCurrencies();
        try
        {
            Bson filters = Filters.eq("user_id", user_id);
            FindIterable<Document> results = this.collection.find(filters);
            MongoCursor<Document> cursor = results.iterator();
            if (cursor.hasNext())
            {
                Document doc = cursor.next();
                response.parseResultSet(doc);
            }
            else
            {
                response.setData(new FavoriteCurrenciesData());
            }
        }catch(Exception ex)
        {
            response.makeError(-1, "Something went wrong. Please try again!");
        }
        return response;
    }
    
    public BaseObject addCoinToFavorite(String user_id, CoinFavoriteInfo coin_info)
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
                boolean isExist = false;
                for (Document item: items)
                {
                    if (item.getString("id").equals(coin_info.getId()))
                    {
                        isExist = true;
                        break;
                    }
                }
                if (isExist)
                {
                    response.setMeta_data(new MetaData("This coin was added to your tracking before.", -1));
                }
                else
                {
                    Document item = new Document();
                    item.put("id", coin_info.getId());
                    item.put("name", coin_info.getName());
                    item.put("symbol", coin_info.getSymbol());
                    item.put("icon", coin_info.getIcon());
                    Bson update = Updates.addToSet("items", item);
                    this.collection.findOneAndUpdate(filters, update);
                }
            }
            else
            {
                Document doc = new Document();
                doc.put("user_id", user_id);
                List<Document> items = new LinkedList<>();
                Document item = new Document();
                item.put("id", coin_info.getId());
                item.put("name", coin_info.getName());
                item.put("symbol", coin_info.getSymbol());
                item.put("icon", coin_info.getIcon());
                items.add(item);
                doc.put("items", items);
                this.collection.insertOne(doc);
            }
        }catch(Exception ex)
        {
            response.setMeta_data(new MetaData("Something went wrong. Please try again!", -1));
        }
        return response;
    }
    
    public BaseObject removeCoinFromFavorite(String user_id, String coin_id)
    {
        BaseObject response = new BaseObject();
        try
        {
            Bson filters = Filters.eq("user_id", user_id);
            Bson update = Updates.pull("items", Filters.eq("id", coin_id));
            this.collection.findOneAndUpdate(filters, update);
        }catch(Exception ex)
        {
            response.setMeta_data(new MetaData("Something went wrong. Please try again!", -1));
        }
                    
        return response;
    }
}
