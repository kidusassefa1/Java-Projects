package Workbook_5.Workshop_5W;

import java.io.*;
import java.math.BigDecimal;

public class DealershipFileManager {
    private BufferedReader bufReader;
    private static BufferedWriter bufWriter;
    private static final String fileName = "DataFile_Workshop_4w/inventory.csv";
    private Dealership dealership;

    public Dealership getDealership() {
        dealership = new Dealership("Auto Dealership", "100 Lane Rd", "206-112-3355");

        try {
            bufReader = new BufferedReader(new FileReader(fileName));
            String transaction;
            bufReader.readLine();
            while((transaction = bufReader.readLine()) != null) {
                String[] input = transaction.trim().split("\\|");

                int vin = Integer.parseInt(input[0]);
                int year = Integer.parseInt(input[1]);
                String make = input[2];
                String model = input[3];
                String vehicleType = input[4];
                String color = input[5];
                int odometer = Integer.parseInt(input[6]);
                BigDecimal price = new BigDecimal(input[7]);

                dealership.inventory.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
            }
            bufReader.close();

        } catch(IOException e) {
            e.printStackTrace();
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try {
            bufWriter = new BufferedWriter(new FileWriter(fileName));

            bufWriter.write(String.format("%s|%s|%s", dealership.getName(), dealership.getAddress(), dealership.getPhone()));
            bufWriter.newLine();
            for (Vehicle vehicle : dealership.inventory) {
                bufWriter.write(String.format("%s", vehicle));
                bufWriter.newLine();
            }
            bufWriter.close();

        } catch (IOException e) {
            System.out.print("ERROR: An unexpected error occurred");
            e.printStackTrace();
        }
    }

}
