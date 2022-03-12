package com.crypto.canvas.model;

public class QuitCommand implements ICommand {
    @Override
    public int execute() {
        System.out.println("Application is closed.");
        System.exit(0);
        return EXECUTED;
    }
}
