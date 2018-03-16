<%-- 
    Document   : crawlTickerIcons
    Created on : Mar 16, 2018, 3:32:59 PM
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
        <% if (request.getParameter("page") != null)
        {
            int pageNumber = Integer.parseInt(request.getParameter("page"));
            Crawler crawler = new Crawler();
            crawler.crawlTickersIcon(pageNumber);
        }else
        {
            int pageNumber = 1;
            Crawler crawler = new Crawler();
            crawler.crawlTickersIcon(pageNumber);
        }
        %>
        <h1>Done</h1>
    </body>
</html>
