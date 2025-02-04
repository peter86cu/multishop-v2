package com.online.multishop.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.ayalait.fecha.FormatearFechas;
import com.ayalait.logguerclass.Notification;
import com.ayalait.response.*;
import com.ayalait.utils.Email;
import com.ayalait.utils.ErrorState;
import com.ayalait.utils.MessageCodeImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.multishop.modelo.*;
import com.multishop.response.ResponseDirecciones;
import com.multishop.response.ResponseUsuarioShopping;
import com.online.multishop.vo.CambioMoneda;
 

@Service
public class ShoppingUsuariosServiceImpl implements ShoppingUsuariosService {

	public static String hostSeguridad;
	private String hostMail;
	
	@Autowired
	RestTemplate restTemplate= new RestTemplate();

	ObjectWriter ow = (new ObjectMapper()).writer().withDefaultPrettyPrinter();


	void cargarServer() throws IOException {
		Properties p = new Properties();

		try {
			URL url = this.getClass().getClassLoader().getResource("application.properties");
			if (url == null) {
				throw new IllegalArgumentException("application.properties" + " is not found 1");
			} else {
				InputStream propertiesStream = url.openStream();
				p.load(propertiesStream);
				propertiesStream.close();
				this.hostSeguridad = p.getProperty("server.seguridad");
				this.hostMail= p.getProperty("server.mail");

			}
		} catch (FileNotFoundException var3) {
			System.err.println(var3.getMessage());
		}

	}

	public ShoppingUsuariosServiceImpl() {
		try {
			if (ParametrosServiceImpl.desarrollo) {
				hostSeguridad = "http://localhost:7001";
				hostMail="http://localhost:7002";
			} else {
				cargarServer();
			}
		} catch (IOException var2) {
			System.err.println(var2.getMessage());
		}

	}

	@Override
	public ResponseResultado guardarLog(Notification noti) {
		ResponseResultado responseResult = new ResponseResultado();
		try {
			HttpHeaders headers = new HttpHeaders();
			String url = ParametrosServiceImpl.logger + "/notification";
			URI uri = new URI(url);
			HttpEntity<Notification> requestEntity = new HttpEntity<>(noti, headers);
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);

			if (response.getStatusCodeValue() == 201) {
				responseResult.setCode(response.getStatusCodeValue());
				responseResult.setStatus(true);
				responseResult.setResultado(response.getBody());
				return responseResult;
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {

			ErrorState data = new ErrorState();
			data.setCode(e.getStatusCode().value());
			data.setMenssage(e.getMessage());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
			return responseResult;

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseResult;

	}
	
	@Override
	public ResponseRegistrarUserShop crearUsuario(ShoppingUsuarios usuario) {
		
		ResponseRegistrarUserShop responseResult = new ResponseRegistrarUserShop();		
		Notification noti= new Notification();

		try {
			HttpHeaders headers = new HttpHeaders();
			String url = this.hostSeguridad + "/shopping/usuario/crear";
			URI uri = new URI(url);
			HttpEntity<ShoppingUsuarios> requestEntity = new HttpEntity<>(usuario, headers);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("notification-API");
			noti.setRequest(ow.writeValueAsString(requestEntity));
			noti.setAccion("crearUsuario");	
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<ConfirmarRegistro> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity,
					ConfirmarRegistro.class);

			if (response.getStatusCodeValue() == 200) {
				responseResult.setCode(response.getStatusCodeValue());
				responseResult.setStatus(true);
				responseResult.setConfirmar(response.getBody());
				noti.setResponse(ow.writeValueAsString(responseResult));
				
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {
			ErrorState data = new ErrorState();
			data.setCode(e.getStatusCode().value());
			data.setMenssage(e.getMessage());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
			try {
				noti.setResponse(ow.writeValueAsString(responseResult));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (org.springframework.web.client.HttpClientErrorException e) {
			JsonParser jsonParser = new JsonParser();
			int in = e.getLocalizedMessage().indexOf("{");
			int in2 = e.getLocalizedMessage().indexOf("}");
			String cadena = e.getMessage().substring(in, in2+1);
			JsonObject myJson = (JsonObject) jsonParser.parse(cadena);
			ErrorState data = new ErrorState();
			responseResult.setCode(myJson.get("code").getAsInt());
			responseResult.setStatus(false);
			if(responseResult.getCode()==70002) {
				data.setCode(responseResult.getCode());				
				data.setMenssage("Ya existe un usuario creado con el correo electrónico:"+usuario.getEmail());
				responseResult.setError(data);
			}else {

				data.setCode(myJson.get("code").getAsInt());
				data.setMenssage(MessageCodeImpl.getMensajeServiceUsuarios(myJson.get("code").getAsString() ));
				responseResult.setCode(data.getCode());
				responseResult.setError(data);
			}
			
		}
		
		
		/*noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
		ResponseResultado result= guardarLog(noti);
		if(!result.isStatus()) {
			System.err.println(result.getError().getCode() +" "+ result.getError().getMenssage());
		}*/

		return responseResult;
		
	}

	@Override
	public ResponseResultado obtenerToken(String mail, String pwd) {
		
		ResponseResultado responseResult = new ResponseResultado();

 
		try {
			String url = this.hostSeguridad + "/login/token?mail=" + mail + "&pwd=" + pwd;
			URI uri = new URI(url);
			 
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, null,String.class);

			
			
			if (response.getStatusCodeValue() == 200) {
				responseResult.setCode(response.getStatusCodeValue());
				responseResult.setStatus(true);
				responseResult.setResultado(response.getBody());
 				
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {
			ErrorState data = new ErrorState();
			data.setCode(e.getStatusCode().value());
			data.setMenssage(e.getMessage());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
			
		} catch (org.springframework.web.client.HttpClientErrorException e) {
			JsonParser jsonParser = new JsonParser();
			int code= e.getStatusCode().value();
			ErrorState data = new ErrorState();
			if(code==404) {
				data.setCode(code);
				data.setMenssage("Servicio en mantenimiento");
				responseResult.setCode(code);
				responseResult.setError(data);
				
				return responseResult;
			}if(code==406) {
				data.setCode(code);
				data.setMenssage("El usuario o la contraseña no son correctos. Por favor, verifica tus datos e inténtalo de nuevo.");
				responseResult.setCode(code);
				responseResult.setError(data);
				
				return responseResult;
			}else {
				int in = e.getLocalizedMessage().indexOf("{");
				int in2 = e.getLocalizedMessage().indexOf("}");
				String cadena = e.getMessage().substring(in, in2+1);
				JsonObject myJson = (JsonObject) jsonParser.parse(cadena);
				responseResult.setCode(myJson.get("code").getAsInt());
				data.setCode(myJson.get("code").getAsInt());
				data.setMenssage(MessageCodeImpl.getMensajeServiceUsuarios(myJson.get("code").getAsString() ));
				responseResult.setCode(data.getCode());
				responseResult.setError(data);
			}
				
			
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch(org.springframework.web.client.ResourceAccessException err) {
			//int code= err.;
			ErrorState data = new ErrorState();
			
				data.setCode(404);
				data.setMenssage("Servicio en mantenimiento");
				responseResult.setCode(404);
				responseResult.setError(data);
				
				return responseResult;
			
		}
		
		

		return responseResult;
		

	}

	public ResponseResultado validarToken(String token) {
		
		ResponseResultado responseResult = new ResponseResultado();
		Notification noti= new Notification();

		try {
			HttpHeaders headers = new HttpHeaders();
			String url = this.hostSeguridad + "/login/validar";
			URI uri = new URI(url);
			headers.set("Authorization", "Bearer "+token);
			HttpEntity<Void> requestEntity = new HttpEntity<>(null, headers);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("notification-API");
			noti.setRequest(ow.writeValueAsString(requestEntity));
			noti.setAccion("validarToken");	
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity,
					String.class);

			if (response.getStatusCodeValue() == 200) {
				
				responseResult.setStatus(true);
				responseResult.setResultado(response.getBody());
				noti.setResponse(ow.writeValueAsString(responseResult));
				
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {
			ErrorState data = new ErrorState();
			data.setCode(e.getStatusCode().value());
			data.setMenssage(e.getMessage());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
			try {
				noti.setResponse(ow.writeValueAsString(responseResult));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
		ResponseResultado result= guardarLog(noti);
		if(!result.isStatus()) {
			System.err.println(result.getError().getCode() +" "+ result.getError().getMenssage());
		}

		return responseResult;
		
	}

	
	@Override
	public ResponseUsuarioShopping obtenerDatosUsuarioLogin(String token, String mail) {
		
		ResponseUsuarioShopping responseResult = new ResponseUsuarioShopping();
 
		try {
			HttpHeaders headers = new HttpHeaders();
			String url = this.hostSeguridad + "/shopping/usuario/buscar?mail=" + mail;
			URI uri = new URI(url);
			headers.set("Authorization", "Bearer "+token);
			HttpEntity<String> requestEntity = new HttpEntity<>(mail, headers);
 			 
			ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity,
					Object.class);

			if (response.getStatusCodeValue() == 200) {
				responseResult.setCode(response.getStatusCodeValue());
				responseResult.setStatus(true);	
				 ObjectMapper mapper = new ObjectMapper();
				
				responseResult.setUser( mapper.convertValue(response.getBody(),  ShoppingUsuarios.class));
 				
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {
			ErrorState data = new ErrorState();
			data.setCode(e.getStatusCode().value());
			data.setMenssage(e.getMessage());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
			 
		}  catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (org.springframework.web.client.HttpClientErrorException e) {
			JsonParser jsonParser = new JsonParser();
			int in = e.getLocalizedMessage().indexOf("{");
			int in2 = e.getLocalizedMessage().indexOf("}");
			String cadena = e.getMessage().substring(in, in2+1);
			JsonObject myJson = (JsonObject) jsonParser.parse(cadena);
			responseResult.setCode(myJson.get("code").getAsInt());
			ErrorState data = new ErrorState();
			data.setCode(myJson.get("code").getAsInt());
			data.setMenssage(MessageCodeImpl.getMensajeServiceUsuarios(myJson.get("code").getAsString() ));
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
		}
		 

		return responseResult;
		
		
	}
	
public ResponseUsuarioShopping obtenerDatosUsuarioLoginV2(String token, String mail) {
		
		ResponseUsuarioShopping responseResult = new ResponseUsuarioShopping();
		Notification noti= new Notification();

		try {
			HttpHeaders headers = new HttpHeaders();
			String url = this.hostSeguridad + "/shopping/usuario/buscar?mail=" + mail;
			URI uri = new URI(url);
			headers.set("Authorization", "Bearer "+token);
			HttpEntity<String> requestEntity = new HttpEntity<>(mail, headers);
			String maill=requestEntity.getHeaders().get("mail").toString();
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("notification-API");
			noti.setRequest("mail=" + mail);
			noti.setAccion("obtenerDatosUsuarioLogin");	
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<ShoppingUsuarios> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity,
					ShoppingUsuarios.class);

			if (response.getStatusCodeValue() == 200) {
				responseResult.setCode(response.getStatusCodeValue());
				responseResult.setStatus(true);
				responseResult.setUser(response.getBody());
				noti.setResponse(ow.writeValueAsString(responseResult));
				
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {
			ErrorState data = new ErrorState();
			data.setCode(e.getStatusCode().value());
			data.setMenssage(e.getMessage());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
			try {
				noti.setResponse(ow.writeValueAsString(responseResult));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
		ResponseResultado result= guardarLog(noti);
		if(!result.isStatus()) {
			System.err.println(result.getError().getCode() +" "+ result.getError().getMenssage());
		}

		return responseResult;
		
		
	}

	@Override
	public ResponseUsuarioShopping buscarUsuarioPorId(String token, String id) {
		
		ResponseUsuarioShopping responseResult = new ResponseUsuarioShopping();

		Notification noti= new Notification();

		try {
			HttpHeaders headers = new HttpHeaders();
			String url = this.hostSeguridad + "/shopping/usuario/id-usuario?id=" + id;
			URI uri = new URI(url);
			headers.set("Authorization", "Bearer "+token);
			HttpEntity<Void> requestEntity = new HttpEntity<>(null, headers);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("notification-API");
			noti.setRequest("id=" + id);
			noti.setAccion("buscarUsuarioPorId");	
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity,
					String.class);

			if (response.getStatusCodeValue() == 200) {
				
				responseResult.setStatus(true);
				responseResult.setResultado(response.getBody());
				noti.setResponse(ow.writeValueAsString(responseResult));
				
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {
			ErrorState data = new ErrorState();
			data.setCode(e.getStatusCode().value());
			data.setMenssage(e.getMessage());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
			try {
				noti.setResponse(ow.writeValueAsString(responseResult));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
		ResponseResultado result= guardarLog(noti);
		if(!result.isStatus()) {
			System.err.println(result.getError().getCode() +" "+ result.getError().getMenssage());
		}

		return responseResult;
		
		
	}

	@Override
	public ResponseUsuarioShopping validarUsuario(String mail, String token) {
		
		ResponseUsuarioShopping responseResult = new ResponseUsuarioShopping();
		Notification noti= new Notification();

		try {
			HttpHeaders headers = new HttpHeaders();
			String url = this.hostSeguridad + "/shopping/usuario/buscar?mail=" + mail;
			URI uri = new URI(url);
			headers.set("Authorization", "Bearer "+token);
			HttpEntity<Void> requestEntity = new HttpEntity<>(null, headers);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("notification-API");
			noti.setRequest("mail=" + mail);
			noti.setAccion("validarUsuario");	
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity,
					String.class);

			if (response.getStatusCodeValue() == 200) {
				
				responseResult.setStatus(true);
				responseResult.setResultado(response.getBody());
				noti.setResponse(ow.writeValueAsString(responseResult));
				
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {
			ErrorState data = new ErrorState();
			data.setCode(e.getStatusCode().value());
			data.setMenssage(e.getMessage());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
			try {
				noti.setResponse(ow.writeValueAsString(responseResult));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
		ResponseResultado result= guardarLog(noti);
		if(!result.isStatus()) {
			System.err.println(result.getError().getCode() +" "+ result.getError().getMenssage());
		}

		return responseResult;
		
		

	}

	@Override
	public String salir(RestTemplate template) {
		return (String) template.postForObject(hostSeguridad + "/login/salir", null, String.class, new Object[0]);
	}

	@Override
	public ResponseResultado cambiarPassword(String idUsuario, String pass, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseResultado guardarDireccionUsuario(DireccionUsuario dir, String token) {
		
		ResponseResultado responseResult = new ResponseResultado();
		Notification noti= new Notification();

		try {
			HttpHeaders headers = new HttpHeaders();
			String url = this.hostSeguridad + "/shopping/direccion/crear";
			URI uri = new URI(url);
			headers.set("Authorization", "Bearer "+token);
			HttpEntity<DireccionUsuario> requestEntity = new HttpEntity<>(dir, headers);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("notification-API");
			noti.setRequest(ow.writeValueAsString(requestEntity));
			noti.setAccion("obtenerOrdenPagoId");	
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity,
					String.class);

			if (response.getStatusCodeValue() == 200) {
				
				responseResult.setStatus(true);
				responseResult.setResultado(response.getBody());
				noti.setResponse(ow.writeValueAsString(responseResult));
				
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {
			ErrorState data = new ErrorState();
			data.setCode(e.getStatusCode().value());
			data.setMenssage(e.getMessage());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
			try {
				noti.setResponse(ow.writeValueAsString(responseResult));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
		ResponseResultado result= guardarLog(noti);
		if(!result.isStatus()) {
			System.err.println(result.getError().getCode() +" "+ result.getError().getMenssage());
		}

		return responseResult;

		
	}

	@Override
	public ResponseDirecciones recuperarDreccionUsuarioPorId(String idUsuario, String token) {
		
		ResponseDirecciones responseResult = new ResponseDirecciones();
		Notification noti= new Notification();

		try {
			HttpHeaders headers = new HttpHeaders();
			String url = this.hostSeguridad + "/shopping/direccion/buscar?id="+idUsuario;
			URI uri = new URI(url);
			headers.set("Authorization", "Bearer "+token);
			//headers.set("id", idUsuario);
			HttpEntity<String> requestEntity = new HttpEntity<>(idUsuario, headers);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("notification-API");
			noti.setRequest("id=" + idUsuario);
			noti.setAccion("obtenerOrdenPagoId");	
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<List<DireccionUsuario>> response=null;
			try {
			 response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity,
						new ParameterizedTypeReference<List<DireccionUsuario>>() {
				});
				
			} catch (org.springframework.web.client.HttpClientErrorException e) {
				ErrorState data = new ErrorState();
				data.setCode(e.getStatusCode().value());
				data.setMenssage(e.getMessage());
				responseResult.setCode(data.getCode());
				responseResult.setError(data);
				try {
					noti.setResponse(ow.writeValueAsString(responseResult));
				} catch (JsonProcessingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
				ResponseResultado result= guardarLog(noti);
				if(!result.isStatus()) {
					System.err.println(result.getError().getCode() +" "+ result.getError().getMenssage());
				}

				return responseResult;
			}
			

			if (response.getStatusCodeValue() == 200) {
				responseResult.setCode(response.getStatusCodeValue());
				responseResult.setStatus(true);
				responseResult.setDirecciones(response.getBody());
				noti.setResponse(ow.writeValueAsString(responseResult));
				
			}

		} catch (Exception e) {
			ErrorState data = new ErrorState();
			data.setCode(500);
			data.setMenssage(e.getMessage());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
			try {
				noti.setResponse(ow.writeValueAsString(responseResult));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		/*noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
		ResponseResultado result= guardarLog(noti);
		if(!result.isStatus()) {
			System.err.println(result.getError().getCode() +" "+ result.getError().getMenssage());
		}*/

		return responseResult;


		
	}

	@Override
	public ResponseResultado eliminarDreccionUsuarioPorId(int id, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseResultado confirmarToken(String token) {
		ResponseResultado responseResult = new ResponseResultado();

		try {
			HttpHeaders headers = new HttpHeaders();
			String url = this.hostSeguridad + "/confirmar/user";
			URI uri = new URI(url);
			headers.set("Authorization", "Bearer "+token);
			HttpEntity<Void> requestEntity = new HttpEntity<>(null, headers);
		
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity,
					String.class);

			if (response.getStatusCodeValue() == 200) {
				responseResult.setCode(response.getStatusCodeValue());
				responseResult.setStatus(true);
				responseResult.setResultado(response.getBody());
				
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {
			ErrorState data = new ErrorState();
			data.setCode(e.getStatusCode().value());
			data.setMenssage(e.getMessage());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
			
		
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responseResult;
	}

	@Override
	public ResponseResultado enviarMailConfirmacion(Email email) {
		ResponseResultado responseResult = new ResponseResultado();

		try {
			HttpHeaders headers = new HttpHeaders();
			String url = this.hostMail + "/sendMailBody";
			URI uri = new URI(url);
	
			HttpEntity<Email> requestEntity = new HttpEntity<>(email, headers);
		
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity,
					String.class);

			if (response.getStatusCodeValue() == 200) {
				responseResult.setCode(response.getStatusCodeValue());
				responseResult.setStatus(true);
				responseResult.setResultado(response.getBody());
				
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {
			ErrorState data = new ErrorState();
			data.setCode(e.getStatusCode().value());
			data.setMenssage(e.getMessage());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
			
		
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responseResult;
	}

	@Override
	public ResponseUsuarioShopping buscarUserPorToken(String token) {
		ResponseUsuarioShopping responseResult = new ResponseUsuarioShopping();

		try {
			HttpHeaders headers = new HttpHeaders();
			String url = this.hostSeguridad + "/obtener/user-token";
			URI uri = new URI(url);
			headers.set("Authorization", "Bearer "+token);
			HttpEntity<Void> requestEntity = new HttpEntity<>(null, headers);
		
			ResponseEntity<ShoppingUsuarios> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity,
					ShoppingUsuarios.class);

			if (response.getStatusCodeValue() == 200) {
				responseResult.setCode(response.getStatusCodeValue());
				responseResult.setStatus(true);
				responseResult.setUser(response.getBody());
				
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {
			ErrorState data = new ErrorState();
			data.setCode(e.getStatusCode().value());
			data.setMenssage(e.getMessage());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
			
		
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responseResult;
	}

	@Override
	public ResponseResultado eliminarCuenta(String id, String token) {
		ResponseResultado responseResult = new ResponseResultado();

		try {
			HttpHeaders headers = new HttpHeaders();
			String url = this.hostSeguridad + "/shopping/usuario/delete?id="+id;
			URI uri = new URI(url);
			headers.set("Authorization", "Bearer "+token);
			HttpEntity<Void> requestEntity = new HttpEntity<>(null, headers);
		
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.DELETE, requestEntity,
					String.class);

			if (response.getStatusCodeValue() == 200) {
				responseResult.setCode(response.getStatusCodeValue());
				responseResult.setStatus(true);
				responseResult.setResultado(response.getBody());
				
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {
			ErrorState data = new ErrorState();
			data.setCode(e.getStatusCode().value());
			data.setMenssage(e.getMessage());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
			
		
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (org.springframework.web.client.HttpClientErrorException e) {
			JsonParser jsonParser = new JsonParser();
			int in = e.getLocalizedMessage().indexOf("{");
			int in2 = e.getLocalizedMessage().indexOf("}");
			String cadena = e.getMessage().substring(in, in2+1);
			JsonObject myJson = (JsonObject) jsonParser.parse(cadena);
			responseResult.setCode(myJson.get("code").getAsInt());
			ErrorState data = new ErrorState();
			data.setCode(myJson.get("code").getAsInt());
			data.setMenssage(MessageCodeImpl.getMensajeServiceUsuarios(myJson.get("code").getAsString() ));
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
		}
		 
		
		return responseResult;
	}

	

}
