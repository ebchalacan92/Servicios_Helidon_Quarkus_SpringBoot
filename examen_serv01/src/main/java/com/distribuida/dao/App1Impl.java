package com.distribuida.dao;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.dto.App1Dto;
import com.distribuida.dto.App2Dto;
import com.distribuida.proxy.CustomerProxyImpl;


@ApplicationScoped
public class App1Impl implements App1Dao{
	@Inject										//Injectamos la clase Entity Manager para obtener los métodos del CRUD de JPA
	private CustomerProxyImpl servicioCliente;
	@Inject private EntityManager em;
	
	@Override
	public List<App1Dto> findAll(){
		List<App1Dto> listTipoDireccion;
		listTipoDireccion = em.createQuery("SELECT t FROM App1Dto t", App1Dto.class).getResultList();
		return listTipoDireccion;
	}
	
	@Override
	public App1Dto findById(Integer id) {
		List<App1Dto> tipoDireccion;
		tipoDireccion = em.createQuery("SELECT t FROM App1Dto t WHERE id = :id", App1Dto.class).setParameter("id", id).getResultList();
		return tipoDireccion.get(0);
	}

	@Override
	public App1Dto guardar(App1Dto persona) {
		em.getTransaction().begin();
		em.persist(persona);
		em.getTransaction().commit();
		return persona;
	}

	@Override
	public App1Dto editar(App1Dto persona) {
		em.getTransaction().begin();
		em.merge(persona);
		em.getTransaction().commit();
		return persona;
	}

	@Override
	public void eliminar(Integer id) {
		em.getTransaction().begin();
		App1Dto persona = em.createQuery("SELECT u FROM App1Dto u WHERE id = :id", App1Dto.class).setParameter("id", id).getResultList().get(0);
		em.remove(persona);
		em.getTransaction().commit();
	}

	@Override
	public List<App1Dto> listarDatosCombinados() {
		List<App1Dto> listaPersonas = findAll();
		List<App2Dto> listaDireccion = findDireccion();
		List<App1Dto> lista = new ArrayList<>();
		for (App1Dto personas : listaPersonas) {
			for (App2Dto direciones : listaDireccion) {
				if (personas.getId() == direciones.getId()) {
					personas.datosDireccion = (direciones.getDescripcion());
					lista.add(personas);
				}
			}
		}
		return lista;
	}

	@Override
	public List<App2Dto> findDireccion() {
		return servicioCliente.obtenerCustomer();
		
	}

	@Override
	public List<App1Dto> listarPorId(int id) {
		List<App1Dto> listaPersonas = findAll();
		List<App1Dto> lista = new ArrayList<>();
		for (App1Dto personas : listaPersonas) {
			if (personas.getId().equals(id)) {
				System.out.println(id + "," + personas.getId());
				lista.add(personas);
			} else {
				System.out.println("vacio");
			}
		}
		return lista;
	}
}
