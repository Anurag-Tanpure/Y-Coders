package com.yintern.models;

public class Student {
    private int sid;            
    private String spass;       
    private String sname;       
    private int internstatus;   
    private int mentorId;       

    
    public Student() {}
   public Student(int sid, String spass, String sname, int internstatus, int mentorId) {
        this.sid = sid;
        this.spass = spass;
        this.sname = sname;
        this.internstatus = internstatus;
        this.mentorId = mentorId;
    }

   
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

  
    public String getSpass() {
        return spass;
    }

    public void setSpass(String spass) {
        this.spass = spass;
    }

    
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    
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

  
    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

   
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
