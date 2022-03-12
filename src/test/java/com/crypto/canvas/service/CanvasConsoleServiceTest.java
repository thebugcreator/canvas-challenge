package com.crypto.canvas.service;

import com.crypto.canvas.CommandSyntaxException;
import com.crypto.canvas.InvalidCommandException;
import com.crypto.canvas.model.*;
import org.junit.Assert;
import org.junit.Test;

public class CanvasConsoleServiceTest {

    @Test
    public void testSolveCreateCanvasCommand() {
        String cmd = "c 10 10";
        try {
            ICommand command = CanvasConsoleService.solveCommand(cmd);
            Assert.assertTrue(command instanceof CreateCanvasCommand);
        } catch (CommandSyntaxException | InvalidCommandException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testSolveDrawLineCommand() {
        String cmd = "l 1 1 1 4";
        try {
            ICommand command = CanvasConsoleService.solveCommand(cmd);
            Assert.assertTrue(command instanceof DrawLineCommand);
        } catch (CommandSyntaxException | InvalidCommandException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testSolveDrawRectangleCommand() {
        String cmd = "r 1 1 2 4";
        try {
            ICommand command = CanvasConsoleService.solveCommand(cmd);
            Assert.assertTrue(command instanceof DrawRectangleCommand);
        } catch (CommandSyntaxException | InvalidCommandException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testSolveFillBucketCommand() {
        String cmd = "b 1 1 c";
        try {
            ICommand command = CanvasConsoleService.solveCommand(cmd);
            Assert.assertTrue(command instanceof FillBucketCommand);
        } catch (CommandSyntaxException | InvalidCommandException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testSolveQuitCommand() {
        String cmd = "q";
        try {
            ICommand command = CanvasConsoleService.solveCommand(cmd);
            Assert.assertTrue(command instanceof QuitCommand);
        } catch (CommandSyntaxException | InvalidCommandException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testSolveInvalidCommand() {
        String cmd = "a b c";
        try {
            CanvasConsoleService.solveCommand(cmd);
        } catch (CommandSyntaxException | InvalidCommandException e) {
            Assert.assertNotNull(e.getMessage());
        }
    }
}
