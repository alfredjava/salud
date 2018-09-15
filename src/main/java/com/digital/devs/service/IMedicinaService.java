package com.digital.devs.service;

import java.util.List;
import java.util.Optional;

import com.digital.devs.model.Medicina;

public interface IMedicinaService {
	
	List<Medicina> listar();
	Optional<Medicina> listarPorId(Integer id);	
	Medicina registrar(Medicina per);
	Medicina modificar(Medicina per);
	void eliminar(Medicina per);	
	public List<Medicina> listarPorIdPaciente(Integer id);

}
