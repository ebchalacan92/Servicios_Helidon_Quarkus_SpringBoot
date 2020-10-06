package com.distribuida.proxyproducer;

import java.net.URI;
import java.net.URISyntaxException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.distribuida.proxy.DireccionProxy;
import org.eclipse.microprofile.rest.client.RestClientBuilder;



@ApplicationScoped
public class ProxyDireccionProducer {
	
	@Produces							//M�todo productor 
	@ApplicationScoped
	public DireccionProxy getProxy() throws URISyntaxException {		//indica la excepci�n que una cadena no se pudo analizar como una referencia de URI.
		DireccionProxy remoteApi = RestClientBuilder.newBuilder()	//De acuerdo a la documentaci�n de esta manera se maneja los proxy cuando se trata de conexi�n entre microservicios
		        .baseUri(new URI("http://127.0.0.1:8080/app2")) //Colocamos la URI que hace referencia al servicio customer
		        .build(DireccionProxy.class);
		
		 return remoteApi;
	}
	
	
	
}
