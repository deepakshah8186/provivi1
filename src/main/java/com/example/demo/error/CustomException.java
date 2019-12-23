package com.example.demo.error;

import java.io.PrintWriter;
import java.io.StringWriter;


public class CustomException extends RuntimeException{
    public CustomException(String message, Exception e) {
        super(message + (e==null ? "" : getStackTrace(e)));
    }

    private static String getStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        String exceptionAsString = sw.toString();
        return exceptionAsString;
    }
}
