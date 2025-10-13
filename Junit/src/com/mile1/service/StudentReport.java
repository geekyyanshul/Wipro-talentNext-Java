package com.mile1.service;

import com.mile1.bean.Student;
import com.mile1.exception.*;

public class StudentReport {

    public String findGrade(Student studentObject) {
        int[] marks = studentObject.getMarks();
        int marksSum = 0;

        for (int mark : marks) {
            if (mark < 35) {
                return "F";
            }
            marksSum += mark;
        }

        if (marksSum <= 150) return "D";
        else if (marksSum <= 200) return "C";
        else if (marksSum <= 250) return "B";
        else if (marksSum <= 300) return "A";
        
        return "F";
    }

    public String validate(Student studentObject) throws NullStudentException, NullNameException, NullMarksArrayException {
        if (studentObject == null) {
            throw new NullStudentException();
        } else {
            if (studentObject.getName() == null) {
                throw new NullNameException();
            }
            if (studentObject.getMarks() == null) {
                throw new NullMarksArrayException();
            }
            return findGrade(studentObject);
        }
    }
}