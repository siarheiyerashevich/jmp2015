package com.booking.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by TheFa on 17.04.16.
 */
@WebServlet("/GetMovie")
public class BookingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String selectedDate = request.getParameter("selectedDate").trim();
//        if (selectedDate == null || "".equals(selectedDate)) {
//            selectedDate = "2016-04-18";
//        }
//
//
//
//        response.setContentType("text/plain");
//        response.getWriter().write(greetings);
//    }
}
