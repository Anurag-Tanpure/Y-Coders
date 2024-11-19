package com.yintern.models;

public class Student {
    private int sid;            // Student ID
    private String spass;       // Student Password
    private String sname;       // Student Name
    private int internstatus;   // Internship Status (-1, 0, 1)
    private int mentorId;       // Mentor ID (new field)

    // Default Constructor
    public Student() {}

    // Parameterized Constructor
    public Student(int sid, String spass, String sname, int internstatus, int mentorId) {
        this.sid = sid;
        this.spass = spass;
        this.sname = sname;
        this.internstatus = internstatus;
        this.mentorId = mentorId;
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

    // Getter and Setter for mentorId
    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    // toString method for debugging and logging
    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", spass='" + spass + '\'' +
                ", sname='" + sname + '\'' +
                ", internstatus=" + internstatus +
                ", mentorId=" + mentorId +
                '}';
    }
}
