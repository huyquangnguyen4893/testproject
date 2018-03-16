/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.api;

import com.ccnewsapi.v1.controller.ConfigController;
import com.ccnewsapi.v1.model.Config;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author nguyenhuyquang
 */
@Path("/v1/common")
public class CommonAPI {
    
    /** Test API
     * 
     * @return response success
     */
    @Path("/test")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response testGET()
    {
        return Response.status(Response.Status.OK).entity("\"test\":\"success\"").build();
    }
    
    /** Get configs
     * @param version
     * @return 
     */
    @Path("/configs")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Config getConfigs(@DefaultValue("1") @QueryParam("version") int version)
    {
        return ConfigController.getConfig(version);
    }
}
