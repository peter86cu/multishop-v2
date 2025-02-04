package com.online.multishop.utils;

import com.ayalait.modelo.Producto;
import com.ayalait.modelo.ProductoImagenes;
import com.online.multishop.service.ParametrosServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;



public class Utils {
	
	public static void descargarImagenProducto(ProductoImagenes producto ) throws IOException {
		
		if(producto!=null) {
			File file = new File(ParametrosServiceImpl.rutaDowloadProducto +producto.getNombre());
			if(!file.exists()) {
				byte trans[] = Base64.getDecoder().decode(producto.getImagen());
				Files.write(Paths.get(ParametrosServiceImpl.rutaDowloadProducto +producto.getNombre()), trans);
			}		
		}
		
	}
	
	
public static void descargarPrincipalProducto(Producto producto ) throws IOException {
		
		if(producto!=null) {
			File file = new File(ParametrosServiceImpl.rutaDowloadProducto +producto.getFoto());
			if(!file.exists()) {
				byte trans[] = Base64.getDecoder().decode(producto.getImagen());
				Files.write(Paths.get(ParametrosServiceImpl.rutaDowloadProducto +producto.getFoto()), trans);
			}		
		}
		
	}
	
	
	public static List<Producto> getPaginatedList(List<Producto> productos, int page, int size) {
	    int start = page * size;
	    int end = Math.min(start + size, productos.size());
	    if (start >= productos.size()) {
	        return new ArrayList<>(); // Retorna lista vacía si la página está fuera de rango
	    }
	    return productos.subList(start, end);
	}
	
	public static String generarId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	public static String rellenarConCeros(String cadena, int numCeros) {
	        String ceros = "OP-";

	        for (int i = cadena.length(); i < numCeros; i++) {
	            ceros += "0";
	        }

	        return ceros + cadena;
	    }

	public static String obtenerFechaPorFormato(String formato) {
		Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		return formatter.format(fecha);
	}
}
