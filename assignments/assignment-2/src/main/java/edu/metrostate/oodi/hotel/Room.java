package main.java.edu.metrostate.oodi.hotel;

import java.time.LocalDate;
import java.util.List;

public class Room {

    private final String roomNumber;
    private final int floor;
    private boolean inService;
    private final RoomType roomType;
    public Room(String roomNumber, int floor, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.inService = true;
        this.roomType = roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
    public int getFloor() {
        return floor;
    }
    public boolean isInService() {
        return inService;
    }
     public RoomType getRoomType() {
        return roomType;
    }

    public void setInService(boolean inService) {
        this.inService = inService;
    }

   

    public boolean isFree(LocalDate startDate, LocalDate endDate, List<Reservation> reservations) {
        if (inService == false) {
            return false;
        }

        LocalDate current = startDate;

        while (current.isBefore(endDate)) {
            final LocalDate night = current;

            for (int i = 0; i < reservations.size(); i++) {
                Reservation res = reservations.get(i);
                boolean isActive = (res.getStatus() == ReservationStatus.CONFIRMED || res.getStatus() == ReservationStatus.CHECKED_IN);

                if (isActive) {
                    boolean matchesRoom = res.getRoom().getRoomNumber().equals(this.roomNumber);

                    if (matchesRoom) {
                        boolean overlaps = !night.isBefore(res.getCheckInDate()) && night.isBefore(res.getCheckOutDate());

                        if (overlaps) {
                            return false;
                        }
                    }
                }
            }

            current = current.plusDays(1);
        }

        return true;
    }
}