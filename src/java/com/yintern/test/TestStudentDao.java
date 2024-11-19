package com.yintern.test;

import com.yintern.dao.StudentDao;
import com.yintern.models.Student;

import java.util.List;

public class TestStudentDao {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

    boolean b=   studentDao.checkLogin(1, "pas123");
        System.out.println(b);
    }
}
