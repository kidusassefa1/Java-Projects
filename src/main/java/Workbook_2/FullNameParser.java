package Workbook_2;

import java.util.Scanner;

public class FullNameParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please Enter Your Full Name: ");
        String fulltName = scanner.nextLine().trim();

        String[] nameParts = fulltName.split(" ");

        String firstName = "";
        String middleName = "";
        String lastName = "";

        if (nameParts.length == 3) {
            firstName = nameParts[0];
            middleName = nameParts[1];
            lastName = nameParts[2];
        } else {
            firstName += nameParts[0];
            middleName = "N/A";
            lastName += nameParts[1];
        }

        System.out.printf("First Name: %s\n" +
                          "Middle Name: %s\n" +
                          "Last Name: %s", firstName, middleName, lastName);



    }
}
