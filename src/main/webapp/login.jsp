<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login Page</title>
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
            img {
                height: 100px;
                width: 100px;
                /* To remove any default inline display behavior */

            }

            .btn{
                margin-top: 30px;
                padding: 40px;
            }
            .img{  /* Set left and right margin to 'auto' for centering */
                gap: 10px;
                display: flex;
                flex-direction: column;
                position: absolute;
                top: 20px;
                align-content:center;
            }

            .glassy-background{
                position:absolute;
                justify-content: center;
                left:200px;
            }


            .login-container {
                position: absolute;
                background: rgba(255, 255, 255, 0); /* Transparent background to make it invisible */
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
                width: 300px;
                text-align: center;
                transition: background 0.3s; /* Add transition for a smoother effect */
                margin-top: 30px;

            }

            .login-container h2 {
                color: #333;
            }

            .login-form {
                display: flex;
                flex-direction: column;
                gap: 10px;
            }

            .login-form label {
                font-weight: bold;
                color: #555;
            }

            .login-form input,
            .login-form button {
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
                transition: box-shadow 0.3s; /* Add transition for a smoother effect */
            }

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

            .visible-heading {
                position: absolute;
                top: 20px;
                left: 50%;
                transform: translateX(-50%);
                color: #fff; /* Make the text color visible */
                font-size: 24px;
                font-weight: bold;
                text-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
            }
        </style>
    </head>
    <body>


        <div class="img" id="left">

            <img src="logo.png" alt="alt"/>

        </div>
        <div class="glassy-background"></div>

        <div class="login-container">
            <h2>IRCTC Login</h2>
            <form class="login-form" action="LoginServlet" method="post">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>

                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>

                <button class ="btn"type="submit">Login</button>

                <a href="register.jsp">New User</a> 

            </form>

        </div>

    </body>
</html>
