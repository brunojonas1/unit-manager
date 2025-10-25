package com.company.unitmanager.DTO;

import com.company.unitmanager.model.Appointment;
import com.company.unitmanager.model.Unit;
import com.company.unitmanager.service.AppointmentService;
import com.company.unitmanager.service.UnitService;

import java.util.ArrayList;
import java.util.List;

public class AppointmentSummary {
    private Appointment appointment;
    private String unitName;

    public AppointmentSummary(Appointment appointment, String unitName) {
        this.appointment = appointment;
        this.unitName = unitName;
    }

    // Getters
    public Appointment getAppointment() {
        return appointment;
    }

    public String getUnitName() {
        return unitName;
    }

    public int getId() {
        return appointment.getId();
    }

    public int getUnitId() {
        return appointment.getUnitId();
    }

    public String getDescription() {
        return appointment.getDescription();
    }

    public java.time.LocalDate getDate() {
        return appointment.getDate();
    }

    public java.time.LocalTime getTime() {
        return appointment.getTime();
    }

    // Função para Sumário
    public static List<AppointmentSummary> listAppointmentsWithUnitName() {
        List<AppointmentSummary> summaries = new ArrayList<>();

        for (Appointment a : AppointmentService.getAppointments()) {
            Unit u = UnitService.findUnitById(a.getUnitId());
            String unitName = (u != null) ? u.getName() : "Unidade desconhecida";

            summaries.add(new AppointmentSummary(a, unitName));
        }
        return summaries;
    }


}
