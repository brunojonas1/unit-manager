package com.company.unitmanager.utility;

import com.google.gson.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GsonAdapters {
        private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        public static Gson buildGson() {
            return new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, (JsonSerializer<LocalDate>) (src, typeOfSrc, context) ->
                            new JsonPrimitive(src.format(dateFormatter)))
                    .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, typeOfT, context) ->
                            LocalDate.parse(json.getAsString(), dateFormatter))
                    .registerTypeAdapter(LocalTime.class, (JsonSerializer<LocalTime>) (src, typeOfSrc, context) ->
                            new JsonPrimitive(src.format(timeFormatter)))
                    .registerTypeAdapter(LocalTime.class, (JsonDeserializer<LocalTime>) (json, typeOfT, context) ->
                            LocalTime.parse(json.getAsString(), timeFormatter))
                    .setPrettyPrinting()
                    .create();
        }
}

