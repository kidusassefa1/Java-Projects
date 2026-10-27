package Workbook_3.PayrollCalculator;

import java.time.LocalTime;

public class Employee {
    private final int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getGrossPay() {
        return this.payRate * this.hoursWorked;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee ID: %d%n" +
                        "Name: %s%n" +
                        "Hours Worked: %.2f%n" +
                        "Pay Rate: $%.2f%n" +
                        "Gross Pay: $%.2f%n",
                employeeId, name, hoursWorked, payRate, getGrossPay()
        );
    }
}
