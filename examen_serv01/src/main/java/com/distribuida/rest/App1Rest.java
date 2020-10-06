package com.distribuida.rest;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dao.App1Dao;
import com.distribuida.dto.App1Dto;
import com.distribuida.dto.App2Dto;


@Path("/app1")
@ApplicationScoped
public class App1Rest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject private App1Dao app1Service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<App1Dto> buscarTodos(){
		return app1Service.findAll();	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public App1Dto buscarID(@PathParam(value="id") Integer id){
		return app1Service.findById(id);	
	}
	
	@POST
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public App1Dto guardar(App1Dto persona){
		return app1Service.guardar(persona);
	}
	
	@DELETE
	@Path("/{id}")
	public void eliminar(@PathParam(value = "id") Integer id) {
		app1Service.eliminar(id);
	}
	
	@PUT
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public App1Dto editar(App1Dto persona){
		return app1Service.editar(persona);
	}
	
	@Path("/listar")
	@GET 										// asigna al método HTTP GET.(Lista los datos de orders y customers)
	@Produces(value = MediaType.APPLICATION_JSON) // determina el tipo de contenido que devuleve el servidor
	public List<App1Dto> listarDatosCombinados(){ // Método Listar todos los pedidos
		return app1Service.listarDatosCombinados();
	}
	
	@Path("listar/{id}")
	@GET 										// asigna al método HTTP GET. (Busca por id ; devuelve una lista )
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<App1Dto> listarPorId(@PathParam("id") Integer id) { // Método de buscar pedidos por id
		return app1Service.listarPorId(id);
				
	}
	
	@GET
	@Path("/direccion")
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<App2Dto> listarDireccion() { // Método de buscar pedidos por id
		return app1Service.findDireccion();
				
	}
	
	@GET
	@Path(value = "/ping")
	@Produces(value=MediaType.TEXT_PLAIN)
	public String ping() {
		//System.out.println("ping");
		return "ok";
	}
	
}
