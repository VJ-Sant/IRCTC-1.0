/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author santh
 */
// ... imports

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
                        
                          
        String result = DBOperations.isValidUser(email, password);

        if (result != null && result.equals("Email is not registered")) {
            // Email is not registered
            out.println("<h3>Email is not registered. Please try again.</h3>");
            out.println("<a href=\"login.jsp\">Login</a>|<a href=\"register.jsp\">New User</a> ");
        } else if (result != null && result.equals("Incorrect password")) {
            // Password is incorrect
            out.println("<h3>Incorrect password. Please try again.</h3>");
            out.println("<a href=\"login.jsp\">Login</a>|<a href=\"register.jsp\">New User</a> ");
        } else if (result != null) {
            // Successful login, redirect to welcome page
            session.setAttribute("user_name",email); 
            request.setAttribute("username", result);
            request.getRequestDispatcher("home.jsp").forward(request, response);
            
        } else {
            // An error occurred
            out.println("<h3>An error occurred. Please try again later.</h3>");
        }
    }
}
