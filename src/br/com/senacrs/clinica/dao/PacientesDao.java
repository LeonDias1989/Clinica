package br.com.senacrs.clinica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.senacrs.clinica.library.DatabaseConnection;
import br.com.senacrs.clinica.models.Paciente;

public class PacientesDao extends DatabaseConnection {

	/**
	 * Retorna lista com todos os pacientes
	 * @return List<Paciente>
	 */
	public static List<Paciente> getPacientesList() {
		Connection connect = connect();
		List<Paciente> lista = new ArrayList<Paciente>();
		if(connect != null){
			try {
				Statement statement = connect.createStatement();
				ResultSet result = statement.executeQuery("select id, nome, cpf, telefone from pacientes order by nome asc");
				while(result.next()){
					lista.add(new Paciente(
						result.getInt("id"),
						result.getString("nome"),
						result.getString("cpf"),
						result.getString("telefone")
					));
				}
				result.close();
			} catch(Exception e){
				e.printStackTrace();
			} finally {
				close(connect);
			}
		}
		return lista;
	}
	
	/**
	 * Busca por nome, cpf ou telefone o paciente
	 * @param String search
	 * @return List<Paciente>
	 */
	
	public static List<Paciente> getPacientesFromSearch(String search) {
		Connection connect = connect();
		List<Paciente> lista = new ArrayList<Paciente>();
		if(connect != null){
			try {
				PreparedStatement pstmt = connect.prepareStatement("SELECT id, nome, cpf, telefone FROM pacientes WHERE (nome LIKE ? OR cpf = ? OR telefone = ?) ORDER BY nome ASC");
				pstmt.setString(1, "%" + search + "%");
				pstmt.setString(2, search);
				pstmt.setString(3, "%" + search + "%");
				ResultSet result = pstmt.executeQuery();
				while(result.next()){
					lista.add(new Paciente(
						result.getInt("id"),
						result.getString("nome"),
						result.getString("cpf"),
						result.getString("telefone")
					));
				}
				result.close();
			} catch(Exception e){
				e.printStackTrace();
			} finally {
				close(connect);
			}
		}
		return lista;
	}
	
	/**
	 * retorna o paciente pelo ID nele, caso nao encontre retorna null
	 * @param int id
	 * @return Paciente
	 */
	
	public static Paciente getPacienteById(int id) {
		Connection connect = connect();
		Paciente paciente = null;
		if(connect != null){
			try {
				Statement statement = connect.createStatement();
				ResultSet result = statement.executeQuery("select id, nome, cpf, telefone from pacientes where id = " + id + " limit 1");
				
				if(result.next()){
					paciente = new Paciente(
						result.getInt("id"),
						result.getString("nome"),
						result.getString("cpf"),
						result.getString("telefone")
					);
				}
				result.close();
			} catch(Exception e){
				e.printStackTrace();
			} finally {
				close(connect);
			}
		}
		return paciente;
	}
	
	/**
	 * Atualiza os dados de um paciente
	 * @param Paciente paciente
	 * @return boolean
	 */
	
	public static boolean setPaciente(Paciente paciente) {
		Connection connect = connect();
		if(connect != null){
			try {
				PreparedStatement statement = connect.prepareStatement("insert into pacientes (nome, cpf, telefone) values (?, ?, ?)");
				statement.setString(1, paciente.getNome());
				statement.setString(2, paciente.getCpf());
				statement.setString(3, paciente.getTelefone());
				statement.executeUpdate();
				
				return true;
			} catch(Exception e){
				e.printStackTrace();
			} finally {
				close(connect);
			}
		}
		return false;
	}
	
}
