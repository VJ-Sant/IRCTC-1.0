<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Arial', sans-serif;
            background: linear-gradient(45deg, #ffcc00, #ff66b2, #0099ff, #66ff66);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            position: relative;
        }

        .glassy-background {
            /* Add styles for the glassy background if needed */
        }

        .register-container {
            position: relative;
            background: rgba(255, 255, 255, 0);
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            width: 100%;
        
            height:100%;
            text-align: center;
            margin-top: 50px; /* Adjust the margin as needed */
            transition: background 0.3s;
        }

        .visible-heading {
            text-align: center;
        }

        .visible-heading img {
            max-width: 100%;
            max-height: 150px; /* Adjust the max height as needed */
            object-fit: contain; /* Adjust the object-fit property as needed */
            margin-bottom: 20px; /* Add margin for spacing */
        }

        .register-form {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
            justify-content: space-between;
        }

        .input-group {
            display: flex;
            flex-direction: column; /* Stack label and input vertically */
            align-items: flex-start; /* Align items to the start */
        }

        .input-group label {
            margin-bottom: 5px; /* Add margin between label and input */
            font-weight: bold;
            color: #555;
            font-size: 16px;
            text-align: left; /* Align label text to the left */
        }

        .input-group input,
        .input-group select {
            width: 100%; /* Make the input full width */
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            transition: box-shadow 0.3s;
            font-size: 16px;
        }

        .input-group input:hover,
        .input-group select:hover {
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.3);
        }

        .register-form button {
            width: 100%;
            background: #3498db;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            padding: 12px;
            transition: box-shadow 0.3s;
            font-size: 18px;
            margin-top: 10px;
        }

        .register-form button:hover {
            background: #2980b9;
        }

        .register-form a {
            width: 100%;
            color: #3498db;
            text-decoration: none;
            font-size: 16px;
            display: block;
            margin-top: 10px;
        }
    </style>
</head>

<body>

    <div class="glassy-background"></div>

    <div class="register-container">
        <div class="visible-heading"><img src="logo.png" alt="alt" /></div>
        <h2>IRCTC Register</h2>
        <form class="register-form" action="RegisterServlet" method="post">
            <div class="input-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>

            <div class="input-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>

            <div class="input-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>

            <div class="input-group">
                <label for="dateOfBirth">Date of Birth:</label>
                <input type="date" id="dateOfBirth" name="dateOfBirth" required>
            </div>

            <div class="input-group">
                <label for="gender">Gender:</label>
                <select id="gender" name="gender" required>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </select>
            </div>

            <div class="input-group">
                <label for="maritalStatus">Marital Status:</label>
                <select id="maritalStatus" name="maritalStatus" required>
                    <option value="single">Single</option>
                    <option value="married">Married</option>
                </select>
            </div>

            <div class="input-group">
                <label for="phone">Phone Number:</label>
                <input type="text" id="phone" name="phone" required>
            </div>

            <button type="submit">Register</button>
            <a href="login.jsp">Login</a>
        </form>
    </div>

</body>

</html>
