<%@ page import="java.util.List" %>
<%@ page import="com.irctc.Train" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Trains</title>
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
            margin-top: 20px;
            z-index: 1; /* Ensure it's above other elements */
            position: absolute; /* Position at the top */
            top: 0; /* Position at the top */
            left: 50%; /* Center horizontally */
            transform: translateX(-50%); /* Center horizontally */
            background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent white background */
            padding: 10px 20px; /* Add padding for readability */
            border-radius: 10px; /* Add border radius for rounded corners */
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2); /* Box shadow for the container */
        }
        .content {
            background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent white background */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2); /* Box shadow for the container */
            margin-top: 100px; /* Adjust margin top as needed */
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
    <h1>List of Trains</h1>
    <div class="content">
        <table>
            <tr>
                <th>Train Name</th>
                <th>Train Number</th>
                <th>Departure Station</th>
                <th>Departure Time</th>
                <th>Arrival Station</th>
                <th>Arrival Time</th>
                <th>Book Ticket</th>
            </tr>
            <% 
                
                
                List<Train> trains = (List<Train>) request.getAttribute("list");
               
                for (Train train : trains) {
            %>
            <tr>
                <td><%= train.getTrainName() %></td>
                <td><%= train.getTrainNumber() %></td>
                <td><%= request.getParameter("from") %></td>
                <td><%= train.getDepartureTime() %></td>
                <td><%= request.getParameter("to") %></td>
                <td><%= train.getArrivalTime() %></td>
                <td>
                    <form action="BookingServlet" method="post">
                        <!-- Set hidden input fields with necessary data -->
                        <input type="hidden" name="trainId" value="<%= train.getTrainNumber() %>">
                        <input type="hidden" name="trainName" value="<%= train.getTrainName() %>">
                        <input type="hidden" name="from" value="<%= request.getParameter("from") %>">
                        <input type="hidden" name="to" value="<%= request.getParameter("to") %>">
                        <input type="hidden" name="departureTime" value="<%= train.getDepartureTime() %>">
                                       
                        <!-- Add other input fields if needed -->
                        <input type="submit" value="Book Ticket">
                    </form>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</body>
</html>
