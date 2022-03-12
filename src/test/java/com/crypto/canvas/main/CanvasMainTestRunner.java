package com.crypto.canvas.main;

import com.crypto.canvas.model.CanvasTestRunner;
import com.crypto.canvas.service.CanvasConsoleServiceTestRunner;
import com.crypto.canvas.service.CanvasServiceTestRunner;
import com.crypto.canvas.service.CoordinatesServiceTestRunner;

/*
 * Run this for executing all other test runner
 */
public class CanvasMainTestRunner {
    public static void main(String[] args) {
        CanvasTestRunner.main(args);
        CanvasConsoleServiceTestRunner.main(args);
        CanvasServiceTestRunner.main(args);
        CoordinatesServiceTestRunner.main(args);
    }
}
