package com.digital.devs.service;

import java.util.List;
import java.util.Optional;

import com.digital.devs.model.Enfermedad;

public interface IEnfermedadService {
	
	List<Enfermedad> listar();
	Optional<Enfermedad> listarPorId(Integer id);	
	Enfermedad registrar(Enfermedad per);
	Enfermedad modificar(Enfermedad per);
	void eliminar(Enfermedad per);
	List<Enfermedad> listarPorIdPaciente(Integer id);

}
