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
import java.io.IOException;

/**
 *
 * @author santh
 */
@WebServlet(name = "TicketServlet", urlPatterns = {"/TicketServlet"})

public class TicketServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int trainId = Integer.parseInt(request.getParameter("trainId"));
        String trainName = request.getParameter("trainName");
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String departureTime = request.getParameter("departureTime");
        int adultTickets = Integer.parseInt(request.getParameter("adult"));
        int childTickets = Integer.parseInt(request.getParameter("child"));
        String ticketType = request.getParameter("type");
        String tDate = (String) session.getAttribute("tDate");
        String username=(String)session.getAttribute("user_name");

        // Call method to store ticket details in the database
        boolean success = StationDAO.storeTicketDetails(trainId, trainName, from, to, departureTime, adultTickets, childTickets, ticketType, tDate,username);

        // Forward to appropriate page based on the result
        if (success) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("err.jsp");
            request.setAttribute("tDate", tDate);
            dispatcher.forward(request, response);
        }
    }

}
