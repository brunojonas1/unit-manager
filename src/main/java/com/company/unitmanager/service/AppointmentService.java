package com.company.unitmanager.service;

import com.company.unitmanager.exception.InvalidDataException;
import com.company.unitmanager.model.Appointment;
import com.company.unitmanager.repository.AppointmentRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private static final List<Appointment> appointments = new ArrayList<>();
    private static int nextId = 1;

    static {
        List<Appointment> loaded = AppointmentRepository.loadAppointments();
        if (loaded != null) {
            appointments.addAll(loaded);
            nextId = appointments.stream()
                    .mapToInt(Appointment::getId)
                    .max()
                    .orElse(0) + 1;
            System.out.printf("Appointment carregados. Próximo ID: " + nextId);
        } else {
            System.out.printf("Nenhum appointment encontrado.");
        }
    }
    // Essa função evita modificações diretas
    public static List<Appointment> getAppointments() {
        return new ArrayList<>(appointments);
    }

    public static Appointment registerAppointment(int unitId, LocalDate date, LocalTime time, String description) {
        if (UnitService.findUnitById(unitId) == null) {
            throw new InvalidDataException("A unidade com id" + unitId + "não foi encontrada.");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new InvalidDataException("A descrição não pode ser vazia.");
        }
        Appointment appointment = new Appointment(nextId++, unitId, date, time, description);
        appointments.add(appointment);
        AppointmentRepository.saveAppointments(appointments);
        return appointment;
    }

    public static List<Appointment> listAllAppointments() {
        return appointments;
    }

    public static List<Appointment> listAppointmentsByUnit(int unitId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getUnitId() == unitId) {
                result.add(a);
            }
        }
        return result;
    }

    public static void deleteAppointment(int id) {
        appointments.removeIf(a -> a.getId() == id);
        AppointmentRepository.saveAppointments(appointments);
    }

}
