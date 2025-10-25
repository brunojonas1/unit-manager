package com.company.unitmanager.repository;

import com.company.unitmanager.model.Appointment;
import com.company.unitmanager.utility.GsonAdapters;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {
    private static final String FILE_PATH = "data/appointment.json";
    private static final Gson gson = GsonAdapters.buildGson();

    public static void saveAppointments(List<Appointment> appointments) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(appointments, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Appointment> loadAppointments() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, new TypeToken<List<Appointment>>() {}.getType());
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
