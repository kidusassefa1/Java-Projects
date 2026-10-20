package Workbook_2;

import java.util.Scanner;

public class AddressBuilder {
    public static void main(String[] args) {
        StringBuilder address = new StringBuilder();
        StringBuilder billingAddress = new StringBuilder();
        StringBuilder shippingAddress = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Provide the following information:");

        System.out.print("Full Name: ");
        String name = scanner.nextLine();

        System.out.print("Billing Street: ");
        billingAddress.append(scanner.nextLine().trim()).append("\n");

        System.out.print("Billing City: ");
        billingAddress.append(scanner.nextLine().trim()).append(", ");

        System.out.print("Billing State: ");
        billingAddress.append(scanner.nextLine().trim()).append(" ");

        System.out.print("Billing Zip: ");
        billingAddress.append(scanner.nextLine().trim()).append("\n");


        System.out.print("Is shipping address the same as Billing address? (Yes/No): ");
        String isAddressSame = scanner.nextLine().trim();

        if (isAddressSame.equalsIgnoreCase("no")) {
            System.out.print("Shipping Street: ");
            shippingAddress.append(scanner.nextLine().trim()).append("\n");

            System.out.print("Shipping City: ");
            shippingAddress.append(scanner.nextLine().trim()).append(", ");

            System.out.print("Shipping State: ");
            shippingAddress.append(scanner.nextLine().trim()).append(" ");

            System.out.print("Shipping Zip: ");
            shippingAddress.append(scanner.nextLine().trim());

        } else if (isAddressSame.equalsIgnoreCase("yes")){
            shippingAddress.append(billingAddress);

        } else {
            System.out.println("Please enter either Yes or No, closing application ...");
            return;
        }

        address.append("\n").append(name)
                .append("\n\nBilling Address:\n")
                .append(billingAddress)
                .append("\nShipping Address:\n")
                .append(shippingAddress);

        String myAddress = address.toString();
        System.out.println(myAddress);
    }
}
