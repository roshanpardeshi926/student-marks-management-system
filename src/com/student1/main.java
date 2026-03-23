package com.student1;

import java.util.Scanner;

public class main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Subject 1 Marks: ");
        int sub1 = sc.nextInt();

        System.out.print("Enter Subject 2 Marks: ");
        int sub2 = sc.nextInt();

        System.out.print("Enter Subject 3 Marks: ");
        int sub3 = sc.nextInt();

        // Create Student object with user input
        Student s = new Student(name, sub1, sub2, sub3);

        // Store in DB
        StudentDAO dao = new StudentDAO();
        dao.addStudent(s);

        sc.close();
    }
}
