package Workbook_4.Workshop_4W;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
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
            return vehicleList;
        } else {
            for (Vehicle vehicle : inventory) {
                if (vehicle.getPrice().compareTo(min) >= 0 && vehicle.getPrice().compareTo(max) <= 0) {
                    vehicleList.add(vehicle);
                }
            }
            return vehicleList;
        }
    }

    public ArrayList<Vehicle> getInventoryByMakeModel(String make, String model) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getModel().equalsIgnoreCase(model) && vehicle.getMake().equalsIgnoreCase(make)) {
                vehicleList.add(vehicle);
            }
        }
        return vehicleList;

    }

    public ArrayList<Vehicle> getInventoryByYear(int min, int max) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        if (min > max) {
            System.out.println("Min value can't be greater than Max");
            return vehicleList;
        } else {
            for (Vehicle vehicle : inventory) {
                if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                    vehicleList.add(vehicle);
                }
            }
        }
        return vehicleList;
    }

    public ArrayList<Vehicle> getInventoryByColor(String color) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                vehicleList.add(vehicle);
            }
        }
        return vehicleList;
    }

    public ArrayList<Vehicle> getInventoryByMileage(int min, int max) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                vehicleList.add(vehicle);
            }
        }
        return vehicleList;
    }

    public ArrayList<Vehicle> getInventoryByType(String vehicleType) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                vehicleList.add(vehicle);
            }
        }
        return vehicleList;
    }

    public ArrayList<Vehicle> getAllVehicles() {

        return new ArrayList<>(inventory);
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
}
