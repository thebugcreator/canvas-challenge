package com.crypto.canvas.service;

import com.crypto.canvas.IllegalCoordinatesException;
import org.junit.Assert;
import org.junit.Test;

public class CoordinatesServiceTest {

    @Test
    public void testIsValidCoordinates() {
        int x = 1;
        int y = 1;
        try {
            Assert.assertTrue(CoordinatesService.isValidCoordinates(x, y));
        } catch (IllegalCoordinatesException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testIsInvalidCoordinates() {
        int x = 1;
        int y = 0;
        try {
            if (CoordinatesService.isValidCoordinates(x, y)) {
                Assert.fail();
            } else if (CoordinatesService.isValidCoordinates(x, y)) {
                throw new IllegalCoordinatesException("Failed as expected.");
            }
        } catch (IllegalCoordinatesException e) {
            Assert.assertNotNull(e.getMessage());
        }
    }
}
