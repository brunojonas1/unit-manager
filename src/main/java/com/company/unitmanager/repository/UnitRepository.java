package com.company.unitmanager.repository;

import com.company.unitmanager.model.Unit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UnitRepository {

    private static final String FILE_PATH = "data/units.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Salva todas as unidades no arquivo
    public static void saveUnits(List<Unit> units) {
        try {
            File file = new File(FILE_PATH);
            File parentDir = file.getParentFile();

            // Cria a pasta "data" se ela não existir
            if (parentDir != null && !parentDir.exists()) {
                if (parentDir.mkdirs()) {
                    System.out.println("Diretório 'data' criado com sucesso!");
                } else {
                    System.err.println("Falha ao criar diretório 'data'.");
                }
            }
            try (Writer writer = new FileWriter(FILE_PATH)) {
                gson.toJson(units, writer);
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar unidades " + FILE_PATH + ": " + e.getMessage());
        }
    }

    // Carrega todas as unidades
    public static List<Unit> loadUnits() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, new TypeToken<List<Unit>>() {
            }.getType());
        } catch (IOException e) {
            System.out.println("Nenhum arquivo encontrado, iniciando lista vazia...");
            return new ArrayList<>();
        }
    }

}
