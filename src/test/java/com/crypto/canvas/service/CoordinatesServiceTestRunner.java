package com.crypto.canvas.service;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class CoordinatesServiceTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(CoordinatesServiceTest.class);
        if (!result.wasSuccessful()) {
            result.getFailures().forEach(failure -> {
                System.out.println(failure.toString());
            });
        } else System.out.println("All test cases for Coordinates Service passed.");
    }
}
