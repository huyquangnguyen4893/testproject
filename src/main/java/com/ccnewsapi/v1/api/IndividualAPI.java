/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.api;

import com.ccnewsapi.v1.controller.IndividualController;
import com.ccnewsapi.v1.model.BaseObject;
import com.ccnewsapi.v1.model.request.CoinFavoriteInfo;
import com.ccnewsapi.v1.model.request.LogoutRequest;
import com.ccnewsapi.v1.model.request.UserLoginRequestObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nguyenhuyquang
 */
@Path("/v1/individual")
public class IndividualAPI {
    
    /** Login
     * 
     * @param userInfo
     * @return 
     */
    @Path("/login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BaseObject login(UserLoginRequestObject userInfo)
    {
        return IndividualController.login(userInfo);
    }
    
    /** Logout
     * 
     * @param user_id
     * @param request
     * @param header
     * @return 
     */
    @Path("/{user_id}/logout")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BaseObject logout(@PathParam("user_id") String user_id, LogoutRequest request, @Context HttpHeaders header)
    {
        return IndividualController.logout(user_id, request.getDevice_token(), header);
    }
    
    /** Get userinfo
     * 
     * @param user_id
     * @param header contain token value
     * @return 
     */
    @Path("/{user_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseObject getUserInfo(@PathParam("user_id") String user_id, @Context HttpHeaders header)
    {
        return IndividualController.getUserInfo(user_id, header);
    }
    
    /** Get favorite currencies
     * 
     * @param user_id
     * @param header
     * @return 
     */
    @Path("/{user_id}/favorites")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseObject getFavoriteCurrencies(@PathParam("user_id") String user_id, @Context HttpHeaders header)
    {
        return IndividualController.getFavorites(user_id, header);
    }
    
    /** Add coin to favorites
     * 
     * @param user_id
     * @param coin_info
     * @param header
     * @return 
     */
    @Path("/{user_id}/favorites")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BaseObject addFavoriteCurrency(@PathParam("user_id") String user_id, CoinFavoriteInfo coin_info, @Context HttpHeaders header)
    {
        return IndividualController.addCoinToFavorites(user_id, coin_info, header);
    }
    
    /** Remove coin from favorites
     * 
     * @param user_id
     * @param coin_id
     * @param header
     * @return 
     */
    @Path("/{user_id}/{coin_id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public BaseObject removeCoinFromFavorites(@PathParam("user_id") String user_id, @PathParam("coin_id") String coin_id, @Context HttpHeaders  header)
    {
        return IndividualController.removeCoinFromFavorites(user_id, coin_id, header);
    }
}
