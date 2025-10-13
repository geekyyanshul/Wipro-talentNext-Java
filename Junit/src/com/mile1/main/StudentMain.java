package com.mile1.main;

import com.mile1.bean.Student;

public class StudentMain {
    
    // Test findNumberOfNullName function 
    public int findNumberOfNullName(Student[] data) {
        int nullNamesCount = 0;
        for (Student s : data) {
            if (s != null && s.getName() == null) {
                nullNamesCount++;
            }
        }
        return nullNamesCount;
    }

    // Test findNumberOfNullObjects function 
    public int findNumberOfNullObjects(Student[] data) {
        int nullObjectsCount = 0;
        for (Student s : data) {
            if (s == null) {
                nullObjectsCount++;
            }
        }
        return nullObjectsCount;
    }

    // Test findNumberOfNullMarks function 
    public int findNumberOfNullMarks(Student[] data) {
        int nullMarksCount = 0;
        for (Student s : data) {
            if (s != null && s.getMarks() == null) {
                nullMarksCount++;
            }
        }
        return nullMarksCount;
    }
}