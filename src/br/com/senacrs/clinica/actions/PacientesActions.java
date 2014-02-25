package br.com.senacrs.clinica.actions;

import java.util.List;
import java.util.Scanner;

import br.com.senacrs.clinica.dao.PacientesDao;
import br.com.senacrs.clinica.library.ActionMenu;
import br.com.senacrs.clinica.library.ActionController;
import br.com.senacrs.clinica.models.Paciente;

public class PacientesActions extends ActionController implements ActionMenu {

	public PacientesActions(Scanner sc) {
		super(sc);
		out.println("-- Pacientes --");
	}

	@Override
	public void menu() {
		out.println();
		out.println("[1] Cadastrar");
		out.println("[2] Listar");
		out.println("[0] Sair");

		switch(sc.nextInt()){
		case 1: cadastraPaciente(); break;
		case 2: mostraPacienteLista(); break;	
		case 0: return;
		default: out.println("Opcao invalida"); break;
		}
		menu();
	}

	private void mostraPacienteLista(){
		out.println("-- Lista de Pacientes --");
		out.println();
		List<Paciente> pacientes = PacientesDao.getPacientesList();

		if(pacientes.size() > 0){
			for(Paciente paciente : pacientes){
				out.println("ID: " + paciente.getId() +
							" Nome: " + paciente.getNome()+
							" CPF: " + paciente.getCpf()+
							" Telefone: " + paciente.getTelefone()
						);
			}
		} else {
			out.println("Sem pacientes cadastrados.");
		}
		out.println();
		pause();


	}

	private void cadastraPaciente(){


	}
}