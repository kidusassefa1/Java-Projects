package Workbook_4.hotel_operations;


import java.time.LocalDateTime;
import java.time.Duration;

public class Employee {

    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private LocalDateTime punchInTime;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getRegularHours() {
        return Math.min(hoursWorked, 40);
    }

    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    public double getTotalPay() {
        return (getRegularHours() * payRate)
                + (getOvertimeHours() * payRate * 1.5);
    }

    public void punchIn(int time) {
        punchInTime = LocalDateTime.now().withHour(time).withMinute(0).withSecond(0).withNano(0);
    }

    public void punchIn() {
        punchInTime = LocalDateTime.now();
    }

    public void punchOut(int time) {
        if (punchInTime == null) {
            return;
        }

        LocalDateTime punchOutTime = LocalDateTime.now().withHour(time).withMinute(0).withSecond(0).withNano(0);

        double hours = Duration.between(punchInTime, punchOutTime).toMinutes() / 60.0;

        hoursWorked += hours;
        punchInTime = null;
    }

    public void punchOut() {
        if (punchInTime == null) {
            return;
        }

        LocalDateTime punchOutTime = LocalDateTime.now();

        double hours = Duration.between(punchInTime, punchOutTime).toMinutes() / 60.0;

        hoursWorked += hours;
        punchInTime = null;
    }
}


