package Workbook_4.hotel_operations;


public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    // Constructor 1: No rooms booked yet
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this(name, numberOfSuites, numberOfRooms, 0, 0);
    }

    // Constructor 2: Some rooms already booked
    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {

        if (numberOfSuites < 0 || numberOfRooms < 0 || bookedSuites < 0 || bookedBasicRooms < 0 ||
                bookedSuites > numberOfSuites || bookedBasicRooms > numberOfRooms) {
            throw new IllegalArgumentException("Invalid room inventory");
        }

        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    // Derived getters
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    public boolean bookRoom(int roomCount, boolean suite) {
        if (roomCount <= 0) {
            return false;
        }

        if (suite) {
            if (roomCount > getAvailableSuites()) {
                return false;
            }

            bookedSuites += roomCount;
        } else {
            if (roomCount > getAvailableRooms()) {
                return false;
            }

            bookedBasicRooms += roomCount;
        }

        return true;
    }
}

