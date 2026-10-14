package org.pluralsight;

public class MathApp {
    public static void main(String[] args) {
// Question 1:
// declare variables here
        double bobSalary = 120000;
        double garySalary = 98500;
        double highestSalary = Math.max(bobSalary, garySalary);
        int carPrice = 26500;
        int truckPrice= 25500;
        double radius = 7.25;
        double number = 5.0;
// then code solution
// then use System.out.println() to display results
        System.out.println("The highest salary is: " + highestSalary);
        System.out.println("The lowest vehicle price is: " + Math.min(carPrice, truckPrice));
        System.out.println("Area of a circle with radius " + radius + " is " + Math.PI * Math.pow(radius, 2));

        double squareRoot = Math.sqrt(number);
        System.out.println("The square root is " + squareRoot);

        double x1 = 5;
        double y1 = 10;
        double x2 = 85;
        double y2 = 50;
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("The distance is " + distance);

        double myNumber = -3.8;
        double absoluteValue = Math.abs(myNumber);
        System.out.println("The absolute value is " + absoluteValue);

        double randomNumber = Math.random();
        System.out.println("Random number: " + randomNumber);

        int days = 24;
        int hoursPerDay = 24;
        int minutesPerHour = 60;
        int totalMinutes = days * hoursPerDay * minutesPerHour;
        System.out.println("Total minutes: " + totalMinutes);
    }
}
