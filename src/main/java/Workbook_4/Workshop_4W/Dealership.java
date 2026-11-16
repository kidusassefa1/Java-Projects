package Workbook_4.Workshop_4W;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {
    public String name;
    public String address;
    public String phone;
    public ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventoryByPrice(BigDecimal min, BigDecimal max) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        if (min.compareTo(max) > 0) {
            System.out.println("Min value can't be greater than Max");
            return null;
        } else {
            for (Vehicle vehicle : inventory) {
                if (vehicle.price.compareTo(min) <= 0 && vehicle.price.compareTo(max) >= 0) {
                    vehicleList.add(vehicle);
                }
            }
            return vehicleList;
        }
    }

    public ArrayList<Vehicle> getInventoryByMakeModel(String make, String model) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.model.equalsIgnoreCase(model) && vehicle.make.equalsIgnoreCase(make)) {
                vehicleList.add(vehicle);
            }
        }
        return vehicleList;

    }

    public ArrayList<Vehicle> getInventoryByYear(int min, int max) {
        return null;
    }

    public ArrayList<Vehicle> getInventoryByColor(String color) {
        return null;
    }

    public ArrayList<Vehicle> getInventoryByMileage(BigDecimal min, BigDecimal max) {
        return null;
    }

    public ArrayList<Vehicle> getInventoryByType(String vehicleType) {
        return null;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return null;
    }

    public void addVehicles(Vehicle vehicle) {

    }

    public void removeVehicle(Vehicle vehicle) {

    }


}
