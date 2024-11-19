package com.yintern.controller;

import com.yintern.models.Intern;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InternInsert extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Retrieve form data
        String sid = request.getParameter("id"); // The sid will come from the session
        String cname = request.getParameter("cname");
        String cnumber = request.getParameter("cnumber");
        String caddress = request.getParameter("caddress");
        String city = request.getParameter("city");
        double stipendAmount = Double.parseDouble(request.getParameter("stipendAmount"));
        String mentorName = request.getParameter("mentorName");
        String mentorContactNumber = request.getParameter("mentorContactNumber");
        String mentorEmail = request.getParameter("mentorEmail");
        String startDate = request.getParameter("startDate");
        String offerLetterFname = request.getParameter("offerLetterFname");

        // You can print the values to verify the data is captured
        System.out.println("Intern ID: " + sid);
        System.out.println("Company Name: " + cname);
        System.out.println("Company Number: " + cnumber);
        System.out.println("Company Address: " + caddress);
        System.out.println("City: " + city);
        System.out.println("Stipend Amount: " + stipendAmount);
        System.out.println("Mentor Name: " + mentorName);
        System.out.println("Mentor Contact: " + mentorContactNumber);
        System.out.println("Mentor Email: " + mentorEmail);
        System.out.println("Start Date: " + startDate);
        System.out.println("Offer Letter Filename: " + offerLetterFname);
        
        // You can create an Intern object to hold the data (optional)
        Intern intern = new Intern();
        intern.setSid(Integer.parseInt(sid));
        intern.setCname(cname);
        intern.setCnumber(cnumber);
        intern.setCaddress(caddress);
        intern.setCity(city);
        intern.setStipendAmount(stipendAmount);
        intern.setMentorName(mentorName);
        intern.setMentorContactNumber(mentorContactNumber);
        intern.setMentorEmail(mentorEmail);
        intern.setStartDate(java.sql.Date.valueOf(startDate)); // Convert String to Date
        intern.setOfferLetterFname(offerLetterFname);

        // At this point, you can insert the intern object into the database
        // Example: DatabaseHelper.insertIntern(intern);

        // Send a response back to the client (optional)
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Internship Details Submitted Successfully</h1>");
        out.println("<p>Intern details have been saved.</p>");
        out.println("</body></html>");
    }
}
