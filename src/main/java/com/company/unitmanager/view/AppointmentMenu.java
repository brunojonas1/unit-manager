package com.company.unitmanager.view;

import com.company.unitmanager.DTO.AppointmentSummary;
import com.company.unitmanager.controller.AppointmentController;
import com.company.unitmanager.exception.InvalidDataException;
import com.company.unitmanager.model.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class AppointmentMenu {

    private static final Scanner scanner = new Scanner(System.in);

    public static int displayAppointmentMenu() {
        System.out.println("\n===== MENU DE AGENDAMENTOS =====");
        System.out.println("""
                Chemiria Nexus - ESCOLHA UMA OPÇÃO:
                1 - Cadastrar um agendamento
                2 - Listar todos os compromissos
                3 - Listar comprimissos por unidade
                0 - Voltar
                """);
        return scanner.nextInt();
    }

    public static void  display() {
        int option = displayAppointmentMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    try {
                        int unitId = AppointmentView.askUnitId();
                        LocalDate date = AppointmentView.askDate();
                        LocalTime time = AppointmentView.askTime();
                        String description = AppointmentView.askDescription();
                        Appointment appointment = AppointmentController.registerAppointment(unitId, date, time, description);
                    System.out.println("Agendamento cadastrado para a unidade ID: " + appointment.getUnitId());
                    } catch (InvalidDataException e) {
                        System.out.println("Erro de validação " + e.getMessage());
                    }
                    break;
                case 2:
                    List<AppointmentSummary> summaries = AppointmentSummary.listAppointmentsWithUnitName();
                    AppointmentView.showAppointmentByUnit();
                    break;
                case 3:
                    int unitId = AppointmentView.askUnitId();
                    List<Appointment> appointmentsList = AppointmentController.listAppointmentsByUnit(unitId);
                    AppointmentView.showAppointments(appointmentsList);
                    break;
                case 4:
                    int id = AppointmentView.askAppointmentId();
                    AppointmentController.deleteAppointment(id);
                    System.out.println("Agendamento removido com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            option = displayAppointmentMenu();
        }
        System.out.println("Voltando ao menu principal");
    }
}
