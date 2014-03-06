package br.com.senacrs.clinica.actions;

import java.util.List;
import java.util.Scanner;

import br.com.senacrs.clinica.dao.MedicamentosDao;
import br.com.senacrs.clinica.library.ActionMenu;
import br.com.senacrs.clinica.library.ActionController;
import br.com.senacrs.clinica.models.Medicamento;

public class MedicamentosAction extends ActionController implements ActionMenu {

	public MedicamentosAction(Scanner sc) {
		super(sc);
		out.println("-- Medicamentos --");
	}

	@Override
	public void menu() {
		out.println();
		out.println("[1] Buscar");
		out.println("[2] Cadastrar");
		out.println("[3] Listar Todos");
		out.println("[0] Sair");

		switch(sc.nextInt()){
			case 1: buscarMedicamento(); break;
			case 2: cadastraMedicamento(); break;
			case 3: listarMedicamentos(); break;	
			case 0: return;
			default: out.println("Opcao invalida"); break;
		}
		menu();
	}

	private void buscarMedicamento(){
		out.println("-- Buscar Medicamento --");
		out.println();
		
		out.println("Digite o nome do medicamento:");
		String term = sc.next();
		
		out.println();
		List<Medicamento> lista = MedicamentosDao.getMedicamentoFromSearch(term);
		int size = lista.size();
		
		if(size > 0){
			out.println("Resultados encotrados: " + size);
			for(Medicamento medicamentos : lista)
				out.println(medicamentos.getId() + " | " + medicamentos);
		} else {
			out.println("Nenhum resultado encontrado");
		}
		
		out.println();
		pause();
	}

	private void cadastraMedicamento(){
		out.println("-- Cadastrar Medicamento --");
		out.println();
		
		Medicamento medicamento = new Medicamento();
		
		try {
			out.println("Digite o nome do medicamento:");
			medicamento.setNome(sc.next());
			
			if(MedicamentosDao.setMedicamento(medicamento)){
				out.println("Medicamento cadastrado com sucesso");
			} else {
				out.println("Falha ao tentar inserir no banco de dados");
			}
		} catch(Exception e){
			e.printStackTrace();
			out.println("Ocorreu um problema por favor tente novamente");
		}
		
		out.println();
		pause();
	}

	private void listarMedicamentos(){
		out.println("-- Lista de Medicamentos --");
		out.println();
		
		List<Medicamento> lista = MedicamentosDao.getMedicamentosList();
		if(lista.size() > 0){
			for(Medicamento medicamentos : lista)
				out.println(medicamentos.getId() + " | " + medicamentos);
		} else {
			out.println("Nenhum resultado encontrado");
		}
		
		out.println();
		pause();
	}
}