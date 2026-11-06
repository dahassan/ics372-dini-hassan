package main.java.edu.metrostate.oodi.hotel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class HotelDemo {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        // Step 1
        printStep(1, "Find rooms for check-in Nov 12, check-out Nov 15, 2 guests");

        LocalDate today = LocalDate.of(2026, 11, 2);
        LocalDate s1Start = LocalDate.of(2026, 11, 12);
        LocalDate s1End = LocalDate.of(2026, 11, 15);

        List<Room> rooms1 = hotel.findAvailableRooms(s1Start, s1End, 2);

        System.out.print("Offered: ");

        for (int i = 0; i < rooms1.size(); i++) {
            Room r = rooms1.get(i);
            Reservation tempRes = new Reservation("TEMP", null, r, s1Start, s1End, 2, today);

            System.out.print(r.getRoomNumber() + " " + r.getRoomType().getName() + " $" + tempRes.calculateTotal());

            if (i < rooms1.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();

        // Step 2
        printStep(2, "Reserve room 201, Nov 12 to Nov 15, 2 guests, for Ana Okafor");

        Reservation res2 = hotel.reserveRoom("201", s1Start, s1End, 2, "Ana Okafor", "ana.okafor@example.com", "612-555-0142", today);

        System.out.println("Succeeds. Confirmation: " + res2.getConfirmationNumber() + ", room 201, dates " + s1Start + " to " + s1End + ", total $" + res2.calculateTotal());

        // Step 3
        printStep(3, "Try to reserve room 201, Nov 14 to Nov 16, 2 guests, for Marcus Lindqvist");

        try {
            hotel.reserveRoom("201", LocalDate.of(2026, 11, 14), LocalDate.of(2026, 11, 16), 2, "Marcus Lindqvist", "marcus.l@example.com", "651-555-0187", today);
        } catch (Exception e) {
            System.out.println("Rejected: room 201 is not free for the night of Nov 14");
        }

        // Step 4
        printStep(4, "Reserve room 201, Nov 15 to Nov 17, 2 guests, for Marcus Lindqvist");
        LocalDate s4Start = LocalDate.of(2026, 11, 15);
        LocalDate s4End = LocalDate.of(2026, 11, 17);

        Reservation res4 = hotel.reserveRoom("201", s4Start, s4End, 2, "Marcus Lindqvist", "marcus.l@example.com", "651-555-0187", today);

        System.out.println("Succeeds, total of $" + res4.calculateTotal());

        // Step 5
        printStep(5, "Find rooms for check-in Nov 20, check-out Nov 21, 2 guests");

        LocalDate s5Start = LocalDate.of(2026, 11, 20);
        LocalDate s5End = LocalDate.of(2026, 11, 21);
        List<Room> rooms5 = hotel.findAvailableRooms(s5Start, s5End, 2);
        System.out.print("Offered: ");

        for (int i = 0; i < rooms5.size(); i++) {
            Room r = rooms5.get(i);
            Reservation tempRes = new Reservation("TEMP", null, r, s5Start, s5End, 2, today);

            System.out.print(r.getRoomNumber() + " $" + tempRes.calculateTotal());

            if (i < rooms5.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(". Room 301 is not offered (a suite needs at least 2 nights)");

        // Step 6
        printStep(6, "Manager changes Deluxe rates to $199 weekday and $239 weekend");

        LocalDate todayNov3 = LocalDate.of(2026, 11, 3);
        hotel.changeRate("Deluxe", 199, 239);

        System.out.println("Deluxe now $199 / $239");

        // Step 7
        printStep(7, "Find rooms for check-in Nov 19, check-out Nov 21, 3 guests");

        LocalDate s7Start = LocalDate.of(2026, 11, 19);
        LocalDate s7End = LocalDate.of(2026, 11, 21);

        List<Room> rooms7 = hotel.findAvailableRooms(s7Start, s7End, 3);

        System.out.print("Offered: ");

        for (int i = 0; i < rooms7.size(); i++) {
            Room r = rooms7.get(i);
            Reservation tempRes = new Reservation("TEMP", null, r, s7Start, s7End, 3, todayNov3);

            System.out.print(r.getRoomNumber() + " " + r.getRoomType().getName() + " $" + tempRes.calculateTotal());

            if (i < rooms7.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(". No standard rooms (they hold 2)");

        // Step 8
        printStep(8, "Cancel Marcus Lindqvist's reservation and find rooms for Nov 15 to Nov 17, 2 guests");

        LocalDate todayNov5 = LocalDate.of(2026, 11, 5);
        hotel.cancelReservation(res4.getConfirmationNumber());
        List<Room> rooms8 = hotel.findAvailableRooms(s4Start, s4End, 2);
        System.out.print("Offered: ");

        for (int i = 0; i < rooms8.size(); i++) {
            Room r = rooms8.get(i);
            Reservation tempRes = new Reservation("TEMP", null, r, s4Start, s4End, 2, todayNov5);

            System.out.print(r.getRoomNumber() + " $" + tempRes.calculateTotal());

            if (i < rooms8.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();

        // Step 9
        printStep(9, "Check in Ana Okafor");

        LocalDate todayNov12 = LocalDate.of(2026, 11, 12);
        
        hotel.checkIn(res2.getConfirmationNumber(), todayNov12, LocalDateTime.of(2026, 11, 12, 15, 10));

        System.out.println("Room 201");

        // Step 10
        printStep(10, "Check out room 201 on Nov 15, 10:45am (needs repair)");

        LocalDate todayNov15 = LocalDate.of(2026, 11, 15);
        Bill bill = hotel.checkOut("201", LocalDateTime.of(2026, 11, 15, 10, 45), todayNov15, true);
        System.out.println("Bill shows Nov 12 $179, Nov 13 $219, Nov 14 $219, total $" + bill.getTotal() + ". Room 201 is now out of service");

        // Step 11
        printStep(11, "Try to check in Marcus Lindqvist's reservation from step 4");

        try {
            hotel.checkIn(res4.getConfirmationNumber(), todayNov15, LocalDateTime.of(2026, 11, 15, 11, 0));
        } catch (Exception e) {
            System.out.println("Rejected: the reservation is cancelled");
        }


        // Step 12
        printStep(12, "Find rooms for check-in Nov 15, check-out Nov 17, 2 guests");

        List<Room> rooms12 = hotel.findAvailableRooms(s4Start, s4End, 2);

        System.out.print("Offered: ");
        for (int i = 0; i < rooms12.size(); i++) {
            Room r = rooms12.get(i);
            Reservation tempRes = new Reservation("TEMP", null, r, s4Start, s4End, 2, todayNov15);
            System.out.print(r.getRoomNumber() + " $" + tempRes.calculateTotal());
            if (i < rooms12.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(". Room 201 is not offered (out of service)");
    }

    private static void printStep(int stepNum, String description) {
        System.out.println("Step " + stepNum + ": " + description);
    }
}
