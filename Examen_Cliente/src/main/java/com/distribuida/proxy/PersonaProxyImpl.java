package com.distribuida.proxy;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.dto.App1Dto;


@ApplicationScoped
public class PersonaProxyImpl {
	@Inject private PersonaProxy proxy;

	public List<App1Dto> obtenerPedidos(){
		return proxy.buscarTodos();
	}
	
	public App1Dto buscarPorId(int id) {
		return proxy.buscarID(id);
	}
	
	public void eliminarPedidos(int id) {
		proxy.eliminar(id);
	}
	
	public App1Dto crearPedidos(App1Dto pedidos) {
		return proxy.guardar(pedidos);
	}
	
	public App1Dto editarPedidos(App1Dto pedidos) {
		return proxy.editar(pedidos);
	}
	
	public List<App1Dto> listarDatosCombinados(){
		return proxy.listarDatosCombinados();
	}
	
	public List<App1Dto> listarPorId(int id){
		return proxy.listarPorId(id);
	}
}
