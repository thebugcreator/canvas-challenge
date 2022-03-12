package com.crypto.canvas.model;

import com.crypto.canvas.IllegalCoordinatesException;
import com.crypto.canvas.service.CanvasService;
import com.crypto.canvas.service.CoordinatesService;

public class FillBucketCommand implements ICommand {
    private final int x;
    private final int y;
    private final String colour;

    public FillBucketCommand(String _x, String _y, String colour) {
        this.x = Integer.parseInt(_x);
        this.y = Integer.parseInt(_y);
        this.colour = colour;
    }

    @Override
    public int execute() throws IllegalCoordinatesException {
        CoordinatesService.isValidCoordinates(x, y);
        CanvasService service = new CanvasService();
        service.fillBucket(x, y, colour);
        return EXECUTED;
    }

}
