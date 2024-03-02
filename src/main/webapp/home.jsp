<%@ page import="java.util.List" %>
<%@ page import="com.irctc.StationDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Train Ticket Booking</title>
        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: 'Arial', sans-serif;
                background: linear-gradient(45deg, #ffcc00, #ff66b2, #0099ff, #66ff66); /* Colorful gradient background */
                height: 100vh;
                display: flex;
                align-items: center;
                justify-content: center;
                position: relative;
            }
            .glassy-container {
                background-color: rgba(255, 255, 255, 0); /* Semi-transparent white background */
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 20px rgba(0, 0, 0, 0.2); /* Box shadow for the glassy effect */
                backdrop-filter: blur(10px); /* Blur effect for supporting browsers */
                position: relative;
                z-index: 1;
            }
            .glassy-container form {
                position: relative; /* Ensure form elements are positioned relative to the container */
            }
            .glassy-container label {
                display: block;
                margin-bottom: 10px;
            }
            .glassy-container input {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border-radius: 5px;
                border: 1px solid #ccc;
            }
            .glassy-container button {
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                background-color: #0099ff;
                color: #fff;
                cursor: pointer;

            }
            .glassy-container button:hover {
                background-color: #0077cc;
            }
            .logo {
                gap: 10px;
                display: flex;
                flex-direction: column;
                position: absolute;
                top: 20px;
                align-content:center;
            }

            .btn{
                margin-top: 30px;
                padding: 40px;
                .login-form input:hover,
                    .login-form button:hover {
                    box-shadow: 0 0 10px rgba(255, 255, 255, 0.3); /* Light effect on hover */
                }

                .login-form button {
                    background: #3498db;
                    color: #fff;
                    border: none;
                    border-radius: 4px;
                    cursor: pointer;
                }

                .login-form button:hover {
                    background: #2980b9;
                }
            }

        </style>
    </head>
    <body>

        <img src="logo.png" alt="Logo" width="100" height="100" class="logo"/>

        <%
            
            StationDAO stationDAO = new StationDAO();

          
            List<String> stationNames = stationDAO.getStationNames(); 
        %>

        <div class="glassy-container">
            <form class="login-form"  action="StationServlet" method="post">
                <label for="fromStation">From Station:</label>
                <input type="text" id="from" name="from" list="fromStationList">
                <datalist id="fromStationList">
                    <% for (String stationName : stationNames) { %>
                    <option value="<%= stationName %>"></option>
                    <% } %>
                </datalist>

                <label for="toStation">To Station:</label>
                <input type="text" id="to" name="to" list="toStationList">
                <datalist id="toStationList">
                    <% for (String stationName : stationNames) { %>
                    <option value="<%= stationName %>"></option>
                    <% } %>
                </datalist>

                <label for="travelDate">Travel Date:</label>
                <input type="date" id="travelDate" name="travelDate" min="<%= java.time.LocalDate.now() %>">

                <button class ="btn" type="submit">Submit</button>

            </form>
               
        </div>
                  
    </body>
</html>
