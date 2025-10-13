package com.milel.service;

import com.milel.bean.Student;

public class StudentService {

    public int findNumberOfNullMarksArray(Student s[]) {
        int count = 0;
        if (s != null) {
            for (Student student : s) {
                if (student != null && student.getMarks() == null) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findNumberOfNullName(Student s[]) {
        int count = 0;
        if (s != null) {
            for (Student student : s) {
                if (student != null && student.getName() == null) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findNumberOfNullObjects(Student s[]) {
        int count = 0;
        if (s != null) {
            for (Student student : s) {
                if (student == null) {
                    count++;
                }
            }
        }
        return count;
    }
}