package br.com.senacrs.clinica.actions;

import java.util.Scanner;

import br.com.senacrs.clinica.library.ActionMenu;
import br.com.senacrs.clinica.library.ActionController;

public class AgendaAction extends ActionController implements ActionMenu {

	public AgendaAction(Scanner sc) {
		super(sc);
		out.println("-- Agenda --");
	}

	@Override
	public void menu() {
		
		
	}
}