package com.fe.main;

import java.util.Scanner;

import com.fe.dao.StudentDAO;
import com.fe.pojo.Student;

public class StudentMain {

    public static void main(String[] args) {
        System.out.println("+------+MENU+------+");
        System.out.println("| 1. Add Student   |");
        System.out.println("| 2. Delete Student|");
        System.out.println("| 3. Update Student|");
        System.out.println("| 4. Get a Student |");
        System.out.println("| 0. QUIT          |");
        System.out.println("+------+END+-------+");

        int inputKey = -1;
        Scanner console = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO("JPA");

        while (inputKey != 0) {
            System.out.println("\nPlease enter a number: ");
            inputKey = console.nextInt();
            
            Student student = new Student("Lan", "Nguyen", 9);

            switch (inputKey) {
                case 0:
                    break;
                case 1:
                    studentDAO.save(student);
                    System.out.println("Added student successfully.");
                    break;
                case 2:
                    studentDAO.delete(1);
                    System.out.println("Deleted student with ID 1.");
                    break;
                case 3:
                    Student studentToUpdate = new Student(1, "Sang", "Nguyen", 9);
                    studentDAO.update(studentToUpdate);
                    System.out.println("Updated student with ID 1.");
                    break;
                case 4:
                    Student foundStudent = studentDAO.findById(1);
                    System.out.println("Found Student: " + foundStudent);
                    break;
                default:
                    System.out.println("Please choice menu !");
            }
        }
        console.close();
    }
}