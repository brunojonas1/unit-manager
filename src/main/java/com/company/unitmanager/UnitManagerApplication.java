package com.company.unitmanager;

import com.company.unitmanager.controller.AppointmentController;
import com.company.unitmanager.controller.UnitController;
import com.company.unitmanager.exception.InvalidDataException;
import com.company.unitmanager.exception.UnitNotFoundException;
import com.company.unitmanager.model.Appointment;
import com.company.unitmanager.model.Unit;
import com.company.unitmanager.view.AppointmentMenu;
import com.company.unitmanager.view.Menu;
import com.company.unitmanager.view.UnitMenu;
import com.company.unitmanager.view.UnitView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
public class UnitManagerApplication {

    public static void main(String[] args) {

        int option = Menu.displayMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    UnitMenu.display();
                    break;
                case 2:
                    AppointmentMenu.display();
                    break;
                default:
                    System.out.println("Opção Invalida");
            }
            option = Menu.displayMenu();
            System.out.println("Você está saindo do aplicativo");
        }
    }
}
