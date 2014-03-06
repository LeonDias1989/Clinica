package br.com.senacrs.clinica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.senacrs.clinica.library.DatabaseConnection;
import br.com.senacrs.clinica.models.Medicamento;

public class MedicamentosDao extends DatabaseConnection {

	public static List<Medicamento> getMedicamentosList() {
		Connection connect = connect();
		List<Medicamento> lista = new ArrayList<Medicamento>();
		if(connect != null){
			try {
				Statement statement = connect.createStatement();
				ResultSet result = statement.executeQuery("select id, nome from medicamentos order by nome asc");
				while(result.next()){
					lista.add(new Medicamento(
						result.getInt("id"),
						result.getString("nome")
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
	
	public static List<Medicamento> getMedicamentoFromSearch(String search) {
		Connection connect = connect();
		List<Medicamento> lista = new ArrayList<Medicamento>();
		if(connect != null){
			try {
				PreparedStatement pstmt = connect.prepareStatement("SELECT id, nome FROM medicamentos WHERE nome LIKE ? ORDER BY nome ASC");
				pstmt.setString(1, "%" + search + "%");
				ResultSet result = pstmt.executeQuery();
				while(result.next()){
					lista.add(new Medicamento(
						result.getInt("id"),
						result.getString("nome")
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
	
	public static Medicamento getMedicamentoById(int id) {
		Connection connect = connect();
		Medicamento medicamento = null;
		if(connect != null){
			try {
				Statement statement = connect.createStatement();
				ResultSet result = statement.executeQuery("select id, nome from medicamentos where id = " + id + " limit 1");
				if(result.next()){
					medicamento = new Medicamento(
						result.getInt("id"),
						result.getString("nome")
					);
				}
				result.close();
			} catch(Exception e){
				e.printStackTrace();
			} finally {
				close(connect);
			}
		}
		return medicamento;
	}
	
	public static boolean setMedicamento(Medicamento medicamento) {
		Connection connect = connect();
		if(connect != null){
			try {
				PreparedStatement statement = connect.prepareStatement("insert into medicamentos (nome) values (?)");
				statement.setString(1, medicamento.getNome());
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

	public static List<Medicamento> getMedicamentosListByConsulta(int id) {
		Connection connect = connect();
		List<Medicamento> lista = new ArrayList<Medicamento>();
		if(connect != null){
			try {
				Statement statement = connect.createStatement();
				
				ResultSet result = statement.executeQuery("select medicamentos.id, medicamentos.nome from medicamentos "
					+ "inner join consultas_medicamentos on medicamentos.id = consultas_medicamentos.medicamento "
					+ "inner join consultas on consultas_medicamentos.consulta = consultas.id "
					+ "where consultas.id = " + id + " order by medicamentos.nome asc"
				);
				
				while(result.next()){
					lista.add(new Medicamento(
						result.getInt("id"),
						result.getString("nome")
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
}
