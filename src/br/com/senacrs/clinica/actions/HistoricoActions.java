package br.com.senacrs.clinica.actions;

import java.util.Scanner;

import br.com.senacrs.clinica.library.ActionMenu;
import br.com.senacrs.clinica.library.ActionController;

public class HistoricoActions extends ActionController implements ActionMenu {

	public HistoricoActions(Scanner sc) {
		super(sc);
		out.println("-- Historico --");
	}

	@Override
	public void menu() {
		
		
	}
}