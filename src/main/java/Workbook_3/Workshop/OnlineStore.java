package Workbook_3.Workshop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

public class OnlineStore {
    static BufferedReader bufReader;
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> inventory = getInventory();
    static ArrayList<Product> cart = new ArrayList<>();

    public static void main(String[] args) {

        homeScreen();

    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        try {
            bufReader = new BufferedReader(new FileReader("DataFiles/products.csv"));
            String product;
            bufReader.readLine();
            while((product = bufReader.readLine()) != null) {
                String[] input = product.split("\\|");

                String sku = input[0];
                String name = input[1];
                double price = Double.parseDouble(input[2]);
                String department = input[3];

                inventory.add(new Product(sku,name, price, department));
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
                    "1- Display Products\n" +
                    "2- Display Cart\n" +
                    "3- Exit\n" +
                    "Enter command: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1" -> displayProducts();
                case "2" -> displayCart();
                case "3" -> System.out.println("Thank you, good bye!");
                default -> System.out.println("Invalid choice! Please enter 1-3.");
            }
        } while (!choice.equals("3"));
    }

    private static void displayProducts() {
        String choice;

        do {
            System.out.println("\nWe carry the following products:\n");

            for (Product p : inventory) {
                System.out.println(p);
            }

            System.out.print("""

                1- Search for an item
                2- Add to cart
                3- Go back to main screen
                Enter command:
                """);

            choice = scanner.nextLine();

            switch (choice) {
                case "1" -> searchProducts();
                case "2" -> addToCart();
                case "3" -> System.out.println("Returning to home screen...");
                default -> System.out.println("Invalid choice!");
            }
        } while (!choice.equals("3"));
    }

    private static void displayCart() {
        String choice;
        do {
            System.out.println("\n========== YOUR SHOPPING CART ==========");

            double total = 0;

            if (cart.isEmpty()) {
                System.out.println("Your cart is empty!");
            } else {
                for (Product p : cart) {
                    System.out.println(p);
                    total += p.getPrice();
                }
            }

            System.out.printf("----------------------------------------%n");
            System.out.printf("Total: $%.2f%n", total);
            System.out.println("========================================");

            System.out.print("""

                What would you like to do?
                1- Check Out
                2- Remove Product
                3- Go Back to Home Screen
                Enter command: """);

            choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> System.out.println("Checkout is coming soon!");
                case "2" -> removeFromCart();
                case "3" -> System.out.println("Returning to home screen...");
                default -> System.out.println("Invalid choice! Please enter 1-3.");
            }


        } while (!choice.equals("3"));
    }



    private static void searchProducts() {
        System.out.print("""

            How would you like to search?
            1- Search by Product Name
            2- Search by Price Range
            3- Search by Department
            4- Go Back
            Enter command: """);

        String choice = scanner.nextLine();
        boolean isFound = false;
        switch (choice) {
            case "1" -> {
                System.out.print("Enter product name: ");
                String name = scanner.nextLine().trim();

                for (Product p : inventory) {
                    if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                        System.out.println(p);
                        isFound = true;
                    }
                }
            }

            case "2" -> {
                try {
                    System.out.print("Enter minimum price: $");
                    double minPrice = Double.parseDouble(scanner.nextLine());

                    System.out.print("Enter maximum price: $");
                    double maxPrice = Double.parseDouble(scanner.nextLine());

                    if (minPrice < 0 || maxPrice < minPrice) {
                        System.out.println("Invalid price range!");
                        return;
                    }

                    for (Product p : inventory) {
                        if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
                            System.out.println(p);
                            isFound = true;
                        }
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid price.");
                    return;
                }
            }

            case "3" -> {
                System.out.print("Enter department: ");
                String department = scanner.nextLine().trim();

                for (Product p : inventory) {
                    if (p.getDepartment().equalsIgnoreCase(department)) {
                        System.out.println(p);
                        isFound = true;
                    }
                }
            }

            case "4" -> {
                return;
            }

            default -> {
                System.out.println("Invalid choice! Please enter 1-4.");
                return;
            }
        }

        if (!isFound) {
            System.out.println("No products found matching your search.");
        }
    }

    private static void addToCart() {
        System.out.print("Enter the SKU of the product you want to add: ");
        String sku = scanner.nextLine().trim();

        for (Product p : inventory) {
            if (p.getSku().equalsIgnoreCase(sku)) {
                cart.add(p);
                System.out.printf("%n%s has been added to your cart!%n", p.getName());
                return;
            }
        }

        System.out.println("Product not found! Please check the SKU and try again.");
    }

    private static void removeFromCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is already empty!");
            return;
        }

        System.out.print("Enter the SKU of the product to remove: ");
        String sku = scanner.nextLine().trim();

        for (Product p : cart) {
            if (p.getSku().equalsIgnoreCase(sku)) {
                cart.remove(p);
                System.out.printf("%s has been removed from your cart!%n", p.getName());
                return;
            }
        }

        System.out.println("Product not found in your cart!");
    }

}
