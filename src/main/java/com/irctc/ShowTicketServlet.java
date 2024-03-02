/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.irctc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@WebServlet("/ShowTicketServlet")
public class ShowTicketServlet extends HttpServlet {
    StationDAO db=new StationDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Call the method to fetch ticket details from the database
        HttpSession session=request.getSession();
      String username =(String) session.getAttribute("user_name");  
        List<Ticket> tick = db.fetchTicketDetailsFromDB(username);

        // Set the fetched ticket details as attributes in the request object
      
     request.setAttribute("ticketList", tick);
   
        // Forward the request to showticket.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("showticket.jsp");
     
        dispatcher.forward(request, response);
    }
}
