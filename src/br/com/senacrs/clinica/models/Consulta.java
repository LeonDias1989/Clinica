package br.com.senacrs.clinica.models;

import java.util.List;

public class Consulta {
	
	public int id;
	public String descricao, data_inicio, data_fim;
	public Paciente paciente;
	public List<Medicamento> medicamentos;
	
	public Consulta(){}
	
	public Consulta(int id, String descricao, String data_inicio, String data_fim, Paciente paciente, List<Medicamento> medicamentos) {
		this.id = id;
		this.descricao = descricao;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.paciente = paciente;
		this.medicamentos = medicamentos;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public String getData_fim() {
		return data_fim;
	}

	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public String toString(){
		String text = "Consulta de " + getPaciente() + " as " + getData_inicio();
		
		if(getData_fim() != null)
			text += " ate " + getData_fim();
		
		if(medicamentos != null){
			int size = medicamentos.size();
			if(size > 0){
				if(size == 1){
					text += " com o medicamento: " + medicamentos.get(0);
				} else {
					text += " com os medicamentos: " + medicamentos.get(0);
					for (int i = 1; i < size; i++)
						text += ", " + medicamentos.get(i);
				}
			}
		}
		
		return text;
	}
	
	
}
