package com.yintern.models;

import java.util.Date;

public class Intern {

    private int sid;                    // Student ID
    private String cname;                // Company Name
    private String cnumber;              // Company Contact Number
    private String caddress;             // Company Address
    private String city;                 // City
    private double stipendAmount;       // Stipend Amount
    private String mentorName;           // Mentor Name
    private String mentorContactNumber; // Mentor Contact Number
    private String mentorEmail;         // Mentor Email
    private Date startDate;              // Start Date
    private String offerLetterFname;    // Offer Letter Filename

    // Constructor
    public Intern() {
    }

    public Intern(int sid, String cname, String cnumber, String caddress, String city, 
                  double stipendAmount, String mentorName, String mentorContactNumber, 
                  String mentorEmail, Date startDate, String offerLetterFname) {
        this.sid = sid;
        this.cname = cname;
        this.cnumber = cnumber;
        this.caddress = caddress;
        this.city = city;
        this.stipendAmount = stipendAmount;
        this.mentorName = mentorName;
        this.mentorContactNumber = mentorContactNumber;
        this.mentorEmail = mentorEmail;
        this.startDate = startDate;
        this.offerLetterFname = offerLetterFname;
    }

    // Getters and Setters
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getOfferLetterFname() {
        return offerLetterFname;
    }

    public void setOfferLetterFname(String offerLetterFname) {
        this.offerLetterFname = offerLetterFname;
    }

    @Override
    public String toString() {
        return "Intern{" +
                "sid=" + sid +
                ", cname='" + cname + '\'' +
                ", cnumber='" + cnumber + '\'' +
                ", caddress='" + caddress + '\'' +
                ", city='" + city + '\'' +
                ", stipendAmount=" + stipendAmount +
                ", mentorName='" + mentorName + '\'' +
                ", mentorContactNumber='" + mentorContactNumber + '\'' +
                ", mentorEmail='" + mentorEmail + '\'' +
                ", startDate=" + startDate +
                ", offerLetterFname='" + offerLetterFname + '\'' +
                '}';
    }
}
