package com.digital.devs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.devs.dao.IPacienteDAO;
import com.digital.devs.dao.IPacienteMedicinaDAO;
import com.digital.devs.model.Paciente;

@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteDAO dao;
	@Autowired
	private IPacienteMedicinaDAO iPacienteMedicinaDAO;

	@Override
	public List<Paciente> listar() {
		return dao.findAll();
	}

	@Override
	public Optional<Paciente> listarPorId(Integer id) {		
		return dao.findById(id);
	}

	@Override
	public Paciente registrar(Paciente per) {
		return dao.save(per);
	}

	@Override
	public Paciente  modificar(Paciente per) {
		Optional<Paciente> persona = dao.findById(per.getId());
		
		if (persona.isPresent()) {
			return dao.save(per);
		}
		return new Paciente();
	}

	@Override
	public void eliminar(Paciente per) {
		dao.delete(per);
	}

}
