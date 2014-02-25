package br.com.senacrs.clinica.models;

public class Historico {

	private String paciente, detalhes, data_inicio, data_fim;

	public Historico(){}
	
	public Historico(String paciente, String detalhes, String data_inicio, String data_fim) {
		this.paciente = paciente;
		this.detalhes = detalhes;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
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
	
	public String getData_fim() {
		return data_inicio;
	}

	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}
	
	public String toString(){
		return data_inicio + " as " + data_fim + ", paciente " + paciente + " - " + detalhes;
	}
}
