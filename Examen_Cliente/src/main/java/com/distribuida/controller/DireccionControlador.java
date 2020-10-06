package com.distribuida.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

import com.distribuida.dto.App2Dto;

import com.distribuida.proxy.DireccionProxyImpl;

@Named(value= "direccionControlador")
@SessionScoped
public class DireccionControlador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject	private DireccionProxyImpl direccionServicio;
	
	private List<App2Dto> listaDireccion;
	private List<App2Dto> listaId;
	private int idDireccion;
	private App2Dto direccion;
	
	
	
	

	public DireccionProxyImpl getDireccionServicio() {
		return direccionServicio;
	}

	public void setDireccionServicio(DireccionProxyImpl direccionServicio) {
		this.direccionServicio = direccionServicio;
	}

	public List<App2Dto> getListaDireccion() {
		return listaDireccion;
	}

	public void setListaDireccion(List<App2Dto> listaDireccion) {
		this.listaDireccion = listaDireccion;
	}

	public List<App2Dto> getListaId() {
		return listaId;
	}

	public void setListaId(List<App2Dto> listaId) {
		this.listaId = listaId;
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public App2Dto getDireccion() {
		return direccion;
	}

	public void setDireccion(App2Dto direccion) {
		this.direccion = direccion;
	}

	@PostConstruct
	public void init() {
		direccion = new App2Dto();
		listaDireccion = direccionServicio.obtenerDireccion();
	}

	public String listarDireccion() {
		listaDireccion = direccionServicio.obtenerDireccion();
		return "listarDireccion?faces-redirect=true";
	}
	
	public String buscarDireccion(App2Dto direcc) {
		direccion = direcc;
		return "editarDireccion?faces-redirect=true";
	}
	public String eliminarDireccion(int id) {
		direccionServicio.eliminarDireccion(id);
		listaDireccion = direccionServicio.obtenerDireccion();
		return "listarDireccion?faces-redirect=true";
	}
	public String crearDireccion() {
		direccion.setId(null);
		direccionServicio.insertarDireccion(direccion);
		direccion = new App2Dto();
		listaDireccion = direccionServicio.obtenerDireccion();
		return "listarDireccion?faces-redirect=true";
	}
	public String editarDireccion() {
		direccionServicio.actualizarDireccion(direccion);
		direccion = new App2Dto();
		return "listarDireccion?faces-redirect=true";
	}
	public String listarId() {
		listaDireccion = direccionServicio.listarPorId(idDireccion);
		return "listarDireccion?faces-redirect=true";
	}
}
