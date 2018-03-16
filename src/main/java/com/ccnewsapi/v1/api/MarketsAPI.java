/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.api;

import com.ccnewsapi.v1.controller.MarketController;
import com.ccnewsapi.v1.model.BaseObject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nguyenhuyquang
 */
@Path("/v1/markets")
public class MarketsAPI {
    
    /** Get ticker names
     * 
     * @param page
     * @return 
     */
    @Path("/tickers/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseObject getTickerNames(@DefaultValue("1") @QueryParam("page") int page)
    {
        return MarketController.getTickers(page);
    }
    
    /** Get tickers
     * 
     * @param page
     * @return 
     */
//    @Path("/tickers")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public BaseObject getTickers(@DefaultValue("1") @QueryParam("page") int page)
//    {
//        return MarketController.getTickers(page);
//    }
    
    /** Get tickers price info with ids
     * 
     * @param ids
     * @return 
     */
    @Path("/tickers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseObject getTickersInfo(@QueryParam("ids") String ids)
    {
        String[] idsList = ids.split(",");
        return MarketController.getTickersInfo(idsList);
    }
    
    /** Get specific ticker price info
     * 
     * @param id
     * @return 
     */
    @Path("/tickers/{id}/info")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseObject getSpecificTickerInfo(@PathParam("id") String id)
    {
        return MarketController.getTickerInfo(id);
    }
    
    /** Get specific ticker markets
     * 
     * @param id
     * @return 
     */
    @Path("/tickers/{id}/markets")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseObject getSpecificTickerMarkets(@PathParam("id") String id)
    {
        return MarketController.getTickerPriceInfo(id);
    }
    
    /** Get chart for specific ticker
     * 
     * @param id
     * @return 
     */
    @Path("/tickers/{id}/24h_price_chart")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseObject getChartForSpecificTicker(@PathParam("id") String id)
    {
        return MarketController.get24hPriceChart(id);
    }
    
    /** Search ticker
     * 
     * @param key
     * @return 
     */
    @Path("/tickers/search")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseObject searchTicker(@QueryParam("q") String key)
    {
        return MarketController.search(key);
    }
}
