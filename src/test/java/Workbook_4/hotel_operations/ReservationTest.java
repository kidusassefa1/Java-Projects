package Workbook_4.hotel_operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @Test
    void testKingReservation() {
        Reservation reservation = new Reservation("king", 3, false);

        assertEquals("king", reservation.getRoomType());
        assertEquals(139.00, reservation.getPrice());
        assertEquals(417.00, reservation.getReservationTotal());
    }

    @Test
    void testWeekendReservation() {
        Reservation reservation = new Reservation("double", 2, true);

        assertEquals(136.40, reservation.getPrice(), 0.001);
        assertEquals(272.80, reservation.getReservationTotal(), 0.001);
    }

}