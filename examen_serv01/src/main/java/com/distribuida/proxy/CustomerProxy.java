package com.distribuida.proxy;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import com.distribuida.dto.App2Dto;


public interface CustomerProxy {
	
	@GET
	@Consumes(value = MediaType.APPLICATION_JSON)
	public List<App2Dto> buscarTodos();
	
	/*@POST
	@Path("/añadir")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer insertarCustomer(Customer custom);
	
	@DELETE
	@Path("/eliminar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String eliminarCustomer(@PathParam ("id") Long id);
	
	@PUT
	@Path("/actualizar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Customer actualizarCustomer(Customer custom);
	
	@GET @Path("/buscar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Customer buscarCustomer(@PathParam ("id") Long id);*/
	
}
