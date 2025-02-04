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
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.online.multishop.vo.*;

import com.ayalait.fecha.FormatearFechas;
import com.ayalait.logguerclass.Notification;
import com.ayalait.modelo.AperturaCaja;
import com.ayalait.modelo.AperturasTerminal;
import com.ayalait.modelo.ResponseApertura;
import com.ayalait.modelo.Ventas;
import com.ayalait.modelo.VentasCobro;
import com.ayalait.modelo.VentasDetalle;
import com.ayalait.response.ResponseAperturaTerminal;
import com.ayalait.response.ResponseResultado;
import com.ayalait.response.ResponseValidarEstadoCaja;
import com.ayalait.utils.ErrorState;
import com.ayalait.utils.MessageCodeImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.multishop.modelo.DptoPais;
import com.multishop.modelo.OrdenPago;
import com.multishop.response.*;

@Service
public class ValidarPagoServiceImpl implements ValidarPagoService {

	public static String rutaDowloadProducto;

	private String hostStock;
	public static String terminal;
	private String dlocalGo;
	private String dlocalGoCambio;
	private String autentication;
	public static String notificationURL;
	public static String success_pago_url;
	ObjectWriter ow = (new ObjectMapper()).writer().withDefaultPrettyPrinter();
	public static String userTerminal;
	@Autowired
	RestTemplate restTemplate;

	private boolean desarrollo = false;

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
				this.hostStock = p.getProperty("server.stock");
				this.dlocalGo = p.getProperty("server.dlocalgo");
				this.autentication = p.getProperty("server.token");
				this.notificationURL = p.getProperty("server.notificaciones");
				this.success_pago_url = p.getProperty("server.success_pago_url");
				this.terminal = p.getProperty("server.terminal");
				this.userTerminal = p.getProperty("server.userTerminal");
				this.dlocalGoCambio = p.getProperty("server.dlocalGoCambio");

			}
		} catch (FileNotFoundException var3) {
			System.err.println(var3.getMessage());
		}

	}

	public ValidarPagoServiceImpl() {
		try {
			if (ParametrosServiceImpl.desarrollo) {
				rutaDowloadProducto = "C:\\xampp\\htdocs\\multishop\\img\\";
				hostStock = "http://localhost:8082";
				dlocalGo = "https://api-sbx.dlocalgo.com/v1/payments/";
				dlocalGoCambio = "https://api-sbx.dlocalgo.com/v1/currency-exchanges";
				autentication = "ICxxdYAWmYGMxBqBHYxwvEJotcExWHUZ:qKRLqfsYE1LZHS2PvPFPjZM5XUY8HT5Aj11UHUAD";
				notificationURL = "https://ayalait.com/notification/";
				success_pago_url = "http://localhost:8080/shopping?iduser=";
				terminal = "http://localhost:8087";
				userTerminal = "8fe25c3e-a8c8-48a5-943e-b0e94cd11db6";
			} else {
				cargarServer();
			}
		} catch (IOException var2) {
			System.err.println(var2.getMessage());
		}

	}

	@Override
	public ResponseValidarPago validarPagoOrden(RequestValidarPago request) throws JsonProcessingException {

		ResponseValidarPago responseOrder = new ResponseValidarPago();

		Notification noti = new Notification();

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", "Bearer " + autentication);
			HttpEntity<RequestValidarPago> requestEntity = new HttpEntity<>(request, headers);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("multishop-APP");
			noti.setRequest(ow.writeValueAsString(requestEntity));
			noti.setAccion("validarPagoOrden");
			noti.setId(UUID.randomUUID().toString());

			ResponseEntity<ValidarPagoResponse> response = restTemplate.exchange(this.dlocalGo, HttpMethod.POST,
					requestEntity, ValidarPagoResponse.class);

			if (response.getStatusCodeValue() == 200) {
				responseOrder.setStatus(true);
				responseOrder.setPagoValido(response.getBody());
				noti.setResponse(ow.writeValueAsString(responseOrder));
			}

		} catch (org.springframework.web.client.HttpClientErrorException e) {
			JsonParser jsonParser = new JsonParser();
			int in = e.getLocalizedMessage().indexOf("{");
			int in2 = e.getLocalizedMessage().indexOf("}");
			String cadena = e.getMessage().substring(in, in2 + 1);
			JsonObject myJson = (JsonObject) jsonParser.parse(cadena);
			responseOrder.setCode(myJson.get("code").getAsInt());
			ErrorState data = new ErrorState();
			data.setCode(myJson.get("code").getAsInt());
			data.setMenssage(MessageCodeImpl.getMensajeAPIPago(myJson.get("code").getAsString()));
			responseOrder.setCode(data.getCode());
			responseOrder.setError(data);
			try {
				noti.setResponse(ow.writeValueAsString(responseOrder));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {
			ErrorState data = new ErrorState();
			data.setCode(500);
			data.setMenssage("Error al conectar con el servidor dLocal");
			responseOrder.setCode(500);
			responseOrder.setError(data);
			System.err.println(ex.getLocalizedMessage());
		}

		return responseOrder;

	}

	@Cacheable(cacheNames = "cambioMoneda")
	@Override
	public ResponseCambioMoneda obtenerCambioMoneda() {

		ResponseCambioMoneda responseCambio = new ResponseCambioMoneda();
		try {

			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", "Bearer " + autentication);

			HttpEntity<String> entity = new HttpEntity<>(headers);

			ResponseEntity<List<CambioMoneda>> response = restTemplate.exchange(this.dlocalGoCambio, HttpMethod.GET,
					entity, new ParameterizedTypeReference<List<CambioMoneda>>() {
					});

			if (response.getStatusCodeValue() == 200) {
				responseCambio.setStatus(true);
				responseCambio.setCambio(response.getBody());
			}

		} catch (org.springframework.web.client.HttpClientErrorException e) {
			JsonParser jsonParser = new JsonParser();
			int in = e.getLocalizedMessage().indexOf("{");
			int in2 = e.getLocalizedMessage().indexOf("}");
			String cadena = e.getMessage().substring(in, in2 + 1);
			JsonObject myJson = (JsonObject) jsonParser.parse(cadena);
			responseCambio.setCode(myJson.get("code").getAsInt());
			ErrorState data = new ErrorState();
			data.setCode(myJson.get("code").getAsInt());
			data.setMenssage(MessageCodeImpl.getMensajeAPIPago(myJson.get("code").getAsString()));
			responseCambio.setCode(data.getCode());
			responseCambio.setError(data);

		} catch (Exception ex) {
			System.err.println(ex.getLocalizedMessage());
		}

		return responseCambio;
	}

	@Override
	public ResponseResultado abrirTerminal(AperturasTerminal request) {

		ResponseResultado responseResult = new ResponseResultado();

		try {

			String url = this.terminal + "/terminal/add";
			HttpHeaders headers = new HttpHeaders();

			HttpEntity<AperturasTerminal> requestEntity = new HttpEntity<>(request, headers);
			URI uri = new URI(url);
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);

			if (response.getStatusCodeValue() == 200) {

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
	public int obtenerNumeroOrden() {
		Notification noti = new Notification();
		int responseVal = 0;
		noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
		noti.setClass_id("multishop-APP");
		noti.setAccion("obtenerNumeroOrden");
		noti.setId(UUID.randomUUID().toString());
		String url = this.hostStock + "/shopping/orden-number";
		URI uri = null;
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResponseEntity<Integer> response = restTemplate.exchange(uri, HttpMethod.GET, null, Integer.class);

		if (response.getStatusCodeValue() == 200) {
			return responseVal = response.getBody();
		}

		noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
		ResponseResultado result = guardarLog(noti);
		if (!result.isStatus()) {
			System.err.println(result.getError().getCode() + " " + result.getError().getMenssage());
		}
		return responseVal;

	}

	@Override
	public ResponseValidarEstadoCaja obtenerAperturaTerminal() {

		ResponseValidarEstadoCaja responseResult = new ResponseValidarEstadoCaja();

		Notification noti = new Notification();

		try {
			String url = this.terminal + "/caja/validar?fecha=" + FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd");
			URI uri = new URI(url);

			ResponseEntity<AperturaCaja> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					AperturaCaja.class);

			if (response.getStatusCodeValue() == 200) {

				responseResult.setStatus(true);
				responseResult.setApertura(response.getBody());
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
		} catch (org.springframework.web.client.HttpClientErrorException e) {
			JsonParser jsonParser = new JsonParser();
			int in = e.getLocalizedMessage().indexOf("{");
			int in2 = e.getLocalizedMessage().indexOf("}");
			String cadena = e.getMessage().substring(in, in2 + 1);
			JsonObject myJson = (JsonObject) jsonParser.parse(cadena);
			responseResult.setCode(myJson.get("code").getAsInt());
			ErrorState data = new ErrorState();
			data.setCode(myJson.get("code").getAsInt());
			data.setMenssage(MessageCodeImpl.getMensajeServiceCompras(myJson.get("code").getAsString()));
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
		}

		/*
		 * noti.setFecha_fin(FormatearFechas.
		 * obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss")); ResponseResultado result =
		 * guardarLog(noti); if (!result.isStatus()) {
		 * System.err.println(result.getError().getCode() + " " +
		 * result.getError().getMenssage()); }
		 */

		return responseResult;

	}

	@Override
	public int obtenerConsecutivo() {
		int responseVal = 0;

		String url = this.terminal + "/terminal/consecutivo";
		URI uri = null;
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResponseEntity<Integer> response = restTemplate.exchange(uri, HttpMethod.GET, null, Integer.class);

		if (response.getStatusCodeValue() == 200) {
			return responseVal = response.getBody();
		}

		return responseVal;

	}

	@Override
	public ResponseResultado crearOrdenPago(OrdenPago orden) {

		ResponseResultado responseResult = new ResponseResultado();

		Notification noti = new Notification();

		try {
			String url = this.hostStock + "/shopping/orden/crear";
			HttpHeaders headers = new HttpHeaders();
			URI uri = new URI(url);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("multishop-APP");
			HttpEntity<OrdenPago> requestEntity = new HttpEntity<>(orden, headers);
			noti.setRequest(ow.writeValueAsString(requestEntity));
			noti.setAccion("imagenesProducto");
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);

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
		/*
		 * noti.setFecha_fin(FormatearFechas.
		 * obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss")); ResponseResultado result =
		 * guardarLog(noti); if (!result.isStatus()) {
		 * System.err.println(result.getError().getCode() + " " +
		 * result.getError().getMenssage()); }
		 */

		return responseResult;

	}

	@Override
	public ResponseOrdenPago obtenerOrdenPagoPorUsuarios(String idusuario) {

		ResponseOrdenPago responseResult = new ResponseOrdenPago();

		Notification noti = new Notification();

		try {
			String url = this.hostStock + "/shopping/orden/list-user?id=" + idusuario;
			URI uri = new URI(url);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("multishop-APP");
			noti.setRequest("id=" + idusuario);
			noti.setAccion("obtenerOrdenPagoPorUsuarios");
			noti.setId(UUID.randomUUID().toString());

			ResponseEntity<List<OrdenPago>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<OrdenPago>>() {
					});

			if (response.getStatusCodeValue() == 200) {

				responseResult.setStatus(true);
				responseResult.setLstOrdenPago(response.getBody());
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
		} catch (org.springframework.web.client.HttpClientErrorException e) {
			JsonParser jsonParser = new JsonParser();
			int in = e.getLocalizedMessage().indexOf("{");
			int in2 = e.getLocalizedMessage().indexOf("}");
			String cadena = e.getMessage().substring(in, in2 + 1);
			JsonObject myJson = (JsonObject) jsonParser.parse(cadena);
			responseResult.setCode(myJson.get("code").getAsInt());
			ErrorState data = new ErrorState();
			data.setCode(myJson.get("code").getAsInt());
			data.setMenssage(MessageCodeImpl.getMensajeServiceCompras(myJson.get("code").getAsString()));
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
		}

		/*
		 * noti.setFecha_fin(FormatearFechas.
		 * obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss")); ResponseResultado result =
		 * guardarLog(noti); if (!result.isStatus()) {
		 * System.err.println(result.getError().getCode() + " " +
		 * result.getError().getMenssage()); }
		 */

		return responseResult;

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

	@Cacheable(cacheNames = "statusTerminalUser")
	@Override
	public ResponseAperturaTerminal obtenerAperturaTerminalPorUsuario() {
		ResponseAperturaTerminal responseResult = new ResponseAperturaTerminal();
		try {

			String url = this.terminal + "/terminal/buscar?id=" + userTerminal + "&fecha="
					+ FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd");
			HttpHeaders headers = new HttpHeaders();

			HttpEntity<Void> requestEntity = new HttpEntity<>(null, headers);
			URI uri = new URI(url);
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);

			if (response.getStatusCodeValue() == 200) {
				responseResult.setCode(response.getStatusCodeValue());
				responseResult.setStatus(true);
				AperturasTerminal ap = new Gson().fromJson(response.getBody(), AperturasTerminal.class);
				responseResult.setTerminal(ap);

			} else if (response.getStatusCodeValue() == 202) {
				responseResult.setCode(406);
				responseResult.setStatus(true);
				ResponseApertura ap = new Gson().fromJson(response.getBody(), ResponseApertura.class);
				responseResult.setTerminalCierre(ap);
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
		} catch (org.springframework.web.client.HttpClientErrorException e) {
			JsonParser jsonParser = new JsonParser();
			int in = e.getLocalizedMessage().indexOf("{");
			int in2 = e.getLocalizedMessage().indexOf("}");
			String cadena = e.getMessage().substring(in, in2 + 1);
			JsonObject myJson = (JsonObject) jsonParser.parse(cadena);
			responseResult.setCode(myJson.get("code").getAsInt());
			ErrorState data = new ErrorState();
			data.setCode(myJson.get("code").getAsInt());
			data.setMenssage(myJson.get("menssage").getAsString());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);
			return responseResult;
		}

		return responseResult;
	}

	@Override
	public ResponseResultado guardarVentaCobro(VentasCobro request) {
		ResponseResultado responseResult = new ResponseResultado();

		try {

			String url = terminal + "/ventas/cobro/add";
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<VentasCobro> requestEntity = new HttpEntity<>(request, headers);
			URI uri = new URI(url);
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);

			if (response.getStatusCodeValue() == 200) {

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
	public ResponseVenta addVenta(Ventas request) {
		ResponseVenta responseResult = new ResponseVenta();

		try {

			String url = terminal + "/ventas/add";
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<Ventas> requestEntity = new HttpEntity<>(request, headers);
			URI uri = new URI(url);
			ResponseEntity<Ventas> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, Ventas.class);

			if (response.getStatusCodeValue() == 200) {

				responseResult.setStatus(true);
				responseResult.setVenta(response.getBody());

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
	public ResponseResultado addDetalleVenta(VentasDetalle request) {
		ResponseResultado responseResult = new ResponseResultado();

		try {

			String url = terminal + "/ventas/detalles/add";
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<VentasDetalle> requestEntity = new HttpEntity<>(request, headers);
			URI uri = new URI(url);
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);

			if (response.getStatusCodeValue() == 200) {

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

}
