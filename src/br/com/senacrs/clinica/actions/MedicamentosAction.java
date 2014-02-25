package br.com.senacrs.clinica.actions;

import java.util.Scanner;

import br.com.senacrs.clinica.dao.MedicamentosDao;
import br.com.senacrs.clinica.library.ActionMenu;
import br.com.senacrs.clinica.library.ActionController;

public class MedicamentosAction extends ActionController implements ActionMenu {

	public MedicamentosAction(Scanner sc) {
		super(sc);
		out.println("-- Medicamentos --");
	}

	@Override
	public void menu() {
		
		System.out.println(MedicamentosDao.getMedicamentosList());
		
	}
}