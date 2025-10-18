package com.company.unitmanager.repository;

import com.company.unitmanager.model.Appointment;
import com.company.unitmanager.model.Unit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {
    private static final String FILE_PATH = "data/appointment.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveAppointments(List<Appointment> appointments) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(appointments, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar agendamentos: " + e.getMessage());
        }
    }

    public static List<Appointment> loadAppointments() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, new TypeToken<List<Appointment>>() {
            }.getType());
        } catch (IOException e) {
            System.out.println("Nenhum arquivo de agendamentos encontrado.");
            return new ArrayList<>();
        }
    }



}
