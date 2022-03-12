package com.crypto.canvas.main;

import com.crypto.canvas.CommandSyntaxException;
import com.crypto.canvas.CryptoCanvasException;
import com.crypto.canvas.model.ICommand;

import java.util.Scanner;

import static com.crypto.canvas.service.CanvasConsoleService.print;
import static com.crypto.canvas.service.CanvasConsoleService.solveCommand;

public class CryptoCanvasMain {
    public static void main(String[] args) {
        System.out.println("Enter command>");
        Scanner scanner;
        String command;
        while (true) {
            scanner = new Scanner(System.in);
            command = scanner.nextLine();
            try {
                if (solveCommand(command).execute() == ICommand.EXECUTED) {
                    print();
                }
            } catch (CommandSyntaxException cmdEx) {
                cmdEx.suggestsCommand();
            } catch (CryptoCanvasException e) {
                e.printMessage();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }


}
