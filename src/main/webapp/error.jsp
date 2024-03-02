<%-- 
    Document   : error
    Created on : Feb 10, 2024, 12:38:16 PM
    Author     : santh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
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
</head>
<body>
    <img src="logo.png" alt="Logo" width="100" height="100" class="logo"/>
    <div class="content-wrapper">
        <h1>No Intermediate Trains</h1>
        <h1>  <a href="home.jsp">Home</a></h1>
    </div>
</body>
</html>
