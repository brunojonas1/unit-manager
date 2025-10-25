package com.company.unitmanager.controller;

import com.company.unitmanager.DTO.AppointmentSummary;
import com.company.unitmanager.model.Appointment;
import com.company.unitmanager.service.AppointmentService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AppointmentController {

    public static Appointment registerAppointment(int unitId, LocalDate date, LocalTime time, String description) {
        return AppointmentService.registerAppointment(unitId, date, time, description);
    }

    public static List<Appointment> listAllAppointments() {
        return AppointmentService.listAllAppointments();
    }

    public static List<Appointment> listAppointmentsByUnit(int unitId) {
        return AppointmentService.listAppointmentsByUnit(unitId);
    }

    public static void deleteAppointment(int id) {
        AppointmentService.deleteAppointment(id);
    }

    //Rever função
    public static List<AppointmentSummary> listAllAppointmentsWithUnitName() {
        return AppointmentSummary.listAppointmentsWithUnitName();
    }

    public static void handleListAppointments() {
        List<AppointmentSummary> summaries = listAllAppointmentsWithUnitName();
        if (summaries.isEmpty()) {
            System.out.println("Nenhum agendamento programado");
        }
        summaries.forEach(s -> System.out.printf("[%d] %s - %s (%s às %s)%n",
                s.getId(),
                s.getDescription(),
                s.getUnitName(),
                s.getDate(),
                s.getTime()));
    }

}
