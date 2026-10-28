package Workbook_3.SearchInventory;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class StoreAppHashMap {

    static BufferedReader bufReader;
    static BufferedWriter bufWriter;
    static Scanner scanner = new Scanner(System.in);
    static HashMap<Integer, Product> inventory = getInventory();

    public static void main(String[] args) {
        homeScreen();
    }

    public static HashMap<Integer, Product> getInventory() {
        HashMap<Integer, Product> inventory = new HashMap<>();

        try {
            bufReader = new BufferedReader(new FileReader("DataFiles/inventory.csv"));
            String product;
            while((product = bufReader.readLine()) != null) {
                String[] input = product.split("\\|");

                int id = Integer.parseInt(input[0]);
                String name = input[1];
                double price = Double.parseDouble(input[2]);

                inventory.put(id, new Product(id, name, price));
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
        int id = Integer.parseInt(scanner.nextLine());

        if (inventory.containsKey(id)) {
            System.out.println("A product with this ID already exists!");
            return;
        }

        System.out.print("Name of Product: ");
        String name = scanner.nextLine();
        System.out.print("Price of Product: ");
        double price = Double.parseDouble(scanner.nextLine());
        Product newProduct = new Product(id, name, price);
        inventory.put(id, newProduct);
        writeToFile(newProduct);

        System.out.println("New Product added into inventory!");
    }

    private static void listAllProduct() {
        System.out.println("We carry the following inventory: ");
        for (Product product : inventory.values()) {
            System.out.print(product);
        }
    }

    private static void findById() {
        System.out.print("What's the ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (inventory.containsKey(id)) {
            System.out.printf("\nItem Found!\n%s", inventory.get(id));
        } else {
            System.out.println("Item Not Found!");
        }
    }

    private static void findByPrice() {
        System.out.print("Min Price: $");
        double minPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Max Price: $");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        boolean isFound = false;
        System.out.println("Searching Items between this price range ...");
        for (Product p : inventory.values()) {
            if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
                isFound = true;
                System.out.print(p);
            }
        }
        if (!isFound) {
            System.out.println("No Product found between provided price range!");
        }
    }

    private static void writeToFile(Product p) {
        try {
            bufWriter = new BufferedWriter(new FileWriter("DataFiles/inventory.csv", true));
            bufWriter.newLine();
            bufWriter.write(String.format("%d|%s|%.2f", p.getId(), p.getName(), p.getPrice()));
        bufWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

