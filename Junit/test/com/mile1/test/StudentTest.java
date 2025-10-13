package com.mile1.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.mile1.bean.Student;
import com.mile1.exception.NullMarksArrayException;
import com.mile1.exception.NullNameException;
import com.mile1.exception.NullStudentException;
import com.mile1.main.StudentMain;
import com.mile1.service.StudentReport;

public class StudentTest {

    StudentReport studentReport = new StudentReport();
    StudentMain studentMain = new StudentMain();

    // Data for testing the null-counting functions
    static Student[] data = {
            new Student("A", new int[]{80, 80, 80}),
            new Student(null, new int[]{70, 70, 70}),
            null,
            new Student("C", null),
            new Student("D", new int[]{30, 90, 90}),
            new Student(null, null)
    };

    // TC1: Check for A grade computation
    @Test
    public void testFindGradeA() {
        assertEquals("A", studentReport.findGrade(new Student("StudentA", new int[]{90, 90, 90})));
    }

    // TC2: Check for D grade computation
    @Test
    public void testFindGradeD() {
        assertEquals("D", studentReport.findGrade(new Student("StudentD", new int[]{40, 40, 40})));
    }

    // TC3: Check for F grade computation
    @Test
    public void testFindGradeF() {
        assertEquals("F", studentReport.findGrade(new Student("StudentF", new int[]{90, 90, 30})));
    }

    // TC4: Throw NullStudentException
    @Test(expected = NullStudentException.class)
    public void testValidateNullStudent() throws Exception {
        studentReport.validate(null);
    }

    // TC5: Throw NullNameException
    @Test(expected = NullNameException.class)
    public void testValidateNullName() throws Exception {
        studentReport.validate(new Student(null, new int[]{50, 50, 50}));
    }

    // TC6: Throw NullMarksArrayException
    @Test(expected = NullMarksArrayException.class)
    public void testValidateNullMarks() throws Exception {
        studentReport.validate(new Student("ValidName", null));
    }

    // TC7: Test findNumberOfNullName function
    @Test
    public void testFindNumberOfNullName() {
        assertEquals(2, studentMain.findNumberOfNullName(data));
    }

    // TC8: Test findNumberOfNullObjects function
    @Test
    public void testFindNumberOfNullObjects() {
        assertEquals(1, studentMain.findNumberOfNullObjects(data));
    }

    // TC9: Test findNumberOfNullMarks function
    @Test
    public void testFindNumberOfNullMarks() {
        assertEquals(2, studentMain.findNumberOfNullMarks(data));
    }
}