package Workbook_4.hotel_operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testRegularPay() {
        Employee employee = new Employee(101, "John", "Front Desk", 20.00, 40);

        assertEquals(40, employee.getRegularHours());
        assertEquals(0, employee.getOvertimeHours());
        assertEquals(800.00, employee.getTotalPay());
    }

    @Test
    void testOvertimePay() {
        Employee employee = new Employee(102, "Sarah", "Housekeeping", 20.00, 45);

        assertEquals(40, employee.getRegularHours());
        assertEquals(5, employee.getOvertimeHours());
        assertEquals(950.00, employee.getTotalPay());
    }

    @Test
    void testPunchInAndOut() {
        Employee employee = new Employee(103, "Mike", "Maintenance", 20.00, 0);

        employee.punchIn(9);
        employee.punchOut(17);

        assertEquals(8, employee.getHoursWorked(), 0.001);
    }

}