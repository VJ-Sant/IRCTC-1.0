/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.irctc;

/**
 *
 * @author santh
 */
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

@WebServlet("/StationServlet")
public class StationServlet extends HttpServlet {

    StationDAO db = new StationDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String travelDate = request.getParameter("travelDate");
        HttpSession session = request.getSession();

        try {
            Station fromPriority = db.getStationPriority(from);
            Station toPriority = db.getStationPriority(to);
            int fid = fromPriority.getId();
            int tid = toPriority.getId();

            String timetable;

            if ((fromPriority.getPriority() == 1) && (toPriority.getPriority() == 1)) {

                if (fid < tid) {
               
                    timetable = "bangaloretimetable";
                    List<Train> train = db.fetchTrainsFromTimetable(fid, timetable, travelDate);
                    request.setAttribute("list", train);
                    request.setAttribute("from", from);
                    request.setAttribute("to", to);
                    request.setAttribute("travelDate", travelDate);
               
                    RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
                    session.setAttribute("tDate", travelDate);

                    rd.forward(request, response);

                } else if (fid > tid) {
                  
                    timetable = "chennaitimetable";
                    List<Train> train = db.fetchTrainsFromTimetable(fid, timetable, travelDate);
                   
                    request.setAttribute("list", train);

                    request.setAttribute("from", from);
                    request.setAttribute("to", to);
                    request.setAttribute("travelDate", travelDate);

                    RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
                    session.setAttribute("tDate", travelDate);

                    rd.forward(request, response);

                }
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                rd.forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while searching for trains.");
        }
    }

}
