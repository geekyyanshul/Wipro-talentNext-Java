package com.milel.main;

import com.milel.bean.Student;
import com.milel.service.StudentReport;
import com.milel.service.StudentService;

public class StudentMain {

    static Student data[] = new Student[4];

    static {
        data[0] = new Student("Sekar", new int[]{85, 75, 95});
        data[1] = new Student(null, new int[]{11, 22, 33});
        data[2] = null;
        data[3] = new Student("Manoj", null);
    }

    public static void main(String[] args) {
        StudentReport studentReport = new StudentReport();
        StudentService studentService = new StudentService();

        System.out.println("--- Grade Calculation ---");

        for (int i = 0; i < data.length; i++) {
            try {
                String validationResult = studentReport.validate(data[i]);
                if (validationResult.equals("VALID")) {
                    String grade = studentReport.findGrades(data[i]);
                    System.out.println("GRADE for " + data[i].getName() + " is: " + grade);
                }
            } catch (Exception e) {
                System.out.println("Exception for data[" + i + "]: " + e);
                // The document asks to print the stack trace.
                // e.printStackTrace();
            }
        }

        System.out.println("\n--- Data Validation Summary ---");

        int nullMarksCount = studentService.findNumberOfNullMarksArray(data);
        System.out.println("Number of students with null marks array: " + nullMarksCount);

        int nullNameCount = studentService.findNumberOfNullName(data);
        System.out.println("Number of students with null name: " + nullNameCount);

        int nullObjectsCount = studentService.findNumberOfNullObjects(data);
        System.out.println("Number of null student objects: " + nullObjectsCount);
    }
}