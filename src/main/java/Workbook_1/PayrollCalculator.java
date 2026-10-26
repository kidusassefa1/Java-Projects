package Workbook_1;

import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.printf("Hi %s, How many hours did you work? ", name);
        float hours = scanner.nextFloat();

        System.out.print("What is your pay rate? $");
        float payRate = scanner.nextFloat();

        if ( hours > 40) {
            float totalPay = ((hours - 40) * 1.5f * payRate) + (40 * payRate);
            System.out.printf("%s, you have overtime this week. Your pay for this work week is: $%.2f? ", name, totalPay);
        } else {
            float totalPay = hours * payRate;
            System.out.printf("%s, your pay for this work week is: $%.2f? ", name, totalPay);
        }
    }
}
