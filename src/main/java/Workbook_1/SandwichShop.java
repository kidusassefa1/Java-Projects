package Workbook_1;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What Sandwich size would you like?\n" +
                "1: Regular: base price $5.45\n" +
                "2: Large: base price $8.95\n" +
                "Please pick 1 or 2: ");
        int size = scanner.nextInt();
        scanner.nextLine();


        System.out.print("Would you like the sandwich loaded? (Yes/No): ");
        String wantsLoaded = scanner.nextLine();


        System.out.print("What is your age?\n" +
                "A: Student (17 years old or younger)\n" +
                "B: Seniors (65 years old or older) \n" +
                "C: Neither\n" +
                "Please pick A or B: ");

        String age = scanner.nextLine();

        float loadedPrice;
        float discount;

        if (wantsLoaded.equalsIgnoreCase("yes") && size == 1) {
            loadedPrice = 1.00f;
        } else if (wantsLoaded.equalsIgnoreCase("yes") && size == 2) {
            loadedPrice = 1.75f;
        } else {
            loadedPrice = 0;
        }

        if (age.equals("A")) {
            System.out.println("A 10% discount is applied to your total!");
            discount = 0.1f;
        } else if (age.equals("B")) {
            System.out.println("A 20% discount is applied to your total!");
            discount = 0.2f;
        } else {
            discount = 1f;
        }

        if (size == 1) {
            float totalPrice = 5.45f + (5.45f * discount) + loadedPrice;
            System.out.printf("Your total is %.2f", totalPrice);
        } else if (size == 2) {
            float totalPrice = 8.95f + (8.95f * discount) + loadedPrice;
            System.out.printf("Your total is %.2f", totalPrice);
        } else {
            System.out.println("Wrong Choice, try again ...");
        }
    }
}
