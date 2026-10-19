package Workbook_2;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please Enter Your Full Name: ");
        String[] fullName = scanner.nextLine().split(" ");

        String firstName = fullName[0];
        String lastName = fullName[1];

        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        LocalDate movieDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        System.out.print("How many tickets would you like?: " );
        int ticket = scanner.nextInt();
        scanner.nextLine();

        if (ticket == 1) {
            System.out.printf("%d ticket reserved for %s under %s, %s", ticket, movieDate, lastName, firstName);
        } else {
            System.out.printf("%d tickets reserved for %s under %s, %s", ticket, movieDate, lastName, firstName);
        }

    }
}
