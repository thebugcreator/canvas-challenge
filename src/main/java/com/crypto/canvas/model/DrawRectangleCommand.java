package com.crypto.canvas.model;

import com.crypto.canvas.IllegalCoordinatesException;
import com.crypto.canvas.service.CanvasService;
import com.crypto.canvas.service.CoordinatesService;

public class DrawRectangleCommand implements ICommand {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public DrawRectangleCommand(String _x1, String _y1, String _x2, String _y2) {
        this.x1 = Integer.parseInt(_x1);
        this.y1 = Integer.parseInt(_y1);
        this.x2 = Integer.parseInt(_x2);
        this.y2 = Integer.parseInt(_y2);
    }

    @Override
    public int execute() throws IllegalCoordinatesException {
        CoordinatesService.isValidCoordinates(x1, y1);
        CoordinatesService.isValidCoordinates(x2, y2);
        CanvasService service = new CanvasService();
        service.drawRectangle(x1, y1, x2, y2);
        return EXECUTED;
    }
}
