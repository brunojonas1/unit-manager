package com.company.unitmanager.utility;

import java.util.Scanner;

public class InputReader {
    private static final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public static Scanner getScanner(){
        return scanner;
    }
}
