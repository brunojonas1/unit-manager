package com.company.unitmanager.view;

import com.company.unitmanager.model.Appointment;
import com.company.unitmanager.service.AppointmentService;
import com.company.unitmanager.utility.InputReader;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class AppointmentView {
    private static final Scanner scanner = InputReader.getScanner();
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

    public static int askUnitId() {
        System.out.print("Digite o código da Unidade/Setor: ");
        return scanner.nextInt();
    }

    public static String askDescription() {
        scanner.nextLine();
        System.out.print("Digite a descrição do compromisso: ");
        return scanner.nextLine();
    }

    public static LocalDate askDate() {
        System.out.println("Digite a data que você deseja marcar: ");
        String input = scanner.next();
        return LocalDate.parse(input, DATE_FORMAT);
    }

    public static LocalTime askTime() {
        System.out.println("Digite o horário que você deseja marcar: ");
        String input = scanner.next();
        return LocalTime.parse(input, TIME_FORMAT);
    }

    public static void showAppointments(List<Appointment> summaries) {
        if (summaries.isEmpty()) {
            System.out.println("Nenhum agendamento encontrado.");
            return;
        }

        System.out.println("\n=== Lista de Agendamentos ===");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        for (Appointment a : summaries) {
            System.out.printf("ID: %d | Unidade: %d | Data: %s | Hora: %s | Descrição: %s%n",
                    a.getId(),
                    a.getUnitId(),
                    a.getDate().format(dateFormatter),
                    a.getTime().format(timeFormatter),
                    a.getDescription());
        }
    }

    public static void showAppointmentByUnit () {
        int id = UnitView.askId();
        List<Appointment> unitAppointments = AppointmentService.listAppointmentsByUnit(id);

            if (unitAppointments.isEmpty()) {
                System.out.println("A unidade não possui nenhum agendamento");
                return;
            }

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            for (Appointment a : unitAppointments) {
                System.out.printf("ID: %d | Unidade: %d | Data: %s | Hora: %s | Descrição: %s%n",
                        a.getId(),
                        a.getUnitId(),
                        a.getDate().format(dateFormatter),
                        a.getTime().format(timeFormatter),
                        a.getDescription());
            }
        }

    public static int askAppointmentId() {
        System.out.print("Digite o ID do agendamento: ");
        return scanner.nextInt();
    }
}
