package Workbook_2;

import java.util.Scanner;

public class FullNameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter Your Name!");
        System.out.print("First Name?: ");
        String firstName = scanner.nextLine();

        System.out.print("Middle Name?: ");
        String middleName = scanner.nextLine();

        System.out.print("Last Name?: ");
        String lastName = scanner.nextLine();

        System.out.print("Suffix? (Press Enter if none): ");
        String suffix = scanner.nextLine();

        String fullName = firstName;

        if (!middleName.isBlank()) {
            fullName += " " + middleName;
        }

        fullName += " " + lastName;

        if (!suffix.isBlank()) {
            fullName += ", " + suffix;
        }

        System.out.println("Full Name: " + fullName);

    }
}
