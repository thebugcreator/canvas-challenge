package com.crypto.canvas.model;

import com.crypto.canvas.IllegalCoordinatesException;
import com.crypto.canvas.IllegalDimensionValueException;

import java.util.Arrays;

/**
 * This class is the holder class of a Singleton Design Pattern implementation
 *
 */
public class Canvas {

    public static final String SIGN = "x";
    //The object to return lazily.
    private static Canvas canvas;
    private int width;
    private int height;
    private String[][] matrix;

    // Private constructor to use internally, preventing instantiation
    private Canvas(int width, int height) throws IllegalDimensionValueException {
        this.width = width;
        this.height = height;
        buildFreshCanvas();
    }

    //Method to create new canvas with given specifications
    public static Canvas getInstance(int width, int height) throws IllegalDimensionValueException {
        canvas = null;
        canvas = new Canvas(width, height);
        return canvas;
    }

    //Method to retrieve the current canvas, or to create a default 20x10-pixel canvas if it has not been intialised.
    public static Canvas getInstance() {
        if (canvas == null) {
            System.out.println("No canvas specifications have been given, creating default canvas (20x10)");
            try {
                //Initialising default canvas object
                getInstance(20, 10);
            } catch (IllegalDimensionValueException ex) {
                //As the default dimension values have been correctly assigned, there is no need handling this exception
                System.out.println("Automatically created canvas always has proper dimensions.");
            }
        }
        return canvas;
    }

    //Create canvas matrix and fill all pixels with a space
    private void buildFreshCanvas() throws IllegalDimensionValueException {
        if (width < 1) {
            throw new IllegalDimensionValueException("width", width);
        }
        if (height < 1) {
            throw new IllegalDimensionValueException("height", height);
        } else {
            this.matrix = new String[width][height];
            reset();
        }

    }

    //Fill all pixels in the canvas with a space
    public void reset() {
        for (String[] strings : matrix) {
            Arrays.fill(strings, " ");
        }
    }

    //Insert a SIGN = "x" to chosen coordinates
    public String insert(int x, int y) throws IllegalCoordinatesException {
        if (x < 1 || x > width || y < 1 || y > height) {
            throw new IllegalCoordinatesException("Entered coordinates are not accepted.");
        } else {
            this.matrix[x - 1][y - 1] = SIGN;
        }
        return this.matrix[x - 1][y - 1];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String[][] getMatrix() {
        return matrix;
    }
}
