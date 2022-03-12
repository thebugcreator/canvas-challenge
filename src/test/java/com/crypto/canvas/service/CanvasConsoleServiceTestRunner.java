package com.crypto.canvas.service;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class CanvasConsoleServiceTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(CanvasConsoleServiceTest.class);
        if (!result.wasSuccessful()) {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        } else
            System.out.println("All test cases for Canvas Console Service passed.");
    }
}
