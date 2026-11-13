package Workbook_4.hotel_operations;

public class Room {
    public double price;
    public int numberOfBeds;
    public boolean isOccupied;
    public boolean isDirty;

    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public boolean isAvailable() {
        return !isOccupied && !isDirty;
    }

    public boolean checkIn() {
        if (!isAvailable()) {
            return false;
        }
        isDirty = true;
        isOccupied = true;
        return true;
    }

    public void checkOut() {
        if (isOccupied) {
            isOccupied = false;
        }
        cleanroom();
    }

    public void cleanroom() {
        isDirty = false;
    }
}
