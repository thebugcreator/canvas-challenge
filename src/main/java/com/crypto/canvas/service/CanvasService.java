package com.crypto.canvas.service;

import com.crypto.canvas.IllegalCoordinatesException;
import com.crypto.canvas.model.Canvas;

public class CanvasService {
    private static final int HORIZONTAL_LINE = 1;
    private static final int VERTICAL_LINE = 2;

    /**
     * Choosing line type to draw from the first point to the second point
     *
     * @param _x1 x value of the first point
     * @param _y1 y value of the first point
     * @param _x2 x value of the second point
     * @param _y2 y value of the second point
     * @return type of the line, HORIZONTAL_LINE or VERTICAL_LINE
     * @throws IllegalCoordinatesException if there is no vertical or horizontal line could be drawn
     */
    private static int chooseLineType(int _x1, int _y1, int _x2, int _y2) throws IllegalCoordinatesException {
        if (_x1 == _x2) {
            return HORIZONTAL_LINE;
        } else if (_y1 == _y2) {
            return VERTICAL_LINE;
        } else {
            throw new IllegalCoordinatesException("None existence of either a horizontal line or vertical line.");
        }
    }

    /**
     * (x1,y1) must act as the upper left corner while (x2,y2) acts the role of the lower right corner
     * That means x1 must be smaller than x2, same condition applied to y1 and y2
     *
     * @param _x1 x value of the first point
     * @param _y1 y value of the first point
     * @param _x2 x value of the second point
     * @param _y2 y value of the second point
     * @return true if coordinates are appropriate to draw a proper rectangle that satisfies the Crypto's regulation
     */
    private static boolean isFollowingCryptoRectangleRegulation(int _x1, int _y1, int _x2, int _y2) {
        return _x1 < _x2 && _y1 < _y2;
    }

    /**
     * Using the strategy of filling a plus shape (+) to navigate looking for pixel that could be filled.
     * Another strategy to apply is using square shape to surf the surrounding pixels. It seems to be more resource-consuming
     * This method could be called recursively until no more pixel could be filled.
     *
     * @param x      current x coordinate of working pixel
     * @param y      current y coordinate of working pixel
     * @param colour the colour to be used filling the pixel if it's eligible.
     */
    private static void fillPlusShape(int x, int y, String colour) {
        Canvas canvas = Canvas.getInstance();
        if (x < 1 || x > canvas.getWidth() + 1 || y < 1 || y > canvas.getHeight() + 1) {
            return;
        }
        String currentPixel = canvas.getMatrix()[x - 1][y - 1];
        if (Canvas.SIGN.equals(currentPixel) || colour.equals(currentPixel)) {
            return;
        }
        canvas.getMatrix()[x - 1][y - 1] = colour;
        if (x > 1)
            fillPlusShape(x - 1, y, colour);
        if (y > 1)
            fillPlusShape(x, y - 1, colour);
        if (x < canvas.getWidth())
            fillPlusShape(x + 1, y, colour);
        if (y < canvas.getHeight())
            fillPlusShape(x, y + 1, colour);
    }

    /**
     * Start filling the first pixel, and let it call itself recursively.
     *
     * @param x      the x value of desired pixel
     * @param y      the y value of desired pixel
     * @param colour the colour to fill in the pixel if eligible.
     */
    public void fillBucket(int x, int y, String colour) {
        fillPlusShape(x, y, colour);
    }

    /**
     * Draws a line between 2 coordinates
     *
     * @param _x1 x value of the first point
     * @param _y1 y value of the first point
     * @param _x2 x value of the second point
     * @param _y2 y value of the second point
     * @throws IllegalCoordinatesException if the input coordinates is illegal
     */
    public void drawLine(int _x1, int _y1, int _x2, int _y2) throws IllegalCoordinatesException {
        Canvas canvas = Canvas.getInstance();
        int lineType = chooseLineType(_x1, _y1, _x2, _y2);
        int head;
        int tail;
        if (lineType == VERTICAL_LINE) {
            //Can use shortened if-else instead, but it requires the system to compute twice.
            if (_x1 < _x2) {
                head = _x1;
                tail = _x2;
            } else {
                tail = _x1;
                head = _x2;
            }
            for (int i = head; i < tail + 1; i++) {
                canvas.insert(i, _y1);
            }
        } else if (lineType == HORIZONTAL_LINE) {
            if (_y1 < _y2) {
                head = _y1;
                tail = _y2;
            } else {
                tail = _y1;
                head = _y2;
            }
            for (int j = head; j < tail + 1; j++) {
                canvas.insert(_x1, j);
            }
        }
    }

    /**
     * Draws a rectangle that follows the Crypto Rectangle Regulation
     * The strategy is to create:
     * a vertical line from A(x1,y1) to B (x2,y1)
     * a horizontal line from A(x1,y1) to D (x1,y2)
     * a vertical line from D(x1,y2) to C(x2,y2)
     * a horizontal line from B(x2,y1) to C(x2,y2)
     * All those lines will shape a rectangle
     *
     * @param _x1 x value of the first point
     * @param _y1 y value of the first point
     * @param _x2 x value of the second point
     * @param _y2 y value of the second point
     * @throws IllegalCoordinatesException see {@link CanvasService}.drawLine()
     */
    public void drawRectangle(int _x1, int _y1, int _x2, int _y2) throws IllegalCoordinatesException {
        if (isFollowingCryptoRectangleRegulation(_x1, _y1, _x2, _y2)) {
            try {
                drawLine(_x1, _y1, _x2, _y1);
                drawLine(_x1, _y1, _x1, _y2);
                drawLine(_x1, _y2, _x2, _y2);
                drawLine(_x2, _y1, _x2, _y2);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else
            throw new IllegalCoordinatesException("Enter the coordinates of upper left corner first, and lower right corner later.");
    }
}
