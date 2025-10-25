package com.company.unitmanager.view;

import com.company.unitmanager.controller.UnitController;
import com.company.unitmanager.exception.InvalidDataException;
import com.company.unitmanager.exception.UnitNotFoundException;
import com.company.unitmanager.model.Unit;

import java.util.List;
import java.util.Scanner;

public class UnitMenu {

    private static final Scanner scanner = new Scanner(System.in);

    public static int displayUnitMenu() {
        System.out.println("\n===== MENU DE UNIDADES =====");
        System.out.println("""
                Chemiria Nexus - ESCOLHA UMA OPÇÃO:
                1 - Cadastrar uma unidade/setor
                2 - Listar unidades/setor
                3 - Atualizar unidade/setor
                4 - Excluir unidade/setor
                0 - Voltar
                """);

        return scanner.nextInt();
    }

    public static void  display() {
        int option = displayUnitMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    try {
                        String name = UnitView.askName();
                        String city = UnitView.askCity();
                        Unit unit = UnitController.registerUnit(name, city);
                        System.out.println("Unidade cadastrada com sucesso " + unit.getName());
                    } catch (InvalidDataException e) {
                        System.out.println("Erro de validação " + e.getMessage());
                    }
                    break;
                case 2:
                    List<Unit> units = UnitController.loadRegisteredUnits();
                    UnitView.showUnits(units);
                    break;
                case 3:
                    try {
                        int id = UnitView.askId();
                        System.out.println("Informe o novo nome: ");
                        String newName = UnitView.askName();
                        System.out.println("Informe a nova cidade: ");
                        String newCity = UnitView.askCity();

                        Unit upated = UnitController.updateUnit(id, newName, newCity);
                        System.out.println("Unidade atualizada " + upated.getName());
                    } catch (InvalidDataException | UnitNotFoundException e) {
                        System.out.println("Erro " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        int id = UnitView.askId();
                        UnitController.deleteUnit(id);
                        System.out.println("Unidade removida");
                    } catch (UnitNotFoundException e) {
                        System.out.printf("Erro " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            option = displayUnitMenu();
        }
        System.out.println("Voltando ao menu principal");
    }
}
