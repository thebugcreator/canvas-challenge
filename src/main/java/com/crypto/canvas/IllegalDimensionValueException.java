package com.crypto.canvas;

/**
 * Exception code: CC0101
 * An instance of this exception is thrown when user has assigned an inappropriate value for a dimension of the canvas
 */
public class IllegalDimensionValueException extends CryptoCanvasException {
    //Name of the illegal dimension
    private String dimension;
    //Value assigned to the dimension by user
    private int value;

    public IllegalDimensionValueException(String message) {
        super(message);
    }

    public IllegalDimensionValueException(String dimensionName, int value) {
        super();
        this.dimension = dimensionName;
        this.value = value;
    }

    @Override
    public String getMessage() {
        super.getMessage();
        return "Dimension " + dimension + " with value " + value + " is not accepted.";
    }
}
