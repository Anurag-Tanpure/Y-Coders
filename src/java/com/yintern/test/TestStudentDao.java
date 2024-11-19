package com.yintern.test;

import com.yintern.dao.StudentDao;
import com.yintern.models.Student;

public class TestStudentDao {

    public static void main(String[] args) {
        // Create a new Student object and set the values
        Student student = new Student();
        student.setSid(101);              
        student.setSname("Akash");     
        student.setSpass("p123");  
        student.setInternstatus(0);       
        student.setMentorId(201);       

        
        StudentDao studentDao = new StudentDao();

     
        boolean success = studentDao.insertStudent(student);

       
        if (success) {
            System.out.println("Student insertion successful!");
        } else {
            System.out.println("Student insertion failed.");
        }
    }
}
