package com.digital.devs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.devs.dao.IMedicinaDAO;
import com.digital.devs.model.Medicina;

@Service
public class MedicinaServiceImpl implements IMedicinaService {

	@Autowired
	private IMedicinaDAO dao;
	@Override
	public List<Medicina> listar() {
		return dao.findAll();
	}

	@Override
	public Optional<Medicina> listarPorId(Integer id) {		
		return dao.findById(id);
	}

	@Override
	public Medicina registrar(Medicina per) {
		return dao.save(per);
	}

	@Override
	public Medicina  modificar(Medicina per) {
		Optional<Medicina> persona = dao.findById(per.getId());
		
		if (persona.isPresent()) {
			return dao.save(per);
		}
		return new Medicina();
	}

	@Override
	public void eliminar(Medicina per) {
		dao.delete(per);
	}

	@Override
	public List<Medicina> listarPorIdPaciente(Integer idPaciente) {
		// TODO Auto-generated method stub
		return dao.findMedicinaByPaciente(idPaciente);
	}


}
