package com.crypto.canvas.model;

import com.crypto.canvas.IllegalDimensionValueException;
import org.junit.Assert;
import org.junit.Test;

public class CanvasTest {

    @Test
    public void testConstructingCanvas() {
        int width = 20;
        int height = 20;
        try {
            Canvas canvas = Canvas.getInstance(width, height);
            Assert.assertEquals(width, canvas.getMatrix().length);
        } catch (IllegalDimensionValueException e) {
            e.printStackTrace();
        }
    }
}
