package Workbook_2.cellphone_service;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CellPhone newPhone = new CellPhone();

        System.out.print("What is the serial number? ");
        String serialNumber = scanner.nextLine();
        newPhone.setSerialNumber(serialNumber);

        System.out.print("What model is the phone? ");
        String model = scanner.nextLine();
        newPhone.setModel(model);

        System.out.print("Who is the carrier? ");
        String carrier = scanner.nextLine();
        newPhone.setCarrier(carrier);

        System.out.print("What is the phone number? ");
        String phoneNumber = scanner.nextLine();
        newPhone.setPhoneNumber(phoneNumber);

        System.out.print("Who is the owner of the phone? ");
        String owner = scanner.nextLine();
        newPhone.setOwner(owner);

        System.out.println("\n#####Cell Phone Data#####\n");
        System.out.printf("Serial Number is: %s\n", newPhone.getSerialNumber());
        System.out.printf("Model Name: %s\n", newPhone.getModel());
        System.out.printf("Carrier: %s\n", newPhone.getCarrier());
        System.out.printf("Phone Number: %s\n", newPhone.getPhoneNumber());
        System.out.printf("Owner Name: %s\n", newPhone.getOwner());
    }
}
