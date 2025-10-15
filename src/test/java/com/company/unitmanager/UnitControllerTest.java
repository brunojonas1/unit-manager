package com.company.unitmanager;

import com.company.unitmanager.controller.UnitController;
import com.company.unitmanager.exception.InvalidDataException;
import com.company.unitmanager.model.Unit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UnitControllerTest {

    @Test
    public void testRegisterUnitShouldCreateUnit() {
        Unit unit = UnitController.registerUnit("Central", "Florianópolis");
        assertNotNull(unit.getId());
        assertEquals("Central", unit.getName());
        assertEquals("Florianópolis", unit.getAddress());
    }

    @Test
    public void testUpdateUnitShouldChange() {
        // Primeiro deverá criar uma unidade
        Unit unit = UnitController.registerUnit("Nome 1","Cidade 1");
        // Agora realizar o update
        Unit updateUnit = UnitController.updateUnit(unit.getId(), "Nome Alterado", "Cidade Alterada");
        // Verificar se os dados foram alterados
        assertEquals("Nome Alterado", updateUnit.getName());
        assertEquals("Cidade Alterada", updateUnit.getAddress());
    }

    @Test
    public void testUpdateUnitShouldThrowExceptionWhenIdNotExist() {
        int invalidId = 999;

        assertThrows(InvalidDataException.class, () -> {
            UnitController.updateUnit(invalidId, "Nome Alterado", "Cidade Alterada");
        });
    }




}
