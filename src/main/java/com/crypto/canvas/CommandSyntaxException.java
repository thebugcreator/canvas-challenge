package com.crypto.canvas;

public class CommandSyntaxException extends CryptoCanvasException {

    public CommandSyntaxException(String message) {
        super(message);
    }

    public void suggestsCommand() {
        System.out.println("C w h: Creates new canvas with desired width and height.");
        System.out.println("L x1 y1 x2 y2: Draws a line from (x1;y1) to (x2;y2).");
        System.out.println("R x1 y1 x2 y2: Draws a rectangle with (x1;y1) as the upper left corner and \n (x2;y2) as the lower right corner.");
        System.out.println("B x y c: Fills the surrounding of (x;y) by colour c.");
        System.out.println("Q: Quit this application.");
    }
}
