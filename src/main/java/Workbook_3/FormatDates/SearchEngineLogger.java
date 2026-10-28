package Workbook_3.FormatDates;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    static BufferedWriter bufWriter;
    static Scanner scanner = new Scanner(System.in);
    static LocalDateTime date;

    public static void main(String[] args) {
        String choice;
        do {
            logger("Launch");
            System.out.println("Welcome to Joogle!");
            System.out.print("What would you like to search?: ");
            String search = scanner.nextLine();
            logger(search);
            System.out.println("I'll tell you later about it!");
            System.out.print("What do you want to?\n" +
                               "1. Try Again\n" +
                               "2. Exit\n" +
                               "(Write the words): ");
            choice = scanner.nextLine();
            logger(choice);
        } while (!choice.equalsIgnoreCase("Exit"));
        logger("--------------");
    }

    static void logger(String text) {
        try {
            bufWriter = new BufferedWriter(new FileWriter("log.txt", true));
            date = LocalDateTime.now();
            String timestamp = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            bufWriter.write(String.format("[%s] %s%n", timestamp, text));
            bufWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
