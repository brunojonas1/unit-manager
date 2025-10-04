package com.company.unitmanager.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int unitId;
    private LocalDate date;
    private LocalTime time;
    private String description;

    public Appointment(int unitId, LocalDate date, LocalTime time, String description) {
        this.unitId = unitId;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public int getUnitId() {
        return unitId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
