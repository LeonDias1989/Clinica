package br.com.senacrs.clinica.models;

public class Medicamento {
	
	private int id;
	private String nome;
	
	public Medicamento(){
		this(-1,null);
	}
	
	public Medicamento(int id){
		this(id,null);
	}
	
	public Medicamento(int id, String nome) {
		this.id = id;
		this.nome = nome;
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
	
	public String toString(){
		return nome;
	}
}
