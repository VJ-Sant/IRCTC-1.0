<%-- 
    Document   : err
    Created on : Feb 16, 2024, 9:09:21 PM
    Author     : santh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Something went wrong while booking the ticket please try again</h1>
        <%= "hiiiiiiiiiiiiiii" + session.getAttribute("tDate")%>
         <a href="home.jsp">Home</a>
    </body>
</html>
