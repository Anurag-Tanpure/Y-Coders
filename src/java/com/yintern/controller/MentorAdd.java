package com.yintern.controller;

import java.io.IOException;
import java.io.PrintWriter;

// Import database-related classes
import com.yintern.dao.MentorDao;
import com.yintern.models.Mentor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MentorAdd")
public class MentorAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Setting up the response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Fetching form parameters
        String mentorId = request.getParameter("mentor_id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // Create MentorDao instance
            MentorDao mentorDao = new MentorDao();

            // Save mentor details
            boolean isSaved = mentorDao.addMentor(new Mentor(Integer.parseInt(mentorId), name, email, password));

            if (isSaved) {
                out.println("<h3 style='color:green;'>Mentor details saved successfully!</h3>");
                response.sendRedirect("admin.html"); // Redirect to success page
            } else {
                out.println("<h3 style='color:red;'>Error saving mentor details. Please try again.</h3>");
                // Redirect to error page
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3 style='color:red;'>An unexpected error occurred: " + e.getMessage() + "</h3>");
        } finally {
            out.close();
        }
    }
}
