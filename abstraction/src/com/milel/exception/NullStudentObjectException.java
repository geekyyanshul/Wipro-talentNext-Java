package com.milel.exception;

public class NullStudentObjectException extends Exception {
    @Override
    public String toString() {
        return "object is null";
    }
}