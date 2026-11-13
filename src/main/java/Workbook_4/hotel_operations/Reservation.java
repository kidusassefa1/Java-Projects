package Workbook_4.hotel_operations;


public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean weekend;

    public Reservation(String roomType, int numberOfNights, boolean weekend) {
        setRoomType(roomType);
        setNumberOfNights(numberOfNights);
        this.weekend = weekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        if (!roomType.equalsIgnoreCase("king") &&
                !roomType.equalsIgnoreCase("double")) {
            throw new IllegalArgumentException("Invalid room type");
        }

        this.roomType = roomType.toLowerCase();
    }

    public double getPrice() {
        double price;

        if (roomType.equals("king")) {
            price = 139.00;
        } else {
            price = 124.00;
        }

        if (weekend) {
            price *= 1.10;
        }

        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        if (numberOfNights <= 0) {
            throw new IllegalArgumentException("Nights must be positive");
        }

        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }
}

