package main.java.edu.metrostate.oodi.hotel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class RoomType {

    private final String name;
    private int weekdayRate;
    private int weekendRate;
    private final int maximumGuests;
    private final int minimumNights;

    public RoomType(String name, int weekdayRate, int weekendRate, int maximumGuests, int minimumNights) {
        this.name = name;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.maximumGuests = maximumGuests;
        this.minimumNights = minimumNights;
    }

    public String getName() {
        return name;
    }
    public int getWeekdayRate() {
        return weekdayRate;
    }
    public int getWeekendRate() {
        return weekendRate;
    }
    public int getMaximumGuests() {
        return maximumGuests;
    }
    public int getMinimumNights() {
        return minimumNights;
    }

    public void setRates(int weekdayRate, int weekendRate) {
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }

    public int getRateForDate(LocalDate date) {
        DayOfWeek dow = date.getDayOfWeek();
        List<DayOfWeek> weekendDays = Arrays.asList(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);

        boolean isWeekend = weekendDays.stream().anyMatch(d -> d.ordinal() == dow.ordinal());

        if (isWeekend == true) {
            return weekendRate;
        } else {
            return weekdayRate;
        }
    }

    public boolean allowsStayLength(int nights) {
        int diff = nights - minimumNights;
        return diff >= 0;
    }
}