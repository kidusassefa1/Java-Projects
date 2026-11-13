package Workbook_4.hotel_operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void testRoomAvailability() {
        Room room = new Room(2, 124.00, false, false);

        assertEquals(2, room.getNumberOfBeds());
        assertEquals(124.00, room.getPrice());
        assertTrue(room.isAvailable());
    }

    @Test
    void testCheckInAndCheckOut() {
        Room room = new Room(1, 139.00, false, false);

        assertTrue(room.checkIn());
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
        assertFalse(room.isAvailable());

        room.checkOut();

        assertFalse(room.isOccupied());
        assertTrue(room.isAvailable());

        room.cleanroom();

        assertFalse(room.isDirty());
        assertTrue(room.isAvailable());
    }
}