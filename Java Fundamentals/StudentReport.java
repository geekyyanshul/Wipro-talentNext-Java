package com.milel.service;

import com.milel.bean.Student;
import com.milel.exception.NullMarksArrayException;
import com.milel.exception.NullNameException;
import com.milel.exception.NullStudentObjectException;

public class StudentReport {

    public String validate(Student s) throws NullStudentObjectException, NullNameException, NullMarksArrayException {
        if (s == null) {
            throw new NullStudentObjectException();
        }
        if (s.getName() == null) {
            throw new NullNameException();
        }
        if (s.getMarks() == null) {
            throw new NullMarksArrayException();
        }
        return "VALID";
    }

    public String findGrades(Student studentObject) {
        int[] marks = studentObject.getMarks();
        int sum = 0;

        for (int mark : marks) {
            if (mark < 35) {
                return "F";
            }
            sum += mark;
        }

        if (sum < 150) {
            return "C";
        } else if (sum < 200) {
            return "B";
        } else if (sum < 250) {
            return "A";
        } else {
            return "A+";
        }
    }
}