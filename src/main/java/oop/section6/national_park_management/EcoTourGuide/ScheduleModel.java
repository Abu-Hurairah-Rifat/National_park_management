package oop.section6.national_park_management.EcoTourGuide;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ScheduleModel {

    public enum DayStatus {
        AVAILABLE,
        BOOKED,
        BLOCKED
    }

    private final Map<LocalDate, DayStatus> scheduleData = new HashMap<>();
    private String weeklyStartTime;
    private String weeklyEndTime;

    public void setDateStatus(LocalDate start, LocalDate end, DayStatus status) {
        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            if (status == DayStatus.AVAILABLE) {
                scheduleData.remove(date);
            } else {
                scheduleData.put(date, status);
            }
        }
    }

    public void setWeeklyHours(String start, String end) {
        this.weeklyStartTime = start;
        this.weeklyEndTime = end;
    }

    public DayStatus getStatusForDate(LocalDate date) {
        return scheduleData.getOrDefault(date, DayStatus.AVAILABLE);
    }

    // Getters to retrieve the saved hours
    public String getWeeklyStartTime() {
        return weeklyStartTime;
    }

    public String getWeeklyEndTime() {
        return weeklyEndTime;
    }
}