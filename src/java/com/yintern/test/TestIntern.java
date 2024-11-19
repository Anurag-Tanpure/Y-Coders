package com.yintern.test;

import com.yintern.dao.InternDao;
import com.yintern.models.Intern;

import java.util.List;

public class TestIntern {
    public static void main(String[] args) {
       
        InternDao internDao = new InternDao();

      
        Intern intern1 = new Intern();
        intern1.setSid(1);
        intern1.setCname("ABC Corp.");
        intern1.setCnumber("1234567890");
        intern1.setCaddress("123 Street, City");
        intern1.setCity("New York");
        intern1.setStipendAmount(1500.50);
        intern1.setMentorName("John Doe");
        intern1.setMentorContactNumber("9876543210");
        intern1.setMentorEmail("johndoe@abc.com");
        intern1.setStartDate("2024-01-01");
        intern1.setOfferLetterFname("offer_ABC.pdf");
        intern1.setMarks(85); // Test marks

        boolean isInserted = internDao.insertIntern(intern1);
        System.out.println("Insert operation status: " + (isInserted ? "Success" : "Failed"));

     
        List<Intern> interns = internDao.getAllInterns();
        System.out.println("Displaying all Interns:");
        for (Intern intern : interns) {
            System.out.println("SID: " + intern.getSid() + ", Company Name: " + intern.getCname() + ", Marks: " + intern.getMarks());
        }

     
        intern1.setMarks(90);  // Updating marks to 90
        boolean isUpdated = internDao.updateIntern(intern1);
        System.out.println("Update operation status: " + (isUpdated ? "Success" : "Failed"));

     
        boolean isExists = internDao.checkInternExists(1); 
        System.out.println("Check if intern with SID 1 exists: " + (isExists ? "Exists" : "Does not exist"));

        
       boolean isDeleted = internDao.deleteIntern(1);
    System.out.println("Delete operation status for SID 1: " + (isDeleted ? "Success" : "Failed"));

         TEST CASE 6: DISPLAY all Interns again (after delete)
        interns = internDao.getAllInterns();
        System.out.println("Displaying all Interns after deletion:");
        for (Intern intern : interns) {
            System.out.println("SID: " + intern.getSid() + ", Company Name: " + intern.getCname() + ", Marks: " + intern.getMarks());
        }
    }
}
