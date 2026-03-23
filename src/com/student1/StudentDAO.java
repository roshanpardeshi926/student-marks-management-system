package com.student1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // =========================
    // ADD STUDENT MARKS
    // =========================
    public void addStudent(Student s) {
        try {
            Connection con = DBConnection.getConnection();

            String query =
                "INSERT INTO student1(name, sub1, sub2, sub3) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, s.getName());
            ps.setInt(2, s.getSub1());
            ps.setInt(3, s.getSub2());
            ps.setInt(4, s.getSub3());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    // VIEW ALL STUDENTS
    // =========================
    public void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM student1";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.println("ID | Name | Sub1 | Sub2 | Sub3");
            System.out.println("--------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("sub1") + " | " +
                        rs.getInt("sub2") + " | " +
                        rs.getInt("sub3")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    // UPDATE STUDENT MARKS
    // =========================
    public void updateStudent(int id, int sub1, int sub2, int sub3) {
        try {
            Connection con = DBConnection.getConnection();

            String query =
                "UPDATE student1 SET sub1=?, sub2=?, sub3=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, sub1);
            ps.setInt(2, sub2);
            ps.setInt(3, sub3);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("No student found with ID: " + id);
            } else {
                System.out.println("Update successful for ID: " + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE STUDENT
    // =========================
    public void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM student1 WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("No student found to delete with ID: " + id);
            } else {
                System.out.println("Student deleted with ID: " + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
