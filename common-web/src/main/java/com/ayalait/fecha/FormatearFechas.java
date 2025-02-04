package com.ayalait.fecha;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatearFechas {
	
	public static String obtenerFechaPorFormato(String formato) {
		Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		return formatter.format(fecha);
	}

}
