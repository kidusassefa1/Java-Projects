
package Workbook_5.Workshop_5W;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private final Dealership dealership;
    private final DealershipFileManager dfm;
    private final Scanner scanner;

    public UserInterface() {
        dfm = new DealershipFileManager();
        dealership = dfm.getDealership();
        scanner = new Scanner(System.in);
    }

    public void display() {
        int choice;

        do {
            System.out.println("\n========== CAR DEALERSHIP ==========");
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("10 - Sell or Lease a Vehicle");
            System.out.println("0 - Quit");

            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    processSellLeaseVehicleRequest();
                    break;
                case 99:
                    System.out.println("Thank you for using Car Dealership!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 99);
    }

    private void processGetByPriceRequest() {
        System.out.println("\n--- Search by Price ---");

        BigDecimal min = readBigDecimal("Enter minimum price: ");
        BigDecimal max = readBigDecimal("Enter maximum price: ");

        if (min.compareTo(max) > 0) {
            System.out.println("Minimum price cannot be greater than maximum.");
            return;
        }

        ArrayList<Vehicle> vehicles =
                dealership.getInventoryByPrice(min, max);

        displayVehicles(vehicles);
    }

    private void processGetByMakeModelRequest() {
        System.out.println("\n--- Search by Make/Model ---");

        System.out.print("Enter vehicle make: ");
        String make = scanner.nextLine().trim();

        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine().trim();

        ArrayList<Vehicle> vehicles = dealership.getInventoryByMakeModel(make, model);

        displayVehicles(vehicles);
    }

    private void processGetByYearRequest() {
        System.out.println("\n--- Search by Year ---");

        int min = readInt("Enter minimum year: ");
        int max = readInt("Enter maximum year: ");

        if (min > max) {
            System.out.println("Minimum year cannot be greater than maximum.");
            return;
        }

        ArrayList<Vehicle> vehicles = dealership.getInventoryByYear(min, max);

        displayVehicles(vehicles);
    }

    private void processGetByColorRequest() {
        System.out.println("\n--- Search by Color ---");

        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine().trim();

        ArrayList<Vehicle> vehicles =
                dealership.getInventoryByColor(color);

        displayVehicles(vehicles);
    }

    private void processGetByMileageRequest() {
        System.out.println("\n--- Search by Mileage ---");

        int min = readInt("Enter minimum mileage: ");
        int max = readInt("Enter maximum mileage: ");

        if (min > max) {
            System.out.println("Minimum mileage cannot be greater than maximum.");
            return;
        }

        ArrayList<Vehicle> vehicles =
                dealership.getInventoryByMileage(min, max);

        displayVehicles(vehicles);
    }

    private void processGetByVehicleTypeRequest() {
        System.out.println("\n--- Search by Vehicle Type ---");
        System.out.print("Enter type (car, truck, SUV, van): ");

        String vehicleType = scanner.nextLine().trim();

        ArrayList<Vehicle> vehicles =
                dealership.getInventoryByType(vehicleType);

        displayVehicles(vehicles);
    }

    private void processGetAllVehiclesRequest() {
        System.out.println("\n--- All Vehicles ---");

        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void processAddVehicleRequest() {
        System.out.println("\n--- Add a Vehicle ---");

        int vin = readInt("Enter VIN: ");

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                System.out.println("A vehicle with this VIN already exists.");
                return;
            }
        }

        int year = readInt("Enter year: ");

        System.out.print("Enter make: ");
        String make = scanner.nextLine().trim();

        System.out.print("Enter model: ");
        String model = scanner.nextLine().trim();

        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine().trim();

        System.out.print("Enter color: ");
        String color = scanner.nextLine().trim();

        int odometer = readInt("Enter mileage: ");
        BigDecimal price = readBigDecimal("Enter price: ");

        if (year <= 0 || odometer < 0 || price.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Invalid year, mileage, or price.");
            return;
        }

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price
        );

        dealership.addVehicle(vehicle);
        dfm.saveDealership(dealership);

        System.out.println("Vehicle added successfully!");
    }

    private void processRemoveVehicleRequest() {
        System.out.println("\n--- Remove a Vehicle ---");

        displayVehicles(dealership.getAllVehicles());

        int vin = readInt("Enter VIN of vehicle to remove: ");

        Vehicle vehicleToRemove = null;

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.println("\nVehicle found:");
        System.out.println(vehicleToRemove);

        System.out.print("Are you sure you want to remove it? (Y/N): ");
        String confirmation = scanner.nextLine().trim();

        if (confirmation.equalsIgnoreCase("Y")) {
            dealership.removeVehicle(vehicleToRemove);
            dfm.saveDealership(dealership);

            System.out.println("Vehicle removed successfully!");
        } else {
            System.out.println("Removal cancelled.");
        }
    }

    private void displayVehicles(ArrayList<Vehicle> vehicleList) {
        if (vehicleList == null || vehicleList.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        System.out.println("----------------------------------------");

        int count = 1;

        for (Vehicle vehicle : vehicleList) {
            System.out.printf("%d - %s%n", count++, vehicle);
        }

        System.out.println("----------------------------------------");
        System.out.println("Total vehicles: " + vehicleList.size());
    }

    private void processSellLeaseVehicleRequest() {
        processGetAllVehiclesRequest();
        int vin = readInt("Enter VIN: ");
        Vehicle selectedVehicle = null;

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                selectedVehicle = vehicle;
                break;
            }
        }

        if (selectedVehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.println("1 - Sell\n2 - Lease");
        int choice = readInt("Choose an option: ");

        if (choice != 1 && choice != 2) {
            System.out.println("Invalid option.");
            return;
        }

        if (choice == 2 && Year.now().getValue() - selectedVehicle.getYear() > 3) {
            System.out.println("Vehicle is too old to lease.");
            return;
        }

        System.out.print("Customer name: ");
        String name = scanner.nextLine();

        System.out.print("Customer email: ");
        String email = scanner.nextLine();

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        Contract contract;

        if (choice == 1) {
            System.out.print("Financing? (Y/N): ");
            boolean financing = scanner.nextLine().equalsIgnoreCase("Y");
            contract = new SalesContract(date, name, email, selectedVehicle, financing);
        } else {
            contract = new LeaseContract(date, name, email, selectedVehicle);
        }

        System.out.printf("Total: $%,.2f%n", contract.getTotalPrice());
        System.out.printf("Monthly: $%,.2f%n", contract.getMonthlyPayment());

        System.out.print("Confirm transaction? (Y/N): ");
        if (!scanner.nextLine().equalsIgnoreCase("Y")) {
            System.out.println("Transaction cancelled.");
            return;
        }

        ContractDataManager manager = new ContractDataManager();
        manager.saveContract(contract);
        dealership.removeVehicle(selectedVehicle);
        dfm.saveDealership(dealership);

        System.out.println("Transaction completed!");
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);

            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private BigDecimal readBigDecimal(String prompt) {
        while (true) {
            System.out.print(prompt);

            try {
                return new BigDecimal(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
