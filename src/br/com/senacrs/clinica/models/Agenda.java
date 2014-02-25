package br.com.senacrs.clinica.models;

public class Agenda {
	
	private String paciente, detalhes, data_inicio;

	public Agenda(){}
	
	public Agenda(String paciente, String detalhes, String data_inicio) {
		this.paciente = paciente;
		this.detalhes = detalhes;
		this.data_inicio = data_inicio;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}
	
	public String toString(){
		return data_inicio + " paciente " + paciente + " - " + detalhes;
	}
}
