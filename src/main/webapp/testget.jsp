<%-- 
    Document   : testget
    Created on : Mar 16, 2018, 1:57:03 PM
    Author     : nguyenhuyquang
--%>

<%@page import="org.bson.Document"%>
<%@page import="java.util.List"%>
<%@page import="com.huyquang.java.testopenshift.TestDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% TestDAO testDAO = new TestDAO();
        List<Document> list = testDAO.testGet();
        for (Document item: list)
        {
            String key = item.getString("key");
            String value = item.getString("value");
            %>
            <p><h1> key: <%= key %> </h1> <h2> value: <%= value %> </h2></p>
            <%
        }
            %>
    </body>
</html>
