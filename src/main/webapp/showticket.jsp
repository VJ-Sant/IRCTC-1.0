<%@ page import="java.util.List" %>
<%@ page import="com.irctc.Ticket" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Ticket</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(45deg, #ffcc00, #ff66b2, #0099ff, #66ff66); /* Colorful gradient background */
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.7); /* Semi-transparent white background */
            padding: 40px; /* Increased padding for larger container */
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2); /* Box shadow for the container */
            max-width: 1000px; /* Increased max-width for larger container */
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px; /* Increased padding for better spacing */
            text-align: center; /* Center-align content */
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #333;
            font-weight: bold;
            padding: 10px 20px;
            background-color: #ffcc00;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #ff9933;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Ticket Details</h2>
        <table border="1">
            <tr>
                <th>Ticket ID</th>
                <th>Train ID</th>
                <th>Train Name</th>
                <th>Departure Station</th>
                <th>Arrival Station</th>
                <th>Departure Time</th>
                <th>Adult Tickets</th>
                <th>Child Tickets</th>
                <th>Ticket Type</th>
                <th>Travel Date</th>
                <th>Booked Date</th>
            </tr>
            <% 
                List<Ticket> ticketList = (List<Ticket>) request.getAttribute("ticketList");
                for (Ticket ticket : ticketList) {
            %>
            <tr>
                <td><%=ticket.getTicketId()%></td>
                <td><%= ticket.getTrainId() %></td>
                <td><%= ticket.getTrainName() %></td>
                <td><%= ticket.getDepartureStation() %></td>
                <td><%= ticket.getArrivalStation() %></td>
                <td><%= ticket.getDepartureTime() %></td>
                <td><%= ticket.getAdultTickets() %></td>
                <td><%= ticket.getChildTickets() %></td>
                <td><%= ticket.getTicketType() %></td>
                <td><%= ticket.getTravelDate()%></td>
                <td><%= java.time.LocalDate.now() %></td>
            </tr>
            <% } %>
        </table>
        <a href="home.jsp">Go to Home</a>
    </div>
</body>
</html>
