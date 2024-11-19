package com.yintern.test;

import com.yintern.dao.StudentDao;
import com.yintern.models.Student;

public class TestStudentDao {

    public static void main(String[] args) {
        // Create a new Student object and set the values
        Student student = new Student();
        student.setSid(101);               // Student ID (Scholar Number)
        student.setSname("Akash");      // Student Name
        student.setSpass("p123");   // Student Password
        student.setInternstatus(0);        // Internship Status (0 = In Progress)
        student.setMentorId(201);          // Mentor ID

        // Create StudentDao object to handle the insertion
        StudentDao studentDao = new StudentDao();

        // Insert the student into the database
        boolean success = studentDao.insertStudent(student);

        // Print the result
        if (success) {
            System.out.println("Student insertion successful!");
        } else {
            System.out.println("Student insertion failed.");
        }
    }
}
