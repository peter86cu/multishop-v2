package com.online.multishop;



import javax.net.ssl.SSLContext;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientSslConfiguration {
	
	   @Value("${client.ssl.key-store}")
	    private Resource trustStore;
	    @Value("${client.ssl.key-store-password}")
	    private String trustStorePassword;
	    String protocol = "TLSv1.2";
	    
	    
	    @Bean
	    RestTemplate restTemplate() throws Exception {
	        SSLContext sslContext = new SSLContextBuilder()
	                .loadTrustMaterial(
	                        trustStore.getURL(),
	                        trustStorePassword.toCharArray()
	                ).build();
	        
	        
	        SSLConnectionSocketFactory socketFactory =
	                new SSLConnectionSocketFactory(sslContext);
	        
	        HttpClient httpClient = HttpClients.custom()
	                .setSSLSocketFactory(socketFactory).build();
	        
	        HttpComponentsClientHttpRequestFactory factory =
	                new HttpComponentsClientHttpRequestFactory(httpClient);
	        
	        return new RestTemplate(factory);
	    }

	
	/* @Bean
	    public TomcatServletWebServerFactory servletContainer() {
	        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
	            @Override
	            protected void postProcessContext(Context context) {
	                SecurityConstraint securityConstraint = new SecurityConstraint();
	                securityConstraint.setUserConstraint("CONFIDENTIAL");
	                SecurityCollection collection = new SecurityCollection();
	                collection.addPattern("/*");
	                securityConstraint.addCollection(collection);
	                context.addConstraint(securityConstraint);
	            }
	        };
	        tomcat.addAdditionalTomcatConnectors(getHttpConnector());
	        return tomcat;
	    }

	    private Connector getHttpConnector() {
	        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
	        connector.setScheme("http");
	        connector.setPort(8080);
	        connector.setSecure(false);
	        connector.setRedirectPort(8443);
	        return connector;
	    }*/
}
