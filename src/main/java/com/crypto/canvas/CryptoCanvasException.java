package com.crypto.canvas;

public class CryptoCanvasException extends Exception {
    private String message;

    public CryptoCanvasException() {

    }

    public CryptoCanvasException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Error: " + message;
    }

    public void printMessage() {
        System.out.println(getMessage());
    }
}
