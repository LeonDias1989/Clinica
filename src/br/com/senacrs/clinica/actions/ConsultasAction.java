package br.com.senacrs.clinica.actions;

import java.util.Scanner;

import br.com.senacrs.clinica.dao.ConsultasDao;
import br.com.senacrs.clinica.library.ActionController;
import br.com.senacrs.clinica.library.ActionMenu;
import br.com.senacrs.clinica.models.Consulta;

public class ConsultasAction extends ActionController implements ActionMenu {

	public ConsultasAction(Scanner sc) {
		super(sc);
		out.println("-- Consultas --");
	}

	@Override
	public void menu() {
		
		
		/*
		List<Medicamento> medicamentos = new ArrayList<Medicamento>();
		medicamentos.add(new Medicamento(1,null));
		medicamentos.add(new Medicamento(2,null));
		
		Consulta consulta = new Consulta(0, "Teste de cadastro", "2014-03-24 16:30:00", null, new Paciente(2,null,null,null), medicamentos);
		ConsultasDao.setConsulta(consulta);
		*/
		
		for(Consulta consulta : ConsultasDao.getConsultasList()){
			out.println(consulta);
		}
		
		
		
		pause();
		
	}
}