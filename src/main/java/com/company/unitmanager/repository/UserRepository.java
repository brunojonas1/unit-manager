package com.company.unitmanager.repository;

import com.company.unitmanager.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final String FILE_PATH = "data/user.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveUsers(List<User> users) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            System.out.printf("Erro ao salvar usuário: " + e.getMessage());
        }
    }


}
