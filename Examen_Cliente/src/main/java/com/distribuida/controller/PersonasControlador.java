package com.distribuida.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.dto.App1Dto;
import com.distribuida.proxy.PersonaProxyImpl;

@Named(value= "personasControlador")
@SessionScoped
public class PersonasControlador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject	private PersonaProxyImpl personaServicio;
	
	private List<App1Dto> listaPersonas;
	private List<App1Dto> listaId;
	private App1Dto personas;
	private int idPersona;
		
	

	public PersonaProxyImpl getPersonaServicio() {
		return personaServicio;
	}

	public void setPersonaServicio(PersonaProxyImpl personaServicio) {
		this.personaServicio = personaServicio;
	}

	public List<App1Dto> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<App1Dto> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	public List<App1Dto> getListaId() {
		return listaId;
	}

	public void setListaId(List<App1Dto> listaId) {
		this.listaId = listaId;
	}

	public App1Dto getPersonas() {
		return personas;
	}

	public void setPersonas(App1Dto personas) {
		this.personas = personas;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	@PostConstruct
	public void init() {
		personas = new App1Dto();
	}
	
	public String listarPersonas() {
		listaPersonas = personaServicio.listarDatosCombinados();
		return "listarPersonas?faces-redirect=true";
	}
	public String buscarPorId() {
		personas = personaServicio.buscarPorId(idPersona);
		return "listarPersonas?faces-redirect=true";
	}
	public String buscarPersonas(App1Dto pedid) {
		personas = pedid;
		return "editarPersonas?faces-redirect=true";
	}
	public String eliminarPersonas(int id) {
		personaServicio.eliminarPedidos(id);
		listaPersonas = personaServicio.listarDatosCombinados();
		return "listarPersonas?faces-redirect=true";
	}
	public String crearPersonas() {
		personas.setId(null);
		personaServicio.crearPedidos(personas);
		personas = new App1Dto();
		listaPersonas = personaServicio.listarDatosCombinados();
		return "listarPersonas?faces-redirect=true";
	}
	public String editarPersonas() {
		personaServicio.editarPedidos(personas);
		personas = new App1Dto();
		return "listarPersonas?faces-redirect=true";
	}
	
	public String nuevaLista() {
		listaPersonas = personaServicio.listarDatosCombinados();
		return "listarPersonas?faces-redirect=true";
	}
	
	public String listarId() {
		listaPersonas = personaServicio.listarPorId(idPersona);
		return "listarPersonas?faces-redirect=true";
	}
}
