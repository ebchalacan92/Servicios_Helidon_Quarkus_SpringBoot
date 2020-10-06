package com.distribuida.proxyproducer;

import java.net.URI;
import java.net.URISyntaxException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;


import org.eclipse.microprofile.rest.client.RestClientBuilder;

import com.distribuida.proxy.PersonaProxy;

@ApplicationScoped
public class ProxyPersonasProducer {
	

	@Produces							//Método productor 
	@ApplicationScoped
	public PersonaProxy getProxy() throws URISyntaxException {		//indica la excepción que una cadena no se pudo analizar como una referencia de URI.
		PersonaProxy remoteApi = RestClientBuilder.newBuilder()	//De acuerdo a la documentación de esta manera se maneja los proxy cuando se trata de conexión entre microservicios
		        .baseUri(new URI("http://127.0.0.1:7001/app1")) //Colocamos la URI que hace referencia al servicio customer
		        .build(PersonaProxy.class);
		
		 return remoteApi;
	}

}
