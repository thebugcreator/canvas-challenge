package com.crypto.canvas.model;

import com.crypto.canvas.CryptoCanvasException;

/**
 * This interface is recognised the general abstract strategy in implementing Strategy Design Pattern
 * Applying Strategy Design Pattern will ease the process of scaling the application if new functions are added in the future
 */
public interface ICommand {
    int EXECUTED = 1;

    /**
     * Method for calling by objects created by the concrete classes
     * Implementing concrete classes perform this method differently on their own logic.
     *
     * @return EXECUTED if executes successfully
     * @throws CryptoCanvasException
     */
    int execute() throws CryptoCanvasException;
}
