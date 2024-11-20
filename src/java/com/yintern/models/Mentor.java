package com.yintern.models;

public class Mentor {
    private int mentorId;          
    private String mentorName;      // Mentor Name
    private String mentorEmail;     // Mentor Email
    private String mentorPassword;  // Mentor Password

    // Constructor
    public Mentor() {
    }

    public Mentor(int mentorId, String mentorName, String mentorEmail, String mentorPassword) {
        this.mentorId = mentorId;
        this.mentorName = mentorName;
        this.mentorEmail = mentorEmail;
        this.mentorPassword = mentorPassword;
    }

    // Getters and Setters
    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public String getMentorEmail() {
        return mentorEmail;
    }

    public void setMentorEmail(String mentorEmail) {
        this.mentorEmail = mentorEmail;
    }

    public String getMentorPassword() {
        return mentorPassword;
    }

    public void setMentorPassword(String mentorPassword) {
        this.mentorPassword = mentorPassword;
    }

    // Override toString() for debugging or logging
    @Override
    public String toString() {
        return "Mentor{" +
                "mentorId=" + mentorId +
                ", mentorName='" + mentorName + '\'' +
                ", mentorEmail='" + mentorEmail + '\'' +
                ", mentorPassword='" + mentorPassword + '\'' +
                '}';
    }
}
