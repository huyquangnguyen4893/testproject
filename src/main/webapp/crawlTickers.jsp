<%-- 
    Document   : crawlTickers
    Created on : Mar 16, 2018, 3:32:46 PM
    Author     : nguyenhuyquang
--%>

<%@page import="com.ccnewsapi.v1.crawler.Crawler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Crawler crawler = new Crawler();
        crawler.crawlTickers();
        %>
        <h1>Done</h1>
    </body>
</html>
