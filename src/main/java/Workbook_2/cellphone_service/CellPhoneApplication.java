package Workbook_2.cellphone_service;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {

        CellPhone newPhone1 = new CellPhone();
        newPhone1.setOwner("Kidus");
        newPhone1.setSerialNumber("662813");
        newPhone1.setCarrier("Verison");
        newPhone1.setPhoneNumber("512-552-1454");
        newPhone1.setModel("Samsung Galaxy S20");

        CellPhone newPhone2 = new CellPhone();
        newPhone2.setOwner("Eyob");
        newPhone2.setSerialNumber("987654");
        newPhone2.setCarrier("T-Mobile");
        newPhone2.setPhoneNumber("206-112-4424");
        newPhone2.setModel("iPhone 15 Pro Max");

        CellPhone newPhone3 = new CellPhone("114214", "Samsung", "Verizon", "448-112-1991","Selam");

        display(newPhone1);
        display(newPhone2);
        display(newPhone3);

        // bottom two lines should have the same result
        newPhone1.dial(newPhone2.getPhoneNumber());
        newPhone1.dail(newPhone2);

        newPhone2.dial(newPhone1.getPhoneNumber());

        newPhone1.dail(newPhone3);

    }

    public static void display(CellPhone phone) {
        System.out.printf("This phone (Model: %s) is owned by %s. It is using %s as carrier and has phone number %s.\n",
                phone.getModel(), phone.getOwner(), phone.getCarrier(), phone.getPhoneNumber());
    }
}
