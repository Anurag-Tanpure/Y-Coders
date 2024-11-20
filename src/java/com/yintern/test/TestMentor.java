/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yintern.test;

import com.yintern.dao.MentorDao;
import com.yintern.models.Mentor;

/**
 *
 * @author ASUS
 */
public class TestMentor {
   
    public static void main(String[] args) {
        MentorDao mentorDao = new MentorDao();

        // Add a mentor
      //  Mentor mentor = new Mentor(0, "Aarav Sharma", "aarav@example.com", "password123");
     
        // Check login
        if (mentorDao.checkLogin(2, "password123")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid email or password.");
        }
    }
}


