package org.pluralsight;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number 1: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter Number 2: ");
        int num2 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What do you want to do? Choose from the following options:");
        System.out.println("(A)dd\n" +
                "(S)ubtract\n" +
                "(M)ultiply\n" +
                "(D)ivide\n" +
                "Only choose the letters.");

        String action = scanner.nextLine();

        if (action.equals("A") || action.equals("a") ) {
            System.out.println("Addition Chosen!");
            int sum = num1+num2;
            System.out.printf("%d + %d = %d", num1, num2, sum);
        } else if (action.equals("S") || action.equals("s")) {
            System.out.println("Subtraction Chosen!");
            int subtract = num1 - num2;
            System.out.printf("%d - %d = %d", num1, num2, subtract);
        } else if (action.equals("M") || action.equals("m")) {
            System.out.println("Multiplication Chosen!");
            int multiply = num1 * num2;
            System.out.printf("%d x %d = %d", num1, num2, multiply);
        } else if (action.equals("D") || action.equals("d")) {
            System.out.println("Division Chosen!");
            double divide = (double) num1 / num2;
            System.out.printf("%d / %d = %.3f", num1, num2, divide);
        } else {
            System.out.println("Wrong choice, closing now ...");
        }
    }
}
