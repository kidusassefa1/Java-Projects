package Workbook_4.hotel_operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void testAvailableRooms() {
        Hotel hotel = new Hotel("Grand Hotel", 10, 20);

        assertEquals(10, hotel.getAvailableSuites());
        assertEquals(20, hotel.getAvailableRooms());
    }

    @Test
    void testBookRoom() {
        Hotel hotel = new Hotel("Grand Hotel", 10, 20);

        assertTrue(hotel.bookRoom(3, true));
        assertEquals(7, hotel.getAvailableSuites());

        assertTrue(hotel.bookRoom(5, false));
        assertEquals(15, hotel.getAvailableRooms());
    }

    @Test
    void testOverbooking() {
        Hotel hotel = new Hotel("Grand Hotel", 5, 10);

        assertFalse(hotel.bookRoom(6, true));
        assertEquals(5, hotel.getAvailableSuites());
    }

}