package Workbook_3.SearchInventory;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {

    static BufferedReader bufReader;
    static BufferedWriter bufWriter;
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> inventory = getInventory();

    public static void main(String[] args) {
        homeScreen();
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();

        try {
            bufReader = new BufferedReader(new FileReader("DataFiles/inventory.csv"));
            String product;
            while((product = bufReader.readLine()) != null) {
                String[] input = product.split("\\|");

                int id = Integer.parseInt(input[0]);
                String name = input[1];
                double price = Double.parseDouble(input[2]);

                inventory.add(new Product(id,name, price));
            }
            bufReader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }

    private static void homeScreen() {
        String choice;
        do {
            System.out.print("\nWhat do you want to do?\n" +
                               "1- List all products\n" +
                               "2- Lookup a product by its id\n" +
                               "3- Find all products within a price range\n" +
                               "4- Add a new product\n" +
                               "5- Quit the application\n" +
                               "Enter command: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1" -> listAllProduct();
                case "2" -> findById();
                case "3" -> findByPrice();
                case "4" -> addProduct();
                case "5" -> System.out.println("Thank you, good bye!");
                default -> System.out.println("Invalid choice! Please enter 1-3.");
            }
        } while (!choice.equals("5"));
    }

    private static void addProduct() {
        System.out.print("What's the ID: ");
        int ID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name of Product?: ");
        String name = scanner.nextLine();
        System.out.print("Price of Product? ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        inventory.add(new Product(ID, name, price));

        System.out.println("New Product added into inventory!");
    }

    private static void listAllProduct() {
        System.out.println("We carry the following inventory: ");
        for (Product p : inventory) {
            System.out.printf("id: %d | Name: %s | Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    private static void findById() {
        System.out.println("What's the ID: ");
        String ID = scanner.nextLine();

        for (Product p : inventory) {
            if (p.getId() == Integer.parseInt(ID)) {
                System.out.printf("\nItem Found! %d -- %s -- %f", p.getId(), p.getName(), p.getPrice());
                return;
            }
        }
        System.out.println("Item Not Found!");
    }

    private static void findByPrice() {
        System.out.print("Min Price: $");
        double minPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Max Price: $");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        boolean isFound = false;
        for (Product p : inventory) {
            if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
                isFound = true;
                System.out.printf("\nItem Found! %d -- %s -- %f", p.getId(), p.getName(), p.getPrice());

            }
        }
        if (!isFound) {
            System.out.println("No Product found between provided price range!");
        }
    }

    private static void writeToFile() {
        try {
            bufWriter = new BufferedWriter(new FileWriter("DataFiles/inventory.csv", true));



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

