<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Ticket</title>
    <style>
         body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(45deg, #ffcc00, #ff66b2, #0099ff, #66ff66); /* Colorful gradient background */
            height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start; /* Align at the start of the page */
            position: relative; /* Add position relative to make absolute positioning work */
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: 20px; /* Add margin for spacing */
        }
        p {
            margin-bottom: 10px;
        }
        input[type="number"], select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            margin-top: 10px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Book Ticket</h1>
    <% 
        // Retrieving parameters from request
        String trainId = request.getParameter("trainId");
        String trainName =  request.getParameter("trainName");
        String from =  request.getParameter("from");
        String to =  request.getParameter("to");
        String departureTime =  request.getParameter("departureTime");
        String travelDate=request.getParameter("travelDate");
       

        // Getting current date and time
        java.time.LocalDateTime currentDateTime = java.time.LocalDateTime.now();
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
    %>
    <p>You are booking a ticket for train <%= trainName %> (Train ID: <%= trainId %>)</p>
    <p>Current Date and Time: <%= formattedDateTime %></p>
    <!-- Add form for entering booking details -->
    <form action="TicketServlet" method="post">
        <input type="hidden" name="trainId" value="<%= trainId %>">
        <input type="hidden" name="trainName" value="<%= trainName %>">
        <input type="hidden" name="from" value="<%= from %>">
        <input type="hidden" name="to" value="<%= to %>">
        <input type="hidden" name="departureTime" value="<%= departureTime %>">
       
        <label>From: <%= from %></label><br>
        <label>To: <%= to %></label><br>
        <label>Departure Time: <%= departureTime %></label><br>
        <label>Adult:</label> <input type="number" name="adult" min="1" max="15" value="0"><br>
        <label>Child:</label> <input type="number" name="child" min="0" max="15" value="0"><br>
        <label>Type:</label> 
        <select name="type">
            <option value="general">General</option>
            
            <!-- Add more options if needed -->
        </select><br>
        <input type="submit" value="Book Ticket">
    </form>
</body>
</html>
