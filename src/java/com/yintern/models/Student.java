package com.yintern.models;

/**
 * Represents a Student entity corresponding to the student table in the database.
 */
public class Student {
    private int sid;            // Student ID
    private String spass;       // Student Password
    private String sname;       // Student Name
    private int internstatus;   // Internship Status (-1, 0, 1)

    // Default Constructor
    public Student() {}

    // Parameterized Constructor
    public Student(int sid, String spass, String sname, int internstatus) {
        this.sid = sid;
        this.spass = spass;
        this.sname = sname;
        this.internstatus = internstatus;
    }

    // Getter and Setter for sid
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    // Getter and Setter for spass
    public String getSpass() {
        return spass;
    }

    public void setSpass(String spass) {
        this.spass = spass;
    }

    // Getter and Setter for sname
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    // Getter and Setter for internstatus
    public int getInternstatus() {
        return internstatus;
    }

    public void setInternstatus(int internstatus) {
        if (internstatus == -1 || internstatus == 0 || internstatus == 1) {
            this.internstatus = internstatus;
        } else {
            throw new IllegalArgumentException("Invalid intern status. Must be -1, 0, or 1.");
        }
    }

    // toString method for debugging and logging
    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", spass='" + spass + '\'' +
                ", sname='" + sname + '\'' +
                ", internstatus=" + internstatus +
                '}';
    }
}
