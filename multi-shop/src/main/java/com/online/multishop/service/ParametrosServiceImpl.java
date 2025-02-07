package com.online.multishop.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ayalait.fecha.FormatearFechas;
import com.ayalait.logguerclass.Notification;
import com.ayalait.modelo.*;
import com.ayalait.response.*;
import com.ayalait.utils.ErrorState;
import com.ayalait.utils.MessageCodeImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.multishop.modelo.DptoPais;
import com.multishop.modelo.ShoppingHistoryEstado;
import com.multishop.response.*;
import com.online.multishop.SSLConfig;
import com.online.multishop.dto.PreguntaRespuesta;
import com.online.multishop.vo.RequestAddCart;
import com.online.multishop.vo.ResponsePreguntaRespuesta;
import com.fasterxml.jackson.databind.type.CollectionType;

@Service
public class ParametrosServiceImpl implements ParametrosService {

	public static String rutaDowloadProducto;
	private String hostStock;
	private String hostReursosHumanos;
	public int codigoPais = 2;
	public static String logger;
	public static boolean desarrollo;
	ObjectWriter ow = (new ObjectMapper()).writer().withDefaultPrettyPrinter();

	@Autowired
	RestTemplate restTemplate;

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
				this.logger = p.getProperty("server.logger");
				this.hostReursosHumanos = p.getProperty("server.rrhh");
				this.rutaDowloadProducto = p.getProperty("server.uploaderProductos");
				this.codigoPais = Integer.parseInt(p.getProperty("server.codigopais"));
				this.desarrollo = Boolean.parseBoolean(p.getProperty("server.desarrollo"));

			}
		} catch (FileNotFoundException var3) {
			System.err.println(var3.getMessage());
		}

	}

	public ParametrosServiceImpl() throws IOException {

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
				this.logger = p.getProperty("server.logger");
				this.hostReursosHumanos = p.getProperty("server.rrhh");
				this.rutaDowloadProducto = p.getProperty("server.uploaderProductos");
				this.codigoPais = Integer.parseInt(p.getProperty("server.codigopais"));
				this.desarrollo = Boolean.parseBoolean(p.getProperty("server.desarrollo"));

			}

			if (desarrollo) {
				hostStock = "http://localhost:8082";
				logger = "http://localhost:8086";
				hostReursosHumanos = "http://localhost:8085";
				rutaDowloadProducto = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\";
			}

		} catch (FileNotFoundException var3) {
			System.err.println(var3.getMessage());
		}
	}

	@Override
	public ResponseResultado guardarLog(Notification noti) {

		ResponseResultado responseResult = new ResponseResultado();
		try {
			HttpHeaders headers = new HttpHeaders();
			String url = this.logger + "/notification";
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

	@Cacheable(cacheNames = "dptoPais")
	@Override
	public ResponseListaDpto listadoDptoPais() {

		ResponseListaDpto responseResult = new ResponseListaDpto();

		try {

			String url = ShoppingUsuariosServiceImpl.hostSeguridad + "/shopping/departamentos/buscar?pais="
					+ codigoPais;

			URI uri = new URI(url);
			ResponseEntity<List<DptoPais>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<DptoPais>>() {
					});

			if (response.getStatusCodeValue() == 200) {

				responseResult.setStatus(true);
				responseResult.setDpto(response.getBody());

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

	@Cacheable(cacheNames = "tipoProducto")
	@Override
	public ResponseTipoProducto listadoTipoProducto() {

		ResponseTipoProducto responseResult = new ResponseTipoProducto();
		Notification noti = new Notification();

		try {

			String url = this.hostStock + "/parametros/tipoproducto";
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("multishop-APP");
			noti.setAccion("listadoTipoProducto");
			noti.setId(UUID.randomUUID().toString());
			URI uri = new URI(url);
			try {
				restTemplate = SSLConfig.getRestTemplate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ResponseEntity<List<TipoProducto>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<TipoProducto>>() {
					});

			if (response.getStatusCodeValue() == 200) {

				responseResult.setStatus(true);
				responseResult.setTipoProductos(response.getBody());
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
		/*
		 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
		 * System.err.println(result.getError().getCode() + " " +
		 * result.getError().getMenssage()); }
		 */

		return responseResult;

	}

	@Cacheable(cacheNames = "categorias")
	@Override
	public ResponseCategorias listarCategorias() {

		ResponseCategorias responseResult = new ResponseCategorias();
		Notification noti = new Notification();

		try {

			String url = this.hostStock + "/parametros/categoria";
			URI uri = new URI(url);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("multishop-APP");

			noti.setAccion("listarCategorias");
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<List<Categoria>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Categoria>>() {
					});

			if (response.getStatusCodeValue() == 200) {

				responseResult.setStatus(true);
				responseResult.setCategorias(response.getBody());
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
		/*
		 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
		 * System.err.println(result.getError().getCode() + " " +
		 * result.getError().getMenssage()); }
		 */

		return responseResult;
	}

	@Cacheable(cacheNames = "marcas")
	@Override
	public ResponseListaMarcasProducto listadoMarcasProducto() {

		ResponseListaMarcasProducto responseResult = new ResponseListaMarcasProducto();

		Notification noti = new Notification();

		try {

			String url = this.hostStock + "/parametros/marcas";

			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("multishop-APP");
			URI uri = new URI(url);
			noti.setAccion("listadoMarcasProducto");
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<List<MarcaProducto>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<MarcaProducto>>() {
					});

			if (response.getStatusCodeValue() == 200) {

				responseResult.setStatus(true);
				responseResult.setMarcas(response.getBody());
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
		/*
		 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
		 * System.err.println(result.getError().getCode() + " " +
		 * result.getError().getMenssage()); }
		 */

		return responseResult;

	}

	@Cacheable(cacheNames = "modelos")
	@Override
	public ResponseListaModeloProducto listadoModelosProducto() {

		ResponseListaModeloProducto responseResult = new ResponseListaModeloProducto();

		Notification noti = new Notification();

		try {

			String url = this.hostStock + "/parametros/modelos";

			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("multishop-APP");
			URI uri = new URI(url);
			noti.setAccion("listadoModelosProducto");
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<List<ModeloProducto>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<ModeloProducto>>() {
					});

			if (response.getStatusCodeValue() == 200) {

				responseResult.setStatus(true);
				responseResult.setModelo(response.getBody());
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
		/*
		 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
		 * System.err.println(result.getError().getCode() + " " +
		 * result.getError().getMenssage()); }
		 */

		return responseResult;

	}

	@Cacheable(cacheNames = "productos")
	@Override
	public ResponseListaProductos consultarListaProductos() {

		ResponseListaProductos responseResult = new ResponseListaProductos();
		Notification noti = new Notification();

		try {

			String url = this.hostStock + "/productos/lista";

			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("multishop-APP");
			URI uri = new URI(url);
			noti.setAccion("consultarListaProductos");
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<List<Producto>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Producto>>() {
					});

			if (response.getStatusCodeValue() == 200) {

				responseResult.setStatus(true);
				responseResult.setProductos(response.getBody());
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
		/*
		 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
		 * System.err.println(result.getError().getCode() + " " +
		 * result.getError().getMenssage()); }
		 */

		return responseResult;

	}

	@Override
	public ResponseMonedas listarMonedas() {

		ResponseMonedas responseResult = new ResponseMonedas();

		Notification noti = new Notification();

		try {

			String url = this.hostStock + "/parametros/monedas";

			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("multishop-APP");
			URI uri = new URI(url);
			noti.setAccion("listarMonedas");
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<List<Moneda>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Moneda>>() {
					});

			if (response.getStatusCodeValue() == 200) {

				responseResult.setStatus(true);
				responseResult.setMonedas(response.getBody());
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
		/*
		 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
		 * System.err.println(result.getError().getCode() + " " +
		 * result.getError().getMenssage()); }
		 */

		return responseResult;

	}

	@Override
	public ResponseImagenesProducto imagenesProducto(String id) {

		ResponseImagenesProducto responseResult = new ResponseImagenesProducto();
		Notification noti = new Notification();

		try {
			String url = this.hostStock + "/productos/imagenes?id=" + id;
			URI uri = new URI(url);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("multishop-APP");
			noti.setRequest(id);
			noti.setAccion("imagenesProducto");
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<List<ProductoImagenes>> response = null;
			try {
				response = restTemplate.exchange(uri, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<ProductoImagenes>>() {
						});
			} catch (org.springframework.web.client.HttpClientErrorException e) {
				JsonParser jsonParser = new JsonParser();
				int in = e.getLocalizedMessage().indexOf("{");
				int in2 = e.getLocalizedMessage().indexOf("}");
				String cadena = e.getMessage().substring(in, in2 + 1);
				JsonObject myJson = (JsonObject) jsonParser.parse(cadena);
				responseResult.setCode(myJson.get("code").getAsInt());
				ErrorState data = new ErrorState();
				data.setCode(myJson.get("code").getAsInt());
				data.setMenssage(MessageCodeImpl.getMensajeAPIPago(myJson.get("code").getAsString()));
				responseResult.setCode(data.getCode());
				responseResult.setError(data);
				noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
				/*
				 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
				 * System.err.println(result.getError().getCode() + " " +
				 * result.getError().getMenssage()); }
				 */

				return responseResult;
			}

			if (response.getStatusCodeValue() == 200) {

				responseResult.setStatus(true);
				responseResult.setImagenProducto(response.getBody());
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
		/*
		 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
		 * System.err.println(result.getError().getCode() + " " +
		 * result.getError().getMenssage()); }
		 */

		return responseResult;

	}

	@Override
	public ResponseDetalleProducto detalleProducto(String id) {

		ResponseDetalleProducto responseResult = new ResponseDetalleProducto();

		Notification noti = new Notification();

		try {
			String url = this.hostStock + "/productos/detalle?id=" + id;
			URI uri = new URI(url);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("multishop-APP");
			noti.setRequest(id);
			noti.setAccion("detalleProducto");
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<ProductoDetalles> response = null;
			try {
				response = restTemplate.exchange(uri, HttpMethod.GET, null, ProductoDetalles.class);
			} catch (org.springframework.web.client.HttpClientErrorException e) {
				JsonParser jsonParser = new JsonParser();
				int in = e.getLocalizedMessage().indexOf("{");
				int in2 = e.getLocalizedMessage().indexOf("}");
				String cadena = e.getMessage().substring(in, in2 + 1);
				JsonObject myJson = (JsonObject) jsonParser.parse(cadena);
				responseResult.setCode(myJson.get("code").getAsInt());
				ErrorState data = new ErrorState();
				data.setCode(myJson.get("code").getAsInt());
				data.setMenssage(MessageCodeImpl.getMensajeAPIPago(myJson.get("code").getAsString()));
				responseResult.setCode(data.getCode());
				responseResult.setError(data);
				noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
				/*
				 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
				 * System.err.println(result.getError().getCode() + " " +
				 * result.getError().getMenssage()); }
				 */

				return responseResult;
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
				noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
				/*
				 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
				 * System.err.println(result.getError().getCode() + " " +
				 * result.getError().getMenssage()); }
				 */

				return responseResult;
			}

			if (response.getStatusCodeValue() == 200) {
				responseResult.setStatus(true);
				responseResult.setDetalle(response.getBody());
				// noti.setResponse(ow.writeValueAsString(responseResult));

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
		noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
		/*
		 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
		 * System.err.println(result.getError().getCode() + " " +
		 * result.getError().getMenssage()); }
		 */

		return responseResult;

	}

	@Override
	public ResponseResultado guardarCarrito(RequestAddCart request) {

		ResponseResultado responseResult = new ResponseResultado();

		Notification noti = new Notification();

		try {
			String url = this.hostStock + "/shopping/guardar-cart";
			HttpHeaders headers = new HttpHeaders();
			URI uri = new URI(url);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("multishop-APP");
			HttpEntity<RequestAddCart> requestEntity = new HttpEntity<>(request, headers);

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
		noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
		/*
		 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
		 * System.err.println(result.getError().getCode() + " " +
		 * result.getError().getMenssage()); }
		 */

		return responseResult;

	}

	@Override
	public ResponseCart obtenerCarrito(String idCart, String idUsuario) {

		ResponseCart responseResult = new ResponseCart();
		Notification noti = new Notification();

		try {
			String url = this.hostStock + "/shopping/obtener-cart?idcart=" + idCart + "&idusuario=" + idUsuario;
			URI uri = new URI(url);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("multishop-APP");
			noti.setRequest("idcart=" + idCart + "&idusuario=" + idUsuario);

			noti.setAccion("obtenerCarrito");
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<CarritoDetalle> response = null;
			try {
				response = restTemplate.exchange(uri, HttpMethod.GET, null, CarritoDetalle.class);
			} catch (org.springframework.web.client.HttpClientErrorException e) {
				JsonParser jsonParser = new JsonParser();
				int in = e.getLocalizedMessage().indexOf("{");
				int in2 = e.getLocalizedMessage().indexOf("}");
				String cadena = e.getMessage().substring(in, in2 + 1);
				JsonObject myJson = (JsonObject) jsonParser.parse(cadena);
				responseResult.setCode(myJson.get("code").getAsInt());
				ErrorState data = new ErrorState();
				data.setCode(myJson.get("code").getAsInt());
				data.setMenssage(MessageCodeImpl.getMensajeAPIPago(myJson.get("code").getAsString()));
				responseResult.setCode(data.getCode());
				responseResult.setError(data);
				try {
					noti.setResponse(ow.writeValueAsString(responseResult));
				} catch (JsonProcessingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return responseResult;
			}

			if (response.getStatusCodeValue() == 200) {

				responseResult.setStatus(true);
				responseResult.setCartDetalle(response.getBody());
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
		/*
		 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
		 * System.err.println(result.getError().getCode() + " " +
		 * result.getError().getMenssage()); }
		 */

		return responseResult;

	}

	@Override
	public ResponseCartUsuario obtenerCarritoPorUsuario(String idUsuario) {

		ResponseCartUsuario responseResult = new ResponseCartUsuario();

		Notification noti = new Notification();

		try {
			String url = this.hostStock + "/shopping/obtener-cart-usuario?idusuario=" + idUsuario;
			URI uri = new URI(url);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("multishop-APP");
			noti.setRequest("idusuario=" + idUsuario);

			noti.setAccion("obtenerCarritoPorUsuario");
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<List<CarritoDetalle>> response = null;
			try {
				response = restTemplate.exchange(uri, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<CarritoDetalle>>() {
						});
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
				noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
				/*
				 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
				 * System.err.println(result.getError().getCode() + " " +
				 * result.getError().getMenssage()); }
				 */

				return responseResult;
			}

			if (response.getStatusCodeValue() == 200) {
				responseResult.setCode(response.getStatusCodeValue());
				responseResult.setStatus(true);
				responseResult.setCartDetalle(response.getBody());
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
		noti.setFecha_fin(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
		/*
		 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
		 * System.err.println(result.getError().getCode() + " " +
		 * result.getError().getMenssage()); }
		 */

		return responseResult;

	}

	@Override
	public ResponseHistoryEstadoCart obtenerEstadoCarrito(int id) {

		ResponseHistoryEstadoCart responseResult = new ResponseHistoryEstadoCart();
		Notification noti = new Notification();

		try {
			String url = this.hostStock + "/shopping/obtener-estado-cart?id=" + id;
			URI uri = new URI(url);
			noti.setFecha_inicio(FormatearFechas.obtenerFechaPorFormato("yyyy-MM-dd hh:mm:ss"));
			noti.setClass_id("multishop-APP");
			noti.setRequest("id=" + id);
			noti.setAccion("obtenerEstadoCarrito");
			noti.setId(UUID.randomUUID().toString());
			ResponseEntity<ShoppingHistoryEstado> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					ShoppingHistoryEstado.class);

			if (response.getStatusCodeValue() == 200) {

				responseResult.setStatus(true);
				responseResult.setEstado(response.getBody());
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
		/*
		 * ResponseResultado result = guardarLog(noti); if (!result.isStatus()) {
		 * System.err.println(result.getError().getCode() + " " +
		 * result.getError().getMenssage()); }
		 */

		return responseResult;

	}

	@Override
	public ResponseListaTipoDoc listadoTipoDocumento() {
		ResponseListaTipoDoc responseResult = new ResponseListaTipoDoc();

		try {

			String url = this.hostReursosHumanos + "/parametros/tipo-documento";

			URI uri = new URI(url);
			ResponseEntity<List<TipoDocumento>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<TipoDocumento>>() {
					});

			if (response.getStatusCodeValue() == 200) {

				responseResult.setStatus(true);
				responseResult.setDocumento(response.getBody());

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
	public ResponseResultado deleteCarById(String id) {
		ResponseResultado responseResult = new ResponseResultado();

		Notification noti = new Notification();

		try {
			String url = this.hostStock + "/shopping/delete/cart?id=" + id;
			URI uri = new URI(url);

			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.PUT, null, String.class);

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

		return responseResult;

	}

	@Override
	public ResponsePreguntaRespuesta obtenerPreguntasRespuestas(String idProducto) {
		ResponsePreguntaRespuesta responseResult = new ResponsePreguntaRespuesta();

		try {
			String url = this.hostStock + "/api/preguntas/producto/" + idProducto;

			URI uri = new URI(url);
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);

			if (response.getStatusCodeValue() == 200) {
				// Crear y configurar el ObjectMapper
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.setDateFormat(new SimpleDateFormat("MMM dd, yyyy, h:mm:ss a", Locale.ENGLISH));

				// Definir el tipo de colección (List<PreguntaRespuesta>)
				CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class,
						PreguntaRespuesta.class);

				// Deserializar la respuesta JSON
				List<PreguntaRespuesta> preguntasRespuestas = objectMapper.readValue(response.getBody(), listType);

				// Configurar la respuesta final
				responseResult.setCode(response.getStatusCodeValue());
				responseResult.setStatus(true);
				responseResult.setPreguntasRespuestas(preguntasRespuestas);
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {
			ErrorState data = new ErrorState();
			data.setCode(e.getStatusCode().value());
			data.setMenssage(e.getMessage());
			responseResult.setCode(data.getCode());
			responseResult.setError(data);

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return responseResult;
	}

	@Override
	public ResponseResultado enviarPregunta(String idProducto, String idUsuarioPregunta, String pregunta) {
		ResponseResultado responseResultado = new ResponseResultado();
		try {
			String url = this.hostStock + "/api/preguntas/guardar";

			// Crear el objeto DTO que se enviará
			Map<String, String> preguntaDTO = new HashMap<>();
			preguntaDTO.put("idProducto", idProducto);
			preguntaDTO.put("idUsuarioPregunta", idUsuarioPregunta);
			preguntaDTO.put("pregunta", pregunta);

			// Crear la solicitud HTTP con el body
			HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(preguntaDTO);

			// Realizar la solicitud POST
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

			if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
				// Manejar respuesta exitosa
				responseResultado.setCode(response.getStatusCodeValue());
				responseResultado.setStatus(true);
				responseResultado.setResultado("Pregunta enviada con éxito");
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {
			// Manejar errores del servidor
			responseResultado.setCode(e.getStatusCode().value());
			responseResultado.setStatus(false);
			responseResultado.setResultado("Error en el servidor al enviar la pregunta: " + e.getMessage());

		} catch (Exception e) {
			// Manejar excepciones generales
			responseResultado.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseResultado.setStatus(false);
			responseResultado.setResultado("Error inesperado: " + e.getMessage());
		}

		return responseResultado;
	}

	@Override
	public ResponseResultado enviarRespuesta(int idPregunta, String idUsuarioRespuesta, String respuesta) {
		ResponseResultado responseResultado = new ResponseResultado();
		try {
			String url = this.hostStock + "/api/preguntas/responder";

			// Crear el objeto DTO que se enviará
			Map<String, Object> respuestaDTO = new HashMap<>();
			respuestaDTO.put("idPregunta", idPregunta);
			respuestaDTO.put("idUsuarioRespuesta", idUsuarioRespuesta);
			respuestaDTO.put("respuesta", respuesta);

			// Crear la solicitud HTTP con el body
			HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(respuestaDTO);

			// Realizar la solicitud POST
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

			if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
				// Manejar respuesta exitosa
				responseResultado.setCode(response.getStatusCodeValue());
				responseResultado.setStatus(true);
				responseResultado.setResultado("Respuesta enviada con éxito");
			}

		} catch (org.springframework.web.client.HttpServerErrorException e) {
			// Manejar errores del servidor
			responseResultado.setCode(e.getStatusCode().value());
			responseResultado.setStatus(false);
			responseResultado.setResultado("Error en el servidor al enviar la respuesta: " + e.getMessage());

		} catch (Exception e) {
			// Manejar excepciones generales
			responseResultado.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseResultado.setStatus(false);
			responseResultado.setResultado("Error inesperado: " + e.getMessage());
		}

		return responseResultado;
	}

	@Cacheable(cacheNames = "productosRelacionados")
	@Override
	public ResponseListaProductos cargarProductosRelacionados(int idTipoProducto, int idCategoriaProducto) {
		ResponseListaProductos responseResult = new ResponseListaProductos();

		try {

			String url = this.hostStock + "/productos/productos-relacionados?idTipoProducto=" + idTipoProducto
					+ "&idCategoriaProducto=" + idCategoriaProducto;

			URI uri = new URI(url);

			ResponseEntity<List<Producto>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Producto>>() {
					});

			if (response.getStatusCodeValue() == 200) {
				responseResult.setCode(response.getStatusCodeValue());
				responseResult.setStatus(true);
				responseResult.setProductos(response.getBody());

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

	@Cacheable(cacheNames = "listadoFormasPagos")
	@Override
	public ResponseListaFormasCobro listaFormasCobros() {
		ResponseListaFormasCobro responseResult = new ResponseListaFormasCobro();

		try {

			String url = ValidarPagoServiceImpl.terminal + "/parametros/formas-cobros";
			URI uri = new URI(url);

			ResponseEntity<List<FormasCobro>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<FormasCobro>>() {
					});

			if (response.getStatusCodeValue() == 200) {

				responseResult.setStatus(true);
				responseResult.setFormasCobro(response.getBody());

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
