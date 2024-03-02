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
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author santh
 */


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String gender = request.getParameter("gender");
        String maritalStatus = request.getParameter("maritalStatus");
        String phone = request.getParameter("phone");
try {
    String registrationResult = DBOperations.registerUser(username, email, password, dateOfBirth, gender, maritalStatus, phone);

    if ("Registration successful".equals(registrationResult)) {
        response.sendRedirect("login.jsp");
    } else {
        // Handle registration failure or display the appropriate message
        out.println("<h3>" + registrationResult + ". Please try again.</h3>");
    }
} catch (IOException e) {
    out.println("<h3>An error occurred during registration. Please try again later.</h3>");
}

    }
}
