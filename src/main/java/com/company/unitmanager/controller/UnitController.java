package com.company.unitmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.company.unitmanager.exception.InvalidDataException;
import com.company.unitmanager.model.Unit;

public class UnitController {
    private static final List<Unit> units = new ArrayList<>();
    private static Long nextId = 1L;

    public static Unit registerUnit(String name, String city){
        if (name == null || name.trim().isEmpty() || city == null ||city.trim().isEmpty()) {
            throw new InvalidDataException("Nome e cidade não podem ser vazios");
        }
        Unit unit = new Unit(name, city);
        unit.setId(nextId++);
        units.add(unit);
        return unit;
    }

    public static List<Unit> loadRegisteredUnits() {
        return units;
    }

    public static Unit updateUnit(int id, String newName, String newcity){
        if (newName == null || newName.trim().isEmpty() || newcity == null ||newcity.trim().isEmpty()){
            throw new InvalidDataException("Nome e cidade não podem ser vazios");
        }

        for (Unit u: units){
            if (u.getId()==id){
                u.setName(newName.trim());
                u.setAddress(newcity.trim());
                return u;
            }
        }
        throw new InvalidDataException("Unidade com ID" + id + " não encontrada");
    }

    public static void deleteUnit(int id){
        for (Unit u : units) {
            if (u.getId() == id) {
                units.remove(u);
                return;
            }
        }
    }


}
