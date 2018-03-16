/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.model;

import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

/**
 *
 * @author nguyenhuyquang
 */
public class TickersDataInfo {
    String id;
    String name;
    String symbol;
    int rank;
    String price_usd;
    String price_btc;
    String volume_24h_usd;
    String market_cap_usd;
    String available_supply;
    String total_supply;
    String max_supply;
    String percent_change_1h;
    String percent_change_24h;
    String percent_change_7d;
    String last_updated;
    String icon;

    public TickersDataInfo() {
    }

    public TickersDataInfo(String id, String name, String symbol, int rank, String price_usd, String price_btc, String volume_24h_usd, String market_cap_usd, String available_supply, String total_supply, String max_supply, String percent_change_1h, String percent_change_24h, String percent_change_7d, String last_updated, String icon) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.price_usd = price_usd;
        this.price_btc = price_btc;
        this.volume_24h_usd = volume_24h_usd;
        this.market_cap_usd = market_cap_usd;
        this.available_supply = available_supply;
        this.total_supply = total_supply;
        this.max_supply = max_supply;
        this.percent_change_1h = percent_change_1h;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_7d = percent_change_7d;
        this.last_updated = last_updated;
        this.icon = icon;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(String price_usd) {
        this.price_usd = price_usd;
    }

    public String getPrice_btc() {
        return price_btc;
    }

    public void setPrice_btc(String price_btc) {
        this.price_btc = price_btc;
    }

    public String getVolume_24h_usd() {
        return volume_24h_usd;
    }

    public void setVolume_24h_usd(String volume_24h_usd) {
        this.volume_24h_usd = volume_24h_usd;
    }

    public String getMarket_cap_usd() {
        return market_cap_usd;
    }

    public void setMarket_cap_usd(String market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
    }

    public String getAvailable_supply() {
        return available_supply;
    }

    public void setAvailable_supply(String available_supply) {
        this.available_supply = available_supply;
    }

    public String getTotal_supply() {
        return total_supply;
    }

    public void setTotal_supply(String total_supply) {
        this.total_supply = total_supply;
    }

    public String getMax_supply() {
        return max_supply;
    }

    public void setMax_supply(String max_supply) {
        this.max_supply = max_supply;
    }

    public String getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(String percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public String getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(String percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public String getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(String percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return "TickersDataInfo{" + "id=" + id + ", name=" + name + ", symbol=" + symbol + ", rank=" + rank + ", price_usd=" + price_usd + ", price_btc=" + price_btc + ", volume_24h_usd=" + volume_24h_usd + ", market_cap_usd=" + market_cap_usd + ", available_supply=" + available_supply + ", total_supply=" + total_supply + ", max_supply=" + max_supply + ", percent_change_1h=" + percent_change_1h + ", percent_change_24h=" + percent_change_24h + ", percent_change_7d=" + percent_change_7d + ", last_updated=" + last_updated + ", icon=" + icon + '}';
    }
    
    public void parseResponse(Document doc)
    {
        this.id = doc.getString("id");
        this.name = doc.getString("name");
        this.symbol = doc.getString("symbol");
        this.rank = doc.getInteger("rank");
        this.price_usd = doc.getString("price_usd");
        this.price_btc = doc.getString("price_btc");
        this.volume_24h_usd = doc.getString("24h_volume_usd");
        this.market_cap_usd = doc.getString("market_cap_usd");
        this.available_supply = doc.getString("available_supply");
        this.total_supply = doc.getString("total_supply");
        this.max_supply = doc.getString("max_supply");
        this.percent_change_1h = doc.getString("percent_change_1h");
        this.percent_change_24h = doc.getString("percent_change_24h");
        this.percent_change_7d = doc.getString("percent_change_7d");
        this.last_updated = doc.getString("last_updated");
        this.icon = doc.getString("icon");
    }
    
    public void parseJSONObject(JSONObject object)
    {
        this.id = object.get("id") instanceof String ? object.getString("id"):"";
        this.name = object.get("name") instanceof String ?object.getString("name"):"";
        this.symbol = object.get("symbol") instanceof String ?object.getString("symbol"):"";
        this.rank = object.getInt("rank");
        this.price_usd = object.get("price_usd") instanceof String ?object.getString("price_usd"):"";
        this.price_btc = object.get("price_btc") instanceof String ?object.getString("price_btc"):"";
        this.volume_24h_usd = object.get("24h_volume_usd") instanceof String ?object.getString("24h_volume_usd"):"";
        this.market_cap_usd = object.get("market_cap_usd") instanceof String ?object.getString("market_cap_usd"):"";
        this.available_supply = object.get("available_supply") instanceof String ?object.getString("available_supply"):"";
        this.total_supply = object.get("total_supply") instanceof String ?object.getString("total_supply"):"";
        this.max_supply = object.get("max_supply") instanceof String ? object.getString("max_supply"):"";
        this.percent_change_1h = object.get("percent_change_1h") instanceof String ?object.getString("percent_change_1h"):"";
        this.percent_change_24h = object.get("percent_change_24h") instanceof String ?object.getString("percent_change_24h"):"";
        this.percent_change_7d = object.get("percent_change_7d") instanceof String ?object.getString("percent_change_7d"):"";
        this.last_updated = object.get("last_updated") instanceof String ? object.getString("last_updated"):"";
    }
    
    public Document toDocument()
    {
        Document doc = new Document();
        doc.put("id", this.id);
        doc.put("name", this.name);
        doc.put("symbol", this.symbol);
        doc.put("rank", this.rank);
        doc.put("price_usd", this.price_usd);
        doc.put("price_btc", this.price_btc);
        doc.put("24h_volume_usd", this.volume_24h_usd);
        doc.put("market_cap_usd", this.market_cap_usd);
        doc.put("available_supply", this.available_supply);
        doc.put("total_supply", this.total_supply);
        doc.put("max_supply", this.max_supply);
        doc.put("percent_change_1h", this.percent_change_1h);
        doc.put("percent_change_24h", this.percent_change_24h);
        doc.put("percent_change_7d", this.percent_change_7d);
        doc.put("last_updated", this.last_updated);
        doc.put("icon", this.icon);
        return doc;
    }
    public Bson toBsonUpdates()
    {
        Bson updates = Updates.combine(Updates.set("name", this.name),
                Updates.set("symbol", this.symbol),
                Updates.set("rank", this.rank),
                Updates.set("price_usd", this.price_usd),
                Updates.set("price_btc", this.price_btc),
                Updates.set("24h_volume_usd", this.volume_24h_usd),
                Updates.set("market_cap_usd", this.market_cap_usd),
                Updates.set("available_supply", this.available_supply),
                Updates.set("total_supply", this.total_supply),
                Updates.set("max_supply", this.max_supply),
                Updates.set("percent_change_1h", this.percent_change_1h),
                Updates.set("percent_change_24h", this.percent_change_24h),
                Updates.set("percent_change_7d", this.percent_change_7d),
                Updates.set("last_updated", this.last_updated));
        
        return updates;
    }
    public Document toDocumentUpdate()
    {
        Document doc = new Document();
        doc.put("name", this.name);
        doc.put("symbol", this.symbol);
        doc.put("rank", this.rank);
        doc.put("price_usd", this.price_usd);
        doc.put("price_btc", this.price_btc);
        doc.put("24h_volume_usd", this.volume_24h_usd);
        doc.put("market_cap_usd", this.market_cap_usd);
        doc.put("available_supply", this.available_supply);
        doc.put("total_supply", this.total_supply);
        doc.put("max_supply", this.max_supply);
        doc.put("percent_change_1h", this.percent_change_1h);
        doc.put("percent_change_24h", this.percent_change_24h);
        doc.put("percent_change_7d", this.percent_change_7d);
        doc.put("last_updated", this.last_updated);
        return doc;
    }
    
}
