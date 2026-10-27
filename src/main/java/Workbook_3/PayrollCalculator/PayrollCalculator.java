package Workbook_3.PayrollCalculator;

import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {
    static BufferedReader bufReader;
    static BufferedWriter bufWriter;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Employee[] employeeArray = new Employee[15];

        boolean isJSON = false;

        String[] choices = homeScreen();
        if (choices[1].toLowerCase().endsWith(".json")) {
            isJSON = true;
        }

        readFile(choices[0], employeeArray);
        writeFile(choices[1], employeeArray, isJSON);

    }

    static String[] homeScreen() {
        String[] choices = new String[2];
        System.out.print("Enter the name of the file to process: ");
        choices[0] = "DataFiles/" + scanner.nextLine().trim();
        System.out.print("Enter the name of the payroll file to create: ");
        choices[1] = scanner.nextLine().trim();

        return choices;
    }


    static void readFile(String readFileName, Employee[] employeeArray) {
        try {
            String employeeData;
            int count = 0;

            bufReader = new BufferedReader(new FileReader(readFileName));
            bufReader.readLine();
            while((employeeData = bufReader.readLine()) != null) {
                String[] input = employeeData.split("\\|");

                int id = Integer.parseInt(input[0]);
                String name = input[1];
                double hoursWorked = Double.parseDouble(input[2]);
                double payRate = Double.parseDouble(input[3]);

                employeeArray[count++] = new Employee(id, name, hoursWorked, payRate);
            }
            bufReader.close();
        } catch(FileNotFoundException e) {
            System.out.println("File Not Found!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void writeFile(String writeFileName, Employee[] employeeArray, boolean isJSON) {
        try {
            bufWriter = new BufferedWriter(new FileWriter(writeFileName));

            bufWriter.write("ID  |    Name    |    Gross pay\n");
            for (Employee employee : employeeArray) {
                if (employee != null) {
                    bufWriter.write(employee.getEmployeeId() + " | " + employee.getName() + " | " + employee.getGrossPay() + "\n");
                }
            }
            bufWriter.close();
        } catch (IOException e) {
            System.out.print("ERROR: An unexpected error occurred");
            e.printStackTrace();
        }
    }
}


