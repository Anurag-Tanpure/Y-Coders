package com.yintern.dao;

import com.yintern.connection.MyConnection;
import com.yintern.models.Intern;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InternDao {
    private Connection con = MyConnection.getConnection();

    // INSERT operation
    public boolean insertIntern(Intern intern) {
        String query = "INSERT INTO intern (sid, cname, cnumber, caddress, city, stipend_amount, mentor_name, mentor_contact_number, mentor_email, start_date, offer_letter_fname, marks) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, intern.getSid());
            ps.setString(2, intern.getCname());
            ps.setString(3, intern.getCnumber());
            ps.setString(4, intern.getCaddress());
            ps.setString(5, intern.getCity());
            ps.setDouble(6, intern.getStipendAmount());
            ps.setString(7, intern.getMentorName());
            ps.setString(8, intern.getMentorContactNumber());
            ps.setString(9, intern.getMentorEmail());
            ps.setString(10, intern.getStartDate());
            ps.setString(11, intern.getOfferLetterFname());
            ps.setInt(12, intern.getMarks());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE operation
    public boolean deleteIntern(int sid) {
        String query = "DELETE FROM intern WHERE sid = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, sid);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE operation
    public boolean updateIntern(Intern intern) {
        String query = "UPDATE intern SET cname = ?, cnumber = ?, caddress = ?, city = ?, stipend_amount = ?, mentor_name = ?, mentor_contact_number = ?, mentor_email = ?, start_date = ?, offer_letter_fname = ?, marks = ? WHERE sid = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, intern.getCname());
            ps.setString(2, intern.getCnumber());
            ps.setString(3, intern.getCaddress());
            ps.setString(4, intern.getCity());
            ps.setDouble(5, intern.getStipendAmount());
            ps.setString(6, intern.getMentorName());
            ps.setString(7, intern.getMentorContactNumber());
            ps.setString(8, intern.getMentorEmail());
            ps.setString(9, intern.getStartDate());
            ps.setString(10, intern.getOfferLetterFname());
            ps.setInt(11, intern.getMarks());
            ps.setInt(12, intern.getSid());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DISPLAY operation
    public List<Intern> getAllInterns() {
        List<Intern> internList = new ArrayList<>();
        String query = "SELECT * FROM intern";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Intern intern = new Intern();
                intern.setSid(rs.getInt("sid"));
                intern.setCname(rs.getString("cname"));
                intern.setCnumber(rs.getString("cnumber"));
                intern.setCaddress(rs.getString("caddress"));
                intern.setCity(rs.getString("city"));
                intern.setStipendAmount(rs.getDouble("stipend_amount"));
                intern.setMentorName(rs.getString("mentor_name"));
                intern.setMentorContactNumber(rs.getString("mentor_contact_number"));
                intern.setMentorEmail(rs.getString("mentor_email"));
                intern.setStartDate(rs.getString("start_date"));
                intern.setOfferLetterFname(rs.getString("offer_letter_fname"));
                intern.setMarks(rs.getInt("marks")); // Updated to get int marks
                internList.add(intern);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return internList;
    }

    // CHECK operation
    public boolean checkInternExists(int sid) {
        String query = "SELECT * FROM intern WHERE sid = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, sid);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
