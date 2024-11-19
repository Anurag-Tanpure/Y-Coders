package com.yintern.models;

public class Intern {
    private int sid;
    private String cname;
    private String cnumber;
    private String caddress;
    private String city;
    private double stipendAmount;
    private String mentorName;
    private String mentorContactNumber;
    private String mentorEmail;
    private String startDate;
    private String offerLetterFname;
    private int marks;

   
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getStipendAmount() {
        return stipendAmount;
    }

    public void setStipendAmount(double stipendAmount) {
        this.stipendAmount = stipendAmount;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public String getMentorContactNumber() {
        return mentorContactNumber;
    }

    public void setMentorContactNumber(String mentorContactNumber) {
        this.mentorContactNumber = mentorContactNumber;
    }

    public String getMentorEmail() {
        return mentorEmail;
    }

    public void setMentorEmail(String mentorEmail) {
        this.mentorEmail = mentorEmail;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getOfferLetterFname() {
        return offerLetterFname;
    }

    public void setOfferLetterFname(String offerLetterFname) {
        this.offerLetterFname = offerLetterFname;
    }

    public int getMarks() { 
        return marks;
    }

    public void setMarks(int marks) { 
        this.marks = marks;
    }
}
