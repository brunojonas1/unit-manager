package com.company.unitmanager.service;

import com.company.unitmanager.exception.InvalidDataException;
import com.company.unitmanager.model.Unit;

import java.util.ArrayList;
import java.util.List;

public class UnitService {
    private static final List<Unit> units = new ArrayList<>();
    private static int nextId = 1;

    public static Unit registerUnit(String name, String address) {
        if (name == null || name.trim().isEmpty() || address == null ||address.trim().isEmpty()) {
            throw new InvalidDataException("Nome e cidade não podem ser vazios");
        }
        Unit unit = new Unit(name, address);
        unit.setId(nextId++);
        units.add(unit);
        return unit;
    }

    public static List<Unit> loadRegisteredUnits() {
        return new ArrayList<>(units);
    }

    public static Unit updateUnit(int id, String newName, String newAddress){
        if (newName == null || newName.trim().isEmpty() || newAddress == null ||newAddress.trim().isEmpty()){
            throw new InvalidDataException("Nome e cidade não podem ser vazios");
        }
        for (Unit u: units){
            if (u.getId()==id){
                u.setName(newName.trim());
                u.setAddress(newAddress.trim());
                return u;
            }
        }
        throw new InvalidDataException("Unidade com ID " + id + " não encontrada");
    }

    public static void deleteUnit(int id){
        units.removeIf(u -> u.getId() == id);
    }

}
