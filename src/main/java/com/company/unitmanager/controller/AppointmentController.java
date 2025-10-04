package com.company.unitmanager.controller;

import com.company.unitmanager.model.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentController {
    private List<Appointment> appointments = new ArrayList<>();

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public List<Appointment> listAppointmentByUnit(int unitId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments){
            if (a.getUnitId() == unitId) {
                result.add(a);
            }
        }
        return result;
    }

    public void removeAppointment(int index) {
        if (index >= 0 && index < appointments.size()) {
            appointments.remove(index);
        }
    }

    public List<Appointment> listAllAppointments() {
        return appointments;
    }

}
