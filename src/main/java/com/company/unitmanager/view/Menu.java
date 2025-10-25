package com.company.unitmanager.view;

import java.util.Scanner;

public class Menu {
    private static final Scanner onKeyboardPress = new Scanner(System.in).useDelimiter("\n");

    public static int displayMenu(){
        System.out.println("\n===== SISTEMA DE GESTÃO =====");
        System.out.println("""
                CHEMIRIA NEXUS - ESCOLHA UMA OPÇÃO:
                1 - Gerenciar Unidades
                2 - Gerenciar Agendamentos
                0 - Sair
                """);
        return onKeyboardPress.nextInt();

    }

}
