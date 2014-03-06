package br.com.senacrs.clinica.actions;

import java.util.List;
import java.util.Scanner;

import br.com.senacrs.clinica.dao.AgendaDao;
import br.com.senacrs.clinica.library.ActionMenu;
import br.com.senacrs.clinica.library.ActionController;
import br.com.senacrs.clinica.models.Agenda;

public class AgendaAction extends ActionController implements ActionMenu {

	public AgendaAction(Scanner sc) {
		super(sc);
		out.println("-- Agenda --");
	}

	@Override
	public void menu() {
		listarAgenda();
	}
	
	private void listarAgenda() {
		out.println();
		
		List<Agenda> agenda = AgendaDao.getAgendaList();
		if(agenda.size() > 0){
			for(Agenda a : agenda)
				out.println(a);
		} else {
			out.println("Nenhun registro encontrado");
		}
		
		out.println();
		pause();
	}
}