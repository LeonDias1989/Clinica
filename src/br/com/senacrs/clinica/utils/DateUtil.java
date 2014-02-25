package br.com.senacrs.clinica.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
	private static SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public static String toSystem(Timestamp timestamp){
		if(timestamp == null)
			return null;
		
		return format.format(timestamp);
	}
	
	public static Timestamp toSql(String timestamp) throws ParseException {
		if(timestamp == null)
			return null;
		
		return new Timestamp(sqlFormat.parse(timestamp).getTime());
	}	
}
