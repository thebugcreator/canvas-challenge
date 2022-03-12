package com.crypto.canvas.service;

import com.crypto.canvas.CommandSyntaxException;
import com.crypto.canvas.InvalidCommandException;
import com.crypto.canvas.model.*;

public class CanvasConsoleService {
    public static void print() {
        Canvas canvas = Canvas.getInstance();
        for (int i = 0; i <= canvas.getWidth() + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int j = 0; j < canvas.getHeight(); j++) {
            for (int i = 0; i <= canvas.getWidth() + 1; i++) {
                if (i == 0 || i == canvas.getWidth() + 1) {
                    System.out.print("|");
                } else {
                    System.out.print(canvas.getMatrix()[i - 1][j]);
                }
            }
            System.out.println();
        }
        for (int i = 0; i <= canvas.getWidth() + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static ICommand solveCommand(String cmd) throws CommandSyntaxException, InvalidCommandException {
        try {
            String[] params = cmd.split(" ");
            String cmdType = params[0].toLowerCase();
            switch (cmdType) {
                case "c":
                    return new CreateCanvasCommand(params[1], params[2]);
                case "l":
                    return new DrawLineCommand(params[1], params[2], params[3], params[4]);
                case "r":
                    return new DrawRectangleCommand(params[1], params[2], params[3], params[4]);
                case "b":
                    return new FillBucketCommand(params[1], params[2], params[3]);
                case "q":
                    return new QuitCommand();
                default:
                    throw new CommandSyntaxException("Command syntax error.");
            }
        } catch (NullPointerException | IndexOutOfBoundsException | NumberFormatException ex) {
            throw new InvalidCommandException("Invalid Command.");
        }
    }

}
