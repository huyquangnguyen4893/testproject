/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.api;

import com.ccnewsapi.v1.controller.TrackingController;
import com.ccnewsapi.v1.model.BaseObject;
import com.ccnewsapi.v1.model.request.SaveCoinTrackingRequestObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nguyenhuyquang
 */
@Path("/v1/tracking")
public class TrackingAPI {
    
    /** List Tracking
     * 
     * @param user_id
     * @param header
     * @return 
     */
    @Path("/{user_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseObject getUserTrackingList(@PathParam("user_id") String user_id, @Context HttpHeaders header)
    {
        return TrackingController.getUserCoinsTracking(user_id, header);
    }
    
    /** Search coin to tracking
     * 
     * @param key
     * @return 
     */
    @Path("/search")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseObject searchTracking(@QueryParam("q") String key)
    {
        return new BaseObject();
    }
    
    /** Add coin to Tracking
     * 
     * @param user_id
     * @param requestObject
     * @return 
     */
    @Path("/{user_id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BaseObject saveCoinToTracking(@PathParam("user_id") String user_id, SaveCoinTrackingRequestObject requestObject, @Context HttpHeaders header)
    {
        return TrackingController.addCoinTracking(user_id, requestObject, header);
    }
    
    /** Remove coin from Tracking
     * 
     * @param user_id
     * @param coin_id
     * @param header
     * @return 
     */
    @Path("/{user_id}/{coin_id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BaseObject removeCoinFromTracking(@PathParam("user_id") String user_id, @PathParam("coin_id") String coin_id, @Context HttpHeaders header)
    {
        return TrackingController.removeCoinFromTracking(user_id, coin_id, header);
    }
}
