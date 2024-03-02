<%-- 
    Document   : success
    Created on : Feb 16, 2024, 9:09:08 PM
    Author     : santh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(45deg, #ffcc00, #ff66b2, #0099ff, #66ff66); /* Colorful gradient background */
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .content-wrapper {
            text-align: center;
        }
        
        .logo {
           gap: 10px;
            display: flex;
            flex-direction: column;
            position: absolute; top: 20px; align-content:center;}  
    </style>
    <body>
        
         <img src="logo.png" alt="Logo" width="100" height="100" class="logo"/>
   
         <div class="content-wrapper">
            
        <form action="ShowTicketServlet" method="post">
        <h1>Ticket Booked Successfully</h1>
        <input type="submit" value="SHOW TICKET" />
        <h1>  <a href="home.jsp">Home</a></h1>
        
        </form>
               </div>
    </body>
   
</html>
