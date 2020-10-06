package com.distribuida.proxy;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.dto.App2Dto;


@ApplicationScoped
public class DireccionProxyImpl{

	@Inject private DireccionProxy proxy;

	public List<App2Dto> obtenerDireccion(){
		return proxy.buscarTodos();
	}
	
	public App2Dto buscarDireccion(int id) {
		return proxy.buscarID(id);
	}
	
	public void eliminarDireccion(int id) {
		proxy.eliminar(id);
	}
	
	public App2Dto insertarDireccion(App2Dto custom) {
		return proxy.guardar(custom);
	}
	
	public App2Dto actualizarDireccion(App2Dto custom) {
		return proxy.editar(custom);
	}
	
	public List<App2Dto> listarPorId(int id){
		return proxy.listarPorId(id);
	}
}
