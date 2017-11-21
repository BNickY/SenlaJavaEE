package com.senla.bookshop.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleReader {
    private static Scanner scanner = new Scanner(System.in);

    public static long getNextLong() {
        long parsedNumber = 0;
        boolean isParsed = true;
        while (isParsed) {
            try {
                parsedNumber = Long.parseLong(scanner.nextLine());
                isParsed = false;
            } catch (NumberFormatException e) {
                Printer.printMessage("Incorrect input!!!\nTry again: ");
            }
        }
        return parsedNumber;
    }

    public static int getNextInt() {
        int parsedNumber = 0;
        boolean isParsed = true;
        while (isParsed) {
            try {
                parsedNumber = Integer.parseInt(scanner.nextLine());
                isParsed = false;
            } catch (NumberFormatException e) {
                Printer.printMessage("Incorrect input!!!\nTry again: ");
            }
        }
        return parsedNumber;
    }

    public static String getNextLine() {
        return scanner.nextLine();
    }

    public static double getNextDouble() {
        double parsedNumber = 0;
        boolean isParsed = true;
        while (isParsed) {
            try {
                parsedNumber = Double.parseDouble(scanner.nextLine());
                isParsed = false;
            } catch (NumberFormatException e) {
                Printer.printMessage("Incorrect input!!!\nTry again: ");
            }
        }
        return parsedNumber;
    }

    public static LocalDate getDate(){
        LocalDate parsedDate = LocalDate.now();
        boolean isParsed = true;
        while (isParsed) {
            try {
                parsedDate = LocalDate.parse(scanner.nextLine());
                isParsed = false;
            } catch (DateTimeParseException e) {
                Printer.printMessage("Incorrect input: " + e.getParsedString() + "\nTry again: ");
            }
        }
        return parsedDate;
    }
}
