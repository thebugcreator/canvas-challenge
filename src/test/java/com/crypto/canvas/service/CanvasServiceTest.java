package com.crypto.canvas.service;

import com.crypto.canvas.IllegalCoordinatesException;
import com.crypto.canvas.IllegalDimensionValueException;
import com.crypto.canvas.model.Canvas;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanvasServiceTest {
    CanvasService service;

    @Before
    public void prepareTest() {
        service = new CanvasService();
    }

    /*
     * Declares the second coordinates that has a horizontal or vertical connection to the first one (y2=y1)
     * Expects no exception
     */
    @Test
    public void testDrawLine() {
        int x1 = 1;
        int y1 = 2;

        int x2 = 4;
        int y2 = 2;
        try {
            service.drawLine(x1, y1, x2, y2);
        } catch (IllegalCoordinatesException ex) {
            fail(ex.getMessage());
        }
    }

    /*
     * Declares the second coordinates that has no horizontal or vertical connection to the first one (x2!=x1&y2!=y1)
     * Expects an IllegalCoordinatesException
     */
    @Test
    public void testDrawInappropriateLine() {
        int x1 = 1;
        int y1 = 2;
        int x2 = 4;
        int y2 = 3;
        try {
            service.drawLine(x1, y1, x2, y2);
        } catch (IllegalCoordinatesException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    /*
     * Declares the second coordinates that does not offend the Crypto Rectangle Regulation
     * Expects no Exception
     */
    @Test
    public void testDrawRectangle() {
        int x1 = 1;
        int y1 = 2;
        int x2 = 4;
        int y2 = 6;
        try {
            service.drawRectangle(x1, y1, x2, y2);
        } catch (IllegalCoordinatesException ex) {
            fail(ex.getMessage());
        }
    }

    /*
     * Declares the second coordinates that violates the Crypto Rectangle Regulation (y2<=y1)
     * Expects an IllegalCoordinatesException
     */
    @Test
    public void testDrawInappropriateRectangle() {
        int x1 = 1;
        int y1 = 2;

        int x2 = 4;
        int y2 = 2;
        try {
            service.drawRectangle(x1, y1, x2, y2);
        } catch (IllegalCoordinatesException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    /*
     * Provides a rectangle (1,2)(4,6)
     * Expects a filled rectangle
     */
    @Test
    public void testFillBucket() {
        int x1 = 1;
        int y1 = 2;
        int x2 = 4;
        int y2 = 6;
        try {
            Canvas.getInstance(20, 20);
            //Draws a rectangle to fill inside
            service.drawRectangle(x1, y1, x2, y2);
            //Fill in the blank pixel
            service.fillBucket(2, 3, "c");
            assertEquals("c", Canvas.getInstance().getMatrix()[2][3]);
        } catch (IllegalCoordinatesException | IllegalDimensionValueException ex) {
            fail(ex.getMessage());
        }
    }
}
