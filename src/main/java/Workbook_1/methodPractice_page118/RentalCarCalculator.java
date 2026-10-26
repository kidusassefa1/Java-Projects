package Workbook_1.methodPractice_page118;

import java.util.Scanner;

public class RentalCarCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome! What is the pickup date?: ");
        String pickupDate = scanner.nextLine();

        System.out.println("Number of days for the rental?: ");
        int numDays = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Would you want an electronic toll tag at $3.95/day (Yes/No)?: ");
        boolean hasTollTag = scanner.nextBoolean();





    }



}
