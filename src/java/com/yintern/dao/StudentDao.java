package com.yintern.dao;

import com.yintern.connection.MyConnection;
import com.yintern.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private final Connection connection;

    public StudentDao() {
        this.connection = MyConnection.getConnection();
    }

    // Method to check if a student with the given ID already exists
    public boolean doesStudentExist(int sid) {
        String query = "SELECT COUNT(*) FROM student WHERE sid = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, sid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // If count > 0, student ID exists
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Insert student if the ID doesn't exist
    public boolean insertStudent(Student student) {
        if (doesStudentExist(student.getSid())) {
            // If student ID exists, return false
            return false;
        }

        String query = "INSERT INTO student (sid, spass, sname, internstatus, mentor_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, student.getSid());
            ps.setString(2, student.getSpass());
            ps.setString(3, student.getSname());
            ps.setInt(4, student.getInternstatus());
            ps.setInt(5, student.getMentorId());  // Set mentorId
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("sid"),
                        rs.getString("spass"),
                        rs.getString("sname"),
                        rs.getInt("internstatus"),
                        rs.getInt("mentor_id") // Get mentorId
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student getStudentById(int sid) {
        String query = "SELECT * FROM student WHERE sid = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, sid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("sid"),
                        rs.getString("spass"),
                        rs.getString("sname"),
                        rs.getInt("internstatus"),
                        rs.getInt("mentor_id") // Get mentorId
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateStudent(Student student) {
        String query = "UPDATE student SET spass = ?, sname = ?, internstatus = ?, mentor_id = ? WHERE sid = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, student.getSpass());
            ps.setString(2, student.getSname());
            ps.setInt(3, student.getInternstatus());
            ps.setInt(4, student.getMentorId());  // Update mentorId
            ps.setInt(5, student.getSid());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteStudent(int sid) {
        String query = "DELETE FROM student WHERE sid = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, sid);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean checkLogin(int sid, String spass) {
        String query = "SELECT COUNT(*) FROM student WHERE sid = ? AND spass = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, sid);
            ps.setString(2, spass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
