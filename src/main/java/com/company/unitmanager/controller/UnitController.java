package com.company.unitmanager.controller;

import com.company.unitmanager.model.Unit;
import com.company.unitmanager.service.UnitService;

import java.util.List;

public class UnitController {

    public static Unit registerUnit(String name, String address){
        return UnitService.registerUnit(name, address);
    }

    public static List<Unit> loadRegisteredUnits() {
        return UnitService.loadRegisteredUnits();
    }

    public static Unit updateUnit(int id, String newName, String newAddress){
        return UnitService.updateUnit(id, newName, newAddress);
    }

    public static void deleteUnit(int id){
        UnitService.deleteUnit(id);
    }

}
