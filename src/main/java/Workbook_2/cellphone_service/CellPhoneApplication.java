package Workbook_2.cellphone_service;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        CellPhone newPhone1 = new CellPhone();
        CellPhone newPhone2 = new CellPhone();
//
//        System.out.print("What is the serial number? ");
//        String serialNumber = scanner.nextLine();
//        newPhone1.setSerialNumber(serialNumber);
//
//        System.out.print("What model is the phone? ");
//        String model = scanner.nextLine();
//        newPhone1.setModel(model);
//
//        System.out.print("Who is the carrier? ");
//        String carrier = scanner.nextLine();
//        newPhone1.setCarrier(carrier);
//
//        System.out.print("What is the phone number? ");
//        String phoneNumber = scanner.nextLine();
//        newPhone1.setPhoneNumber(phoneNumber);
//
//        System.out.print("Who is the owner of the phone? ");
//        String owner = scanner.nextLine();
//        newPhone1.setOwner(owner);

        newPhone1.setOwner("Kidus");
        newPhone1.setSerialNumber("662813");
        newPhone1.setCarrier("Verison");
        newPhone1.setPhoneNumber("512-552-1454");
        newPhone1.setModel("Samsung Galaxy S20");

        newPhone2.setOwner("Eyob");
        newPhone2.setSerialNumber("987654");
        newPhone2.setCarrier("T-Mobile");
        newPhone2.setPhoneNumber("206-112-4424");
        newPhone2.setModel("iPhone 15 Pro Max");

        display(newPhone1);
        display(newPhone2);

        newPhone1.dial(newPhone2.getPhoneNumber());
        newPhone2.dial(newPhone1.getPhoneNumber());


//        System.out.println("\n#####Cell Phone Data#####\n");
//        System.out.printf("Serial Number is: %s\n", newPhone1.getSerialNumber());
//        System.out.printf("Model Name: %s\n", newPhone1.getModel());
//        System.out.printf("Carrier: %s\n", newPhone1.getCarrier());
//        System.out.printf("Phone Number: %s\n", newPhone1.getPhoneNumber());
//        System.out.printf("Owner Name: %s\n", newPhone1.getOwner());
    }

    public static void display(CellPhone phone) {
        System.out.printf("This phone (Model: %s) is owned by %s. It is using %s as carrier and has phone number %s.\n",
                phone.getModel(), phone.getOwner(), phone.getCarrier(), phone.getPhoneNumber());
    }
}
