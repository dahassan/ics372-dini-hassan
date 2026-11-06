package main.java.edu.metrostate.oodi.hotel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private final List<Room> rooms;
    private final List<RoomType> roomTypes;
    private final List<Reservation> reservations;
    private final List<Guest> guests;
    private int confirmationCounter = 1000;
    private int billCounter = 5000;

    public Hotel() {
        this.rooms = new ArrayList<>();
        this.roomTypes = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.guests = new ArrayList<>();

        initializeCatalog();
    }

    private void initializeCatalog() {
        RoomType standard = new RoomType("Standard", 129, 159, 2, 1);
        RoomType deluxe = new RoomType("Deluxe", 179, 219, 3, 1);
        RoomType suite = new RoomType("Suite", 289, 349, 4, 2);
        roomTypes.add(standard);
        roomTypes.add(deluxe);
        roomTypes.add(suite);
        rooms.add(new Room("101", 1, standard));
        rooms.add(new Room("102", 1, standard));
        rooms.add(new Room("201", 2, deluxe));
        rooms.add(new Room("301", 3, suite));
    }

    public Room findRoom(String roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber().equals(roomNumber)) {
                return r;
            }
        }

        throw new IllegalArgumentException("No room found with number " + roomNumber);
    }

    public List<Room> findAvailableRooms(LocalDate startDate, LocalDate endDate, int guestCount) {
        int nights = (int) ChronoUnit.DAYS.between(startDate, endDate);
        List<Room> available = new ArrayList<>();

        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);

            if (room.isInService() == false) {
                continue;
            }

            RoomType rt = room.getRoomType();

            if (rt.getMaximumGuests() < guestCount) {
                continue;
            }

            if (rt.allowsStayLength(nights) == false) {
                continue;
            }

            if (room.isFree(startDate, endDate, reservations)) {
                available.add(room);
            }
        }
        return available;
    }

    public Guest findOrRecordGuest(String name, String email, String phone) {
        for (Guest g : guests) {
            if (g.getEmail().equalsIgnoreCase(email)) {
                return g;
            }
        }
        Guest newGuest = new Guest(name, email, phone);
        guests.add(newGuest);

        return newGuest;
    }
    public Reservation findReservation(String confirmationNumber) {
        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);

            if (r.getConfirmationNumber().equals(confirmationNumber)) {
                return r;
            }
        }
        throw new IllegalArgumentException("No reservation found with confirmation number " + confirmationNumber);
    }
    public Reservation reserveRoom(String roomNumber, LocalDate startDate, LocalDate endDate, int guestCount, String name, String email, String phone, LocalDate today) {
        Room room = findRoom(roomNumber);

        boolean isFree = room.isFree(startDate, endDate, reservations);
        if (!isFree) {
            throw new IllegalStateException("Room " + roomNumber + " is no longer available on those dates.");
        }

        Guest guest = findOrRecordGuest(name, email, phone);
        confirmationCounter++;
        String confNum = "H" + confirmationCounter;

        Reservation reservation = new Reservation(confNum, guest, room, startDate, endDate, guestCount, today);
        reservations.add(reservation);

        return reservation;
    }

    public void cancelReservation(String confirmationNumber) {
        
        Reservation res = findReservation(confirmationNumber);

        if (res.getStatus() == ReservationStatus.CANCELLED) {
            throw new IllegalStateException("Reservation is already cancelled.");
        }

        if (res.getStatus() == ReservationStatus.CHECKED_IN || res.getStatus() == ReservationStatus.COMPLETED) {
            throw new IllegalStateException("Reservation cannot be cancelled because its status is " + res.getStatus());
        }

        res.cancel();
    }
    public void checkIn(String confirmationNumber, LocalDate today, LocalDateTime checkInTime) {
        Reservation res = findReservation(confirmationNumber);
        res.checkIn(checkInTime, today);
    }
    public Bill checkOut(String roomNumber, LocalDateTime checkOutTime, LocalDate issueDate, boolean needsRepair) {
        Reservation activeRes = null;

        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            boolean roomMatch = r.getRoom().getRoomNumber().equals(roomNumber);
            boolean statusMatch = r.getStatus() == ReservationStatus.CHECKED_IN;

            if (roomMatch && statusMatch) {
                activeRes = r;
                break;
            }
        }

        if (activeRes == null) {
            throw new IllegalStateException("There is no stay in progress in room " + roomNumber);
        }
        billCounter++;
        String billNum = "B" + billCounter;
        Bill bill = activeRes.complete(checkOutTime, issueDate, billNum);
        if (needsRepair) {
            activeRes.getRoom().setInService(false);
        }

        return bill;
    }
    public void changeRate(String roomTypeName, int weekdayRate, int weekendRate) {
        for (int i = 0; i < roomTypes.size(); i++) {
            RoomType rt = roomTypes.get(i);

            if (rt.getName().equalsIgnoreCase(roomTypeName)) {
                rt.setRates(weekdayRate, weekendRate);
            }
        }
    }
}
