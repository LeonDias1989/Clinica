package br.com.senacrs.clinica.actions;

import java.util.Scanner;

import br.com.senacrs.clinica.library.ActionMenu;
import br.com.senacrs.clinica.library.ActionController;

public class MainAction extends ActionController implements ActionMenu {

	public MainAction(Scanner sc) {
		super(sc);
		out.println("-- Bem Vindo --");
	}

	@Override
	public void menu() {
		out.println();
		out.println("Digite o numero de uma das opcoes abaixo para continuar:");
		out.println("[1] Agenda");
		out.println("[2] Historico");
		out.println("[3] Consultas");
		out.println("[4] Pacientes");
		out.println("[5] Medicamentos");
		out.println("[0] Sair");
		
		switch(sc.nextInt()){
			case 1: new AgendaAction(sc).menu(); break;
			case 2: new HistoricoActions(sc).menu(); break;
			case 3: new ConsultasAction(sc).menu(); break;
			case 4: new PacientesActions(sc).menu(); break;
			case 5: new MedicamentosAction(sc).menu(); break;
			case 0: return;
			default: out.println("Opcao invalida"); break;
		}
		menu();
	}
}
