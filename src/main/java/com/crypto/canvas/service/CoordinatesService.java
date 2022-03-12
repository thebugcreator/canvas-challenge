package com.crypto.canvas.service;

import com.crypto.canvas.IllegalCoordinatesException;
import com.crypto.canvas.model.Canvas;

public class CoordinatesService {
    public static boolean isValidCoordinates(int x, int y) throws IllegalCoordinatesException {
        Canvas canvas = Canvas.getInstance();
        if (x < 1 || y < 1 || x > canvas.getWidth() || y > canvas.getHeight()) {
            throw new IllegalCoordinatesException("Coordinates must appear inside the canvas.");
        }
        return true;
    }
}
