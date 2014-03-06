package br.com.senacrs.clinica.actions;

import java.util.List;
import java.util.Scanner;

import br.com.senacrs.clinica.dao.HistoricoDao;
import br.com.senacrs.clinica.library.ActionController;
import br.com.senacrs.clinica.library.ActionMenu;
import br.com.senacrs.clinica.models.Historico;

public class HistoricoActions extends ActionController implements ActionMenu {

	public HistoricoActions(Scanner sc) {
		super(sc);
		out.println("-- Historico --");
	}

	@Override
	public void menu() {
		listarHistorico();
	}
	
	private void listarHistorico() {
		out.println();
		
		List<Historico> historico = HistoricoDao.getHistoricoList();
		if(historico.size() > 0){
			for(Historico h : historico)
				out.println(h);
		} else {
			out.println("Nenhun registro encontrado");
		}
		
		out.println();
		pause();
	}
}