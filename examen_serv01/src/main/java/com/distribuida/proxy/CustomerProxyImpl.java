package com.distribuida.proxy;

import java.net.URI;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


import com.distribuida.dto.App2Dto;


@ApplicationScoped
public class CustomerProxyImpl{
	
	
	@Inject private CustomerProxy proxy;

	public List<App2Dto> obtenerCustomer(){
		return proxy.buscarTodos();
	}
	
	/*public Customer buscarCustomer(Long id) {
		return proxy.buscarCustomer(id);
	}
	
	public void eliminarCustomer(Long id) {
		proxy.eliminarCustomer(id);
	}
	
	public Customer insertarCustomer(Customer custom) {
		return proxy.insertarCustomer(custom);
	}
	
	public Customer actualizarCustomer(Customer custom) {
		return proxy.actualizarCustomer(custom);
	}*/
}
