package br.com.senacrs.clinica.actions;

import java.util.Scanner;

import br.com.senacrs.clinica.library.ActionMenu;
import br.com.senacrs.clinica.library.ActionController;

public class PacientesActions extends ActionController implements ActionMenu {

	public PacientesActions(Scanner sc) {
		super(sc);
		out.println("-- Pacientes --");
	}

	@Override
	public void menu() {
		
		
	}
}