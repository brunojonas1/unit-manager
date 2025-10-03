package com.company.unitmanager.view;

import com.company.unitmanager.model.Unit;
import com.company.unitmanager.utility.InputReader;

import java.util.List;
import java.util.Scanner;

public class UnitView {
    private static final Scanner scanner = InputReader.getScanner();

    public static String askName() {
        System.out.print("Digite o nome da unidade/setor: ");
        return scanner.next();
    }

    public static String askCity() {
        System.out.print("Digite a cidade da unidade/setor: ");
        return scanner.next();
    }

    public static int askId() {
        System.out.println("Digite o id da unidade/setor: ");
        return scanner.nextInt();
    }

    public static void showUnits(List<Unit> units) {
        if (units.isEmpty()) {
            System.out.println("Nenhuma unidade cadastrada.");
        } else {
            System.out.println("Unidades cadastradas:");
            for (Unit u : units) {
                System.out.println("[" + u.getId() + "] " + u.getName() + " - " + u.getAddress());
            }
        }
    }


}
