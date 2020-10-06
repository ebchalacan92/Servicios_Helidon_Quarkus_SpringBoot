package com.distribuida.dao;

import java.util.List;

import com.distribuida.dto.App1Dto;
import com.distribuida.dto.App2Dto;

public interface App1Dao {

	List<App1Dto> findAll();
	App1Dto findById(Integer id);
	
	
	App1Dto guardar(App1Dto direccion);
	
	App1Dto editar(App1Dto direccion);
	
	void eliminar(Integer id);
	
	public List<App1Dto> listarPorId(int id);
	 
	public  List<App1Dto> listarDatosCombinados();
	
	List<App2Dto> findDireccion();
	
	

	
}
