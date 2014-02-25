package br.com.senacrs.clinica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.senacrs.clinica.library.DatabaseConnection;
import br.com.senacrs.clinica.models.Consulta;
import br.com.senacrs.clinica.models.Medicamento;
import br.com.senacrs.clinica.utils.DateUtil;

public class ConsultasDao extends DatabaseConnection {
	
	public static Consulta getConsultaById(int id) {
		Connection connect = connect();
		Consulta consulta = null;
		if(connect != null){
			try {
				Statement statement = connect.createStatement();
				ResultSet result = statement.executeQuery("select id, paciente, detalhes, data_inicio, data_fim from consultas where id = " + id + " limit 1");
				if(result.next()){
					consulta = new Consulta(
						result.getInt("id"),
						result.getString("descricao"),
						DateUtil.toSystem(result.getTimestamp("data_inicio")),
						DateUtil.toSystem(result.getTimestamp("data_fim")),
						PacientesDao.getPacienteById(result.getInt("paciente")),
						MedicamentosDao.getMedicamentosListByConsulta(result.getInt("id"))
					);
				}
				result.close();
			} catch(Exception e){
				e.printStackTrace();
			} finally {
				close(connect);
			}
		}
		return consulta;
	}
	
	public static List<Consulta> getConsultasList() {
		Connection connect = connect();
		List<Consulta> lista = new ArrayList<Consulta>();
		if(connect != null){
			try {
				Statement statement = connect.createStatement();
				ResultSet result = statement.executeQuery("select id, paciente, detalhes, data_inicio, data_fim from consultas order by data_inicio desc");
				while(result.next()){
					lista.add(new Consulta(
						result.getInt("id"),
						result.getString("detalhes"),
						DateUtil.toSystem(result.getTimestamp("data_inicio")),
						DateUtil.toSystem(result.getTimestamp("data_fim")),
						PacientesDao.getPacienteById(result.getInt("paciente")),
						MedicamentosDao.getMedicamentosListByConsulta(result.getInt("id"))
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
	
	
	
	public static boolean setConsulta(Consulta consulta) {
		Connection connect = connect();
		if(connect != null){
			try {
				connect.setAutoCommit(false);
				PreparedStatement statement = connect.prepareStatement("insert into consultas (paciente, detalhes, data_inicio, data_fim) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, consulta.getPaciente().getId());
				statement.setString(2, consulta.getDescricao());
				statement.setTimestamp(3, DateUtil.toSql(consulta.getData_inicio()));
				statement.setTimestamp(4, DateUtil.toSql(consulta.getData_fim()));
				statement.executeUpdate();
				
				int consultaId = -1;
				
				ResultSet keys = statement.getGeneratedKeys();
				if(keys != null && keys.next()){
					consultaId = keys.getInt(1);
				} else throw new Exception("getGeneratedKeys is empty!");
				
				if(consulta.getMedicamentos() != null && consulta.getMedicamentos().size() > 0){
					for(Medicamento medicamento : consulta.getMedicamentos()){
						String query = String.format("insert into consultas_medicamentos (consulta, medicamento) values (%d, %d)",consultaId,medicamento.getId());
						statement.executeUpdate(query);
					}
				}
				
				connect.commit();
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
