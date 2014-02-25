package br.com.senacrs.clinica.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.senacrs.clinica.library.DatabaseConnection;
import br.com.senacrs.clinica.models.Agenda;
import br.com.senacrs.clinica.utils.DateUtil;

public class AgendaDao extends DatabaseConnection {

	public static List<Agenda> getAgendaList() {
		Connection connect = connect();
		List<Agenda> lista = new ArrayList<Agenda>();
		if(connect != null){
			try {
				Statement statement = connect.createStatement();
				ResultSet result = statement.executeQuery("select paciente, detalhes, data_inicio from view_agenda");
				while(result.next()){
					lista.add(new Agenda(
						result.getString("paciente"),
						result.getString("detalhes"),
						DateUtil.toSystem(result.getTimestamp("data_inicio"))
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
