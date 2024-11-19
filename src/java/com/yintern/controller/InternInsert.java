package com.yintern.controller;

import com.yintern.dao.InternDao;
import com.yintern.models.Intern;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InternInsert")
public class InternInsert extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
          
            int sid = Integer.parseInt(request.getParameter("id"));
            String cname = request.getParameter("cname");
            String cnumber = request.getParameter("cnumber");
            String caddress = request.getParameter("caddress");
            String city = request.getParameter("city");
            double stipendAmount = Double.parseDouble(request.getParameter("stipendAmount"));
            String mentorName = request.getParameter("mentorName");
            String mentorContactNumber = request.getParameter("mentorContactNumber");
            String mentorEmail = request.getParameter("mentorEmail");
            Date startDate = Date.valueOf(request.getParameter("startDate"));
            String offerLetterFname = request.getParameter("offerLetterFname");

           
            int marks = 0;

          
            Intern intern = new Intern();
            intern.setSid(sid);
            intern.setCname(cname);
            intern.setCnumber(cnumber);
            intern.setCaddress(caddress);
            intern.setCity(city);
            intern.setStipendAmount(stipendAmount);
            intern.setMentorName(mentorName);
            intern.setMentorContactNumber(mentorContactNumber);
            intern.setMentorEmail(mentorEmail);
            intern.setStartDate(startDate.toString());
            intern.setOfferLetterFname(offerLetterFname);
            intern.setMarks(marks); // Default marks value set to 0

            
            InternDao internDao = new InternDao();
            boolean isInserted = internDao.insertIntern(intern);

            
            if (isInserted) {
                response.getWriter().println("successfully insert");
                
            } else {
                
                 response.getWriter().println("not inserted");
            }
        } catch (Exception e) {
           
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
