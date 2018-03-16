<%-- 
    Document   : test
    Created on : Mar 16, 2018, 1:48:52 PM
    Author     : nguyenhuyquang
--%>

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
           if (testDAO.testAdd())
           {
               %>
               <h1>success</h1>
               <%
           }
           else
           {
               %>
               <h1>fail</h1>
               <%
           }
        %>
        
    </body>
</html>
