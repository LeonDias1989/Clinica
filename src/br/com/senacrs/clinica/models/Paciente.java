package br.com.senacrs.clinica.models;

public class Paciente {

	private int id;
	private String nome, cpf, telefone;
	
	public Paciente(){
		this(-1,null,null,null);
	}
	
	public Paciente(int id){
		this(id,null,null,null);
	}
	
	public Paciente(int id, String nome, String cpf, String telefone) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String toString(){
		return this.nome;
	}
}
