/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.api;

import com.ccnewsapi.v1.controller.LiveNewsController;
import com.ccnewsapi.v1.model.LiveNews;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nguyenhuyquang
 */
@Path("/v1/livenews")
public class LiveNewsAPI {
    
    /** Get list twitter
     * 
     * @param page
     * @return 
     */
    @Path("/twitter")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public LiveNews getTwitters(@DefaultValue("1") @QueryParam("page") int page)
    {
        return LiveNewsController.getTwitters(page);
    }
    
    /** Get list facebook
     * 
     */
    @Path("/facebook")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public LiveNews getFacebookNews(@DefaultValue("1") @QueryParam("page") int page)
    {
        return LiveNewsController.getFacebookNews(page);
    }
}
