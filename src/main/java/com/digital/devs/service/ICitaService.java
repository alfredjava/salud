package com.digital.devs.service;

import java.util.List;
import java.util.Optional;

import com.digital.devs.model.Cita;

public interface ICitaService {
	
	List<Cita> listar();
	Optional<Cita> listarPorId(Integer id);	
	Cita registrar(Cita per);
	Cita modificar(Cita per);
	void eliminar(Cita per);
	public List<Cita> listarPorIdPaciente(Integer id);
	List<Cita> listarByPacienteDia(Integer id, String dia);
	

}
