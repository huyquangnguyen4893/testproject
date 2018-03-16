/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccnewsapi.v1.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author nguyenhuyquang
 */
public class HTTPSConnector {

    public static String GETRequest(String url) {
        String response = "";
        URL url_request;
        try {
            url_request = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection) url_request.openConnection();
            if (connection != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String input;
                while ((input = br.readLine()) != null) {
                    response += input;
                }
                br.close();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
