package com.distribuida.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "app1")
@Table(name = "persona")
public class App1Dto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "cedula")
	private Integer cedula;
	
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "tipo_direccion")
	private Integer tipoDireccion;
	@Column(name = "nombre")
	private String nombre;
	
	@Transient							//No toma en cuenta a la hora de la persistencia en los datoss, pero sirve para recolectar un conjunto de datos personalizado
	public String datosDireccion;

	@XmlElement
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement
	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer descripcion) {
		this.cedula = descripcion;
	}
	@XmlElement
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@XmlElement
	public Integer getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(Integer tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}
	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDatosDireccion() {
		return datosDireccion;
	}

	public void setDatosDireccion(String datosDireccion) {
		this.datosDireccion = datosDireccion;
	}

	
	
}
