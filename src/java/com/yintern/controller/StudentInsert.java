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
        
     
        String idStr = request.getParameter("id"); // Student ID (Scholar Number)
        String name = request.getParameter("name"); // Student Name
        String pass = request.getParameter("pass"); // Password
        String status = request.getParameter("status"); // Intern Status
        String mentorIdStr = request.getParameter("mentor_id"); // Mentor ID

        
        int id = -1;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            // Handle invalid ID format
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Scholar Number.");
            return;
        }

       
        int mentorId = -1;
        try {
            mentorId = Integer.parseInt(mentorIdStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Mentor ID.");
            return;
        }

       
        int internStatus = -1;
        if ("not_started".equals(status)) {
            internStatus = -1; // Pending
        } else if ("in_progress".equals(status)) {
            internStatus = 0; // In Progress
        } else if ("completed".equals(status)) {
            internStatus = 1; // Success
        }

     
        Student student = new Student();
        student.setSid(id);
        student.setSname(name);
        student.setSpass(pass);
        student.setInternstatus(internStatus);
        student.setMentorId(mentorId);

       
        StudentDao studentDao = new StudentDao();
        if (studentDao.doesStudentExist(id)) {
            // If the ID exists, display an error message to the user
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body><h2>Registration Failed!</h2><p>Student ID already exists. Please enter a new Scholar Number.</p></body></html>");
            return;
        }

       
        boolean success = studentDao.insertStudent(student);

       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (success) {
            out.println("<html><body><h2>Registration Successful!</h2><p>Welcome " + name + "!</p></body></html>");
        } else {
            out.println("<html><body><h2>Registration Failed!</h2><p>Something went wrong, please try again.</p></body></html>");
        }
    }
}
