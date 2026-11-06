package main.java.edu.metrostate.oodi.hotel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class Reservation {

    private final String confirmationNumber;
    private final Guest guest;
    private final Room room;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;
    private final Map<LocalDate, Integer> rateBookedForEachNight;
    private ReservationStatus status;
    private Stay stay;
    private Bill bill;

    public Reservation(String confirmationNumber, Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests, LocalDate madeOn) {
        this.confirmationNumber = confirmationNumber;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.rateBookedForEachNight = new LinkedHashMap<>();
        this.status = ReservationStatus.CONFIRMED;

        recordRates();
    }

    private void recordRates() {
        LocalDate current = checkInDate;
        RoomType rt = room.getRoomType();

        while (current.isBefore(checkOutDate)) {
            int calculatedRate = rt.getRateForDate(current);
            rateBookedForEachNight.put(current, calculatedRate);

            current = current.plusDays(1);
        }
    }

    public int calculateTotal() {
        int accumulator = 0;

        for (Map.Entry<LocalDate, Integer> entry : rateBookedForEachNight.entrySet()) {
            accumulator += entry.getValue();
        }

        return accumulator;
    }

    public void cancel() {
        if (status != ReservationStatus.CONFIRMED) {
            throw new IllegalStateException("Reservation cannot be cancelled. Current status: " + status);
        }

        this.status = ReservationStatus.CANCELLED;
    }

    public void checkIn(LocalDateTime time, LocalDate today) {
        if (status != ReservationStatus.CONFIRMED) {
            throw new IllegalStateException("Reservation is not confirmed. Status: " + status);
        }

        if (!checkInDate.equals(today)) {
            throw new IllegalStateException("Check-in date is not today. Check-in date: " + checkInDate + ", Today: " + today);
        }

        this.status = ReservationStatus.CHECKED_IN;
        this.stay = new Stay(time);
    }

    public Bill complete(LocalDateTime time, LocalDate issueDate, String billNumber) {
        if (status != ReservationStatus.CHECKED_IN) {
            throw new IllegalStateException("Reservation is not checked in.");
        }

        this.status = ReservationStatus.COMPLETED;

        if (this.stay != null) {
            this.stay.setEndedAt(time);
        }

        this.bill = new Bill(billNumber, issueDate, calculateTotal());

        return this.bill;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public Map<LocalDate, Integer> getRateBookedForEachNight() {
        return rateBookedForEachNight;
    }

    public Stay getStay() {
        return stay;
    }

    public Bill getBill() {
        return bill;
    }
}
