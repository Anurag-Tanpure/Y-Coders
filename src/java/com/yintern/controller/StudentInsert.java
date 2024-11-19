package com.yintern.controller;

import com.yintern.dao.StudentDao;
import com.yintern.models.Student;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentInsert extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Fetch the data from the form
        String idStr = request.getParameter("id"); // Student ID (Scholar Number)
        String name = request.getParameter("name"); // Student Name
        String pass = request.getParameter("pass"); // Password
        String status = request.getParameter("status"); // Intern Status
        String mentorIdStr = request.getParameter("mentor_id"); // Mentor ID

        // Parse the ID as an integer
        int id = -1;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            // Handle invalid ID format
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Scholar Number.");
            return;
        }

        // Parse the mentorId
        int mentorId = -1;
        try {
            mentorId = Integer.parseInt(mentorIdStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Mentor ID.");
            return;
        }

        // Map the intern status to the appropriate value
        int internStatus = -1;
        if ("not_started".equals(status)) {
            internStatus = -1; // Pending
        } else if ("in_progress".equals(status)) {
            internStatus = 0; // In Progress
        } else if ("completed".equals(status)) {
            internStatus = 1; // Success
        }

        // Create a Student object and set the attributes
        Student student = new Student();
        student.setSid(id);
        student.setSname(name);
        student.setSpass(pass);
        student.setInternstatus(internStatus);
        student.setMentorId(mentorId);

        // Use StudentDao to check if the student ID already exists
        StudentDao studentDao = new StudentDao();
        if (studentDao.doesStudentExist(id)) {
            // If the ID exists, display an error message to the user
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body><h2>Registration Failed!</h2><p>Student ID already exists. Please enter a new Scholar Number.</p></body></html>");
            return;
        }

        // Use StudentDao to insert the student into the database
        boolean success = studentDao.insertStudent(student);

        // Set response based on insertion success
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (success) {
            out.println("<html><body><h2>Registration Successful!</h2><p>Welcome " + name + "!</p></body></html>");
        } else {
            out.println("<html><body><h2>Registration Failed!</h2><p>Something went wrong, please try again.</p></body></html>");
        }
    }
}
