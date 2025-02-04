package com.online.multishop.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.ayalait.response.ResponseResultado;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.multishop.modelo.Session;
import com.multishop.response.ResponseApi;
import com.multishop.response.ResponseCarritoDetalle;
import com.multishop.response.ResponseOrdenPago;
import com.online.multishop.service.ParametrosService;
import com.online.multishop.service.ShoppingUsuariosService;
import com.online.multishop.service.ValidarPagoService;

@RestController
public class ValidarPageController {
	
	@Autowired
	ShoppingUsuariosService service;

	@Autowired
	ParametrosService servicePara;

	@Autowired
	ValidarPagoService servicePagos;

	ObjectWriter ow = (new ObjectMapper()).writer().withDefaultPrettyPrinter();
	
	
	
	@PostMapping({ "/valdate-shop-user" })
	@CrossOrigin(origins = "*", methods = { RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public void logout( @RequestParam("iduser") String id, HttpServletResponse responseHttp) throws RestClientException, IOException {
		ResponseResultado response= new ResponseResultado();
		
		if (InicioController.session.getToken() != null) {
			ResponseOrdenPago responseResult = servicePagos.obtenerOrdenPagoPorUsuarios(id);
			if(responseResult.isStatus()) {
				if(responseResult.getLstOrdenPago().isEmpty()) {
					String json = new Gson().toJson(response);
					responseHttp.setContentType("application/json");
					responseHttp.setCharacterEncoding("UTF-8");
					responseHttp.getWriter().write(json);
				}
			}
			
			
			
		}else {
			response.setCode(201);
			response.setResultado("");
			String json = new Gson().toJson(response);
			responseHttp.setContentType("application/json");
			responseHttp.setCharacterEncoding("UTF-8");
			responseHttp.getWriter().write(json);
		}
		

		
	}
	

}
