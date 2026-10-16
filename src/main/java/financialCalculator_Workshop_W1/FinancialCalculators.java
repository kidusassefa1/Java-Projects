package financialCalculator_Workshop_W1;

import java.util.Scanner;

public class FinancialCalculators {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Welcome to your Financial Calculator!\n" +
                "Which calculator do you want to use?\n" +
                "1. Mortgage Calculator\n" +
                "2. Future Value Calculator\n" +
                "3. Present Value Calculator\n" +
                "Choose 1, 2 or 3: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 3) {
            System.out.print("What's the monthly payout?: ");
        } else {
            System.out.print("What's the Principal?: ");
        }
        double principal = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("What's the interest rate?: ");
        double annualInterest = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("For how many years?: ");
        int years = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            mortgageCalculator(principal, annualInterest, years);
        } else if (choice == 2) {
            futureValueCalculator(principal, annualInterest, years);
        } else if (choice == 3) {
            presentValueCalculator(principal, annualInterest, years);
        }
    }

    public static void mortgageCalculator(double principal, double annualInterest, int years) {

        double i = (annualInterest / 100) / 12;
        int n = years * 12;

        double monthlyPayment = principal * (i * (Math.pow(1 + i, n))) / ((Math.pow(1 + i, n)) - 1);

        double totalInterest = (monthlyPayment * n) - principal;

        System.out.printf("Your monthly payment is %.3f and your total interst is %.3f", monthlyPayment, totalInterest);
        System.out.println();
    }

    public static void futureValueCalculator(double p, double r, int t) {
        int d = 365;
        int n = d * t;

        double fv = p * (Math.pow(1 + ((r /100) / d), n));
        double totalInterestEarned = fv - p;

        System.out.printf("your CD's ending balance will be %.3f and you would have earned %.3f in interest", fv, totalInterestEarned);
    }

    public static void presentValueCalculator(double monthlyPayout, double annualRate, int years) {
        int n = years * 12;
        double i = (annualRate / 100) / 12;

        double pv = monthlyPayout * (1 - (Math.pow(1 + i, -n))) / i;

        System.out.printf("To fund an annuity that pays %.3f monthly for %d years\n" +
                "and earns an expected %f interest, you would need to invest %.3f today!", monthlyPayout, years, annualRate, pv);
    }
}
