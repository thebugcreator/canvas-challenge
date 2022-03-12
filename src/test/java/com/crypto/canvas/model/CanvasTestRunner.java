package com.crypto.canvas.model;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;


public class CanvasTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(CanvasTest.class);
        if (!result.wasSuccessful()) {
            result.getFailures().forEach(f -> {
                System.out.println(f.toString());
            });
        } else {
            System.out.println("All test cases for Canvas passed.");
        }

    }
}
