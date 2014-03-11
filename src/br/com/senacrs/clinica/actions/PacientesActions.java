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
		out.println("[1] Buscar");
		out.println("[2] Cadastrar");
		out.println("[3] Listar Todos");
		out.println("[0] Sair");

		switch(sc.nextInt()){
			case 1: buscarPacientes(); break;
			case 2: cadastraPaciente(); break;
			case 3: mostraPacienteLista(); break;	
			case 0: return;
			default: out.println("Opcao invalida"); break;
		}
		menu();
	}

	private void buscarPacientes(){
		out.println("-- Procurar Pacientes --");
		out.println();
		
		String buscar="";
		out.println("Digite o Paciente que voce deseja buscar: ");
		buscar = sc.next();
		
		List<Paciente> pacientes = PacientesDao.getPacientesFromSearch(buscar);
		
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
		out.println("-- Cadastrar Pacientes --");
		out.println();
		
		String cadastro;
		Paciente cadastraPaciente = new Paciente();
		out.println("Digite o Nome do Paciente: ");
		cadastro = sc.next();
		cadastraPaciente.setNome(cadastro);
		out.println("Digite o CPF do Paciente");
		cadastro = sc.next();
		cadastraPaciente.setCpf(cadastro);
		out.println("Digite o Telefone do Paciente:");
		cadastro = sc.next();
		cadastraPaciente.setTelefone(cadastro);
		
		out.println();
		pause();
	}
}