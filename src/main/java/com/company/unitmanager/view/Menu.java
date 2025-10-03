package com.company.unitmanager.view;

import java.util.Scanner;

public class Menu {
    private static final Scanner onKeyboardPress = new Scanner(System.in).useDelimiter("\n");

    public static int displayMenu(){
        System.out.println("""
                UNITRA - ESCOLHA UMA OPÇÃO:
                1 - Cadastrar uma unidade/setor
                2 - Listar unidades/setor
                3 - Atualizar unidade/setor
                4 - Excluir unidade/setor
                0 - Sair
                """);
        return onKeyboardPress.nextInt();
    }
}
