package com.crypto.canvas.model;

import com.crypto.canvas.IllegalDimensionValueException;

public class CreateCanvasCommand implements ICommand {
    private final int width;
    private final int height;

    public CreateCanvasCommand(String _w, String _h) throws NumberFormatException {
        this.width = Integer.parseInt(_w);
        this.height = Integer.parseInt(_h);
    }

    @Override
    public int execute() throws IllegalDimensionValueException {
        Canvas.getInstance(width, height);
        return EXECUTED;
    }
}
