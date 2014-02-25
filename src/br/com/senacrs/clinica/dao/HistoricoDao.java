package br.com.senacrs.clinica.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.senacrs.clinica.library.DatabaseConnection;
import br.com.senacrs.clinica.models.Historico;
import br.com.senacrs.clinica.utils.DateUtil;

public class HistoricoDao extends DatabaseConnection {

	public static List<Historico> getHistoricoList() {
		Connection connect = connect();
		List<Historico> lista = new ArrayList<Historico>();
		if(connect != null){
			try {
				Statement statement = connect.createStatement();
				ResultSet result = statement.executeQuery("select paciente, detalhes, data_inicio, data_fim from view_historico");
				while(result.next()){
					lista.add(new Historico(
						result.getString("paciente"),
						result.getString("detalhes"),
						DateUtil.toSystem(result.getTimestamp("data_inicio")),
						DateUtil.toSystem(result.getTimestamp("data_fim"))
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
