package com.digital.devs.service;

import java.util.List;
import java.util.Optional;

import com.digital.devs.model.Paciente;

public interface IPacienteService {
	
	List<Paciente> listar();
	Optional<Paciente> listarPorId(Integer id);	
	Paciente registrar(Paciente per);
	Paciente modificar(Paciente per);
	void eliminar(Paciente per);
	
	

}
