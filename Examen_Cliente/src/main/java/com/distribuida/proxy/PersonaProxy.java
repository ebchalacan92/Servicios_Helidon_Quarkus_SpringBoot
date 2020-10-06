package com.distribuida.proxy;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dto.App1Dto;


public interface PersonaProxy {
	@GET
	@Consumes(value = MediaType.APPLICATION_JSON)
	public List<App1Dto> buscarTodos();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public App1Dto guardar(App1Dto persona);
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void eliminar(@PathParam(value = "id") Integer id);
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public App1Dto editar(App1Dto persona);
	
	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public App1Dto buscarID(@PathParam(value="id") Integer id);
	
	@Path("/listar")
	@GET 
	@Produces(value = MediaType.APPLICATION_JSON) 
	public List<App1Dto> listarDatosCombinados();
	
	@Path("listar/{id}")
	@GET 
	@Produces(value = MediaType.APPLICATION_JSON) 
	public List<App1Dto> listarPorId(@PathParam("id") Integer id);
	

}
