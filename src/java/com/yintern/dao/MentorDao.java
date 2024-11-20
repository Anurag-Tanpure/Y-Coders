package com.yintern.dao;

import com.yintern.connection.MyConnection;
import com.yintern.models.Mentor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MentorDao {

   
    public boolean addMentor(Mentor mentor) {
        String sql = "INSERT INTO mentors (mentor_name, mentor_email, mentor_password) VALUES (?, ?, ?)";
        try (Connection con = MyConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mentor.getMentorName());
            ps.setString(2, mentor.getMentorEmail());
            ps.setString(3, mentor.getMentorPassword());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding mentor: " + e.getMessage());
        }
        return false;
    }

   
    public Mentor getMentorById(int mentorId) {
        String sql = "SELECT * FROM mentors WHERE mentor_id = ?";
        try (Connection con = MyConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, mentorId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Mentor(
                            rs.getInt("mentor_id"),
                            rs.getString("mentor_name"),
                            rs.getString("mentor_email"),
                            rs.getString("mentor_password")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching mentor by ID: " + e.getMessage());
        }
        return null;
    }

    
    public List<Mentor> getAllMentors() {
        List<Mentor> mentors = new ArrayList<>();
        String sql = "SELECT * FROM mentors";
        try (Connection con = MyConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                mentors.add(new Mentor(
                        rs.getInt("mentor_id"),
                        rs.getString("mentor_name"),
                        rs.getString("mentor_email"),
                        rs.getString("mentor_password")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching all mentors: " + e.getMessage());
        }
        return mentors;
    }

    
    public boolean updateMentor(Mentor mentor) {
        String sql = "UPDATE mentors SET mentor_name = ?, mentor_email = ?, mentor_password = ? WHERE mentor_id = ?";
        try (Connection con = MyConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mentor.getMentorName());
            ps.setString(2, mentor.getMentorEmail());
            ps.setString(3, mentor.getMentorPassword());
            ps.setInt(4, mentor.getMentorId());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error updating mentor: " + e.getMessage());
        }
        return false;
    }

    // Delete Mentor
    public boolean deleteMentor(int mentorId) {
        String sql = "DELETE FROM mentors WHERE mentor_id = ?";
        try (Connection con = MyConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, mentorId);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting mentor: " + e.getMessage());
        }
        return false;
    }

    // Check Login
    public boolean checkLogin(int id, String password) {
        String sql = "SELECT * FROM mentors WHERE mentor_id = ? AND mentor_password = ?";
        try (Connection con = MyConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // If ResultSet is not empty, login is successful
            }
        } catch (SQLException e) {
            System.err.println("Error during login check: " + e.getMessage());
        }
        return false;
    }
}
