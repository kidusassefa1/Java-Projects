package Workbook_2.Array_Exercise;

import java.util.Scanner;

public class VehicleInventory {
    private static final Vehicle[] vehicleArray = new Vehicle[20];
    private static int count = 0;
    private static final Scanner scanner = new Scanner(System.in);
    private static final int SLEEP_TIME = 1000;

    public static void main(String[] args) throws InterruptedException {
        initVehicles();

        System.out.println("""
                
                ################################
                
                # Welcome to Vehicle Inventory #
                
                ################################""");

        String choice;
        do {
            Thread.sleep(SLEEP_TIME);
            System.out.println("\nWhat do you want to do?\n");
            System.out.print("1 - List all vehicles\n" +
                    "2 - Search by make/model\n" +
                    "3 - Search by price range\n" +
                    "4 - Search by color\n" +
                    "5 - Add a vehicle\n" +
                    "6 - Quit\n" +
                    "Enter your command: ");
            choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> listVehicles();
                case "2" -> searchByMakeModel();
                case "3" -> searchByPrice();
                case "4" -> searchByColor();
                case "5" -> addVehicle();
                case "6" -> System.out.println("Thank you, good bye!");
                default -> System.out.println("Invalid choice! Please enter 1-6.");
            }
        } while (!choice.equals("6"));
    }

    public static void initVehicles() {
        vehicleArray[count++] = new Vehicle(101121,"Ford Explorer","Red",45000,13500);
        vehicleArray[count++] = new Vehicle(101122,"Toyota Camry","Blue",60000,11000);
        vehicleArray[count++] = new Vehicle(101123,"Chevrolet Malibu","Black",50000,9700);
        vehicleArray[count++] = new Vehicle(101124,"Honda Civic","White",70000,7500);
        vehicleArray[count++] = new Vehicle(101125,"Subaru Outback","Green",55000,14500);
        vehicleArray[count++] = new Vehicle(101126,"Jeep Wrangler","Yellow",30000,16000);

//        vehicleArray[count++] = new Vehicle(333122,"BMW M4","Blue",56000,60000);
//        vehicleArray[count++] = new Vehicle(444123,"Chevrolet Malibu","Black",50000,9700);
//        vehicleArray[count++] = new Vehicle(555124,"Honda Accord","White",70000,7500);
//        vehicleArray[count++] = new Vehicle(666125,"Subaru Outback","Green",55000,17500);
//        vehicleArray[count++] = new Vehicle(777126,"Jeep Wrangler","Yellow",30000,13500);
//        vehicleArray[count++] = new Vehicle(888121,"Ford Explorer","Red",45000,13500);
//        vehicleArray[count++] = new Vehicle(999122,"Toyota Camry","Blue",60000,1SLEEP_TIME);
//        vehicleArray[count++] = new Vehicle(211123,"Chevrolet Malibu","Black",50000,9700);
//        vehicleArray[count++] = new Vehicle(311112,"Honda Civic","White",70000,7500);
//        vehicleArray[count++] = new Vehicle(411125,"Subaru Outback","Green",55000,14500);
//        vehicleArray[count++] = new Vehicle(500126,"Jeep Wrangler","Yellow",30000,16000);
//        vehicleArray[count++] = new Vehicle(600121,"Ford Explorer","Red",45000,13500);
//        vehicleArray[count++] = new Vehicle(700122,"Toyota Camry","Blue",60000,1SLEEP_TIME);
    }

    public static void listVehicles() {
        System.out.println("This is what's in inventory:");
        for (int i = 0; i < count; i++) {
            System.out.println(vehicleArray[i]);
        }
    }

    public static void searchByMakeModel() throws InterruptedException {
        System.out.print("What is the Make/Model?: ");
        String makeModel = scanner.nextLine().trim();
        System.out.printf("Checking if '%s' is in inventory . . . \n", makeModel);
        Thread.sleep(SLEEP_TIME);

        boolean isFound = false;
        for (int i = 0; i < count; i++) {
            if (vehicleArray[i].getMakeModel().toLowerCase().contains(makeModel.toLowerCase())) {
                isFound = true;
                System.out.printf("Vehicle ID: %d | Make/Model: %s | Color: %s\n",
                        vehicleArray[i].getVehicleID(),
                        vehicleArray[i].getMakeModel(),
                        vehicleArray[i].getColor()); //TODO maybe toString()
                }
            }
        if (!isFound) {
            System.out.println("Vehicle not found in inventory!");
        }
    }

    public static void searchByPrice() throws InterruptedException {
        System.out.print("Min Price: $");
        double minPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Max Price: $");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.printf("Checking if there are vehicles between $%.2f and $%.2f\n", minPrice, maxPrice);
        Thread.sleep(SLEEP_TIME);

        boolean isFound = false;
        for (int i = 0; i < count; i++) {
            if (vehicleArray[i].getPrice() >= minPrice && vehicleArray[i].getPrice() <= maxPrice) {
                isFound = true;
                System.out.printf("Price: $%.2f | Vehicle ID: %d | Make/Model: %s | Color: %s\n",
                        vehicleArray[i].getPrice(),
                        vehicleArray[i].getVehicleID(),
                        vehicleArray[i].getMakeModel(),
                        vehicleArray[i].getColor()); //TODO toString()
            }
        }
        if (!isFound) {
            System.out.println("Vehicle not found in inventory!");
        }
    }

    public static void searchByColor() throws InterruptedException {
        System.out.print("What is the Color?: ");
        String color = scanner.nextLine();
        System.out.printf("Checking if '%s' is in inventory . . . \n", color);
        Thread.sleep(SLEEP_TIME);

        boolean isFound = false;
        for (int i = 0; i < count; i++) {
            if (vehicleArray[i].getColor().equalsIgnoreCase(color)) {
                isFound = true;
                System.out.printf("Color: %s | Make/Model: %s | Vehicle ID: %d |\n",
                        vehicleArray[i].getColor(),
                        vehicleArray[i].getMakeModel(),
                        vehicleArray[i].getVehicleID()); //TODO toString()
            }
        }
        if (!isFound) {
            System.out.println("No Vehicle found with this color :( ");
        }
    }

    public static void addVehicle() throws InterruptedException {
        if (count >= vehicleArray.length) {
            System.out.println("Inventory Full ... can't add more vehicles!");
        } else {
            System.out.println("Please provide the following information:");
            System.out.print("Vehicle ID: ");
            long vehicleID = scanner.nextLong();
            scanner.nextLine();

            System.out.print("Make/Model: ");
            String makeModel = scanner.nextLine();

            System.out.print("Color: ");
            String color = scanner.nextLine();

            System.out.print("Odometer Reading: ");
            int odometerReading = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            vehicleArray[count++] = new Vehicle(vehicleID, makeModel, color, odometerReading, price);
            Thread.sleep(SLEEP_TIME);
            System.out.println("Vehicle Successfully added!");
        }
    }

}
