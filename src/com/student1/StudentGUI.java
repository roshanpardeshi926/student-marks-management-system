package com.student1;

import javax.swing.*;
import java.awt.*;

public class StudentGUI extends JFrame {

    private JTextField idField, nameField, sub1Field, sub2Field, sub3Field;
    private JButton addButton, updateButton, deleteButton;

    public StudentGUI() {

        setTitle("Student Marks Management System");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ID
        panel.add(new JLabel("Student ID (for Update/Delete):"));
        idField = new JTextField();
        panel.add(idField);

        // Name
        panel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        // Subject 1
        panel.add(new JLabel("Subject 1 Marks:"));
        sub1Field = new JTextField();
        panel.add(sub1Field);

        // Subject 2
        panel.add(new JLabel("Subject 2 Marks:"));
        sub2Field = new JTextField();
        panel.add(sub2Field);

        // Subject 3
        panel.add(new JLabel("Subject 3 Marks:"));
        sub3Field = new JTextField();
        panel.add(sub3Field);

        // Buttons
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(new JLabel());
        panel.add(deleteButton);

        add(panel);

        StudentDAO dao = new StudentDAO();

        // ================= ADD =================
        addButton.addActionListener(e -> {
            try {
                String name = nameField.getText();

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Name is required!");
                    return;
                }

                int sub1 = Integer.parseInt(sub1Field.getText());
                int sub2 = Integer.parseInt(sub2Field.getText());
                int sub3 = Integer.parseInt(sub3Field.getText());

                Student s = new Student(name, sub1, sub2, sub3);
                dao.addStudent(s);

                JOptionPane.showMessageDialog(this, "Student Added Successfully!");
                clearFields();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid marks!");
            }
        });

        // ================= UPDATE =================
        updateButton.addActionListener(e -> {

            // ID validation FIRST
            if (idField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the Student ID!");
                return;
            }

            try {
                int id = Integer.parseInt(idField.getText());
                int sub1 = Integer.parseInt(sub1Field.getText());
                int sub2 = Integer.parseInt(sub2Field.getText());
                int sub3 = Integer.parseInt(sub3Field.getText());

                dao.updateStudent(id, sub1, sub2, sub3);

                JOptionPane.showMessageDialog(this, "Student Updated Successfully!");
                clearFields();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid ID and marks!");
            }
        });

        // ================= DELETE =================
        deleteButton.addActionListener(e -> {

            if (idField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the Student ID!");
                return;
            }

            try {
                int id = Integer.parseInt(idField.getText());
                dao.deleteStudent(id);

                JOptionPane.showMessageDialog(this, "Student Deleted Successfully!");
                clearFields();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid ID!");
            }
        });
    }

    // Clear all fields
    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        sub1Field.setText("");
        sub2Field.setText("");
        sub3Field.setText("");
    }

    public static void main(String[] args) {
        new StudentGUI().setVisible(true);
    }
}
//git remote add origin https://github.com/roshanpardeshi926/student-marks-management-system.git