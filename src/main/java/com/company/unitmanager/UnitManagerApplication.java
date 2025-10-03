package com.company.unitmanager;

import com.company.unitmanager.controller.UnitController;
import com.company.unitmanager.exception.InvalidDataException;
import com.company.unitmanager.exception.UnitNotFoundException;
import com.company.unitmanager.model.Unit;
import com.company.unitmanager.view.Menu;
import com.company.unitmanager.view.UnitView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UnitManagerApplication {

	public static void main(String[] args) {

		int option = Menu.displayMenu();
		while (option != 0) {
			switch (option) {
				case 1:
					try{
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
					} catch (UnitNotFoundException e){
						System.out.printf("Erro " + e.getMessage());
					}
					break;
				default:
					System.out.println("Opção inválida");
			}
			option = Menu.displayMenu();
		}
		System.out.println("Você está saindo do aplicativo");
	}
}
