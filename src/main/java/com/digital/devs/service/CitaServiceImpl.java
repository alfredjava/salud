package com.digital.devs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.devs.dao.ICitaDAO;
import com.digital.devs.model.Cita;
import com.digital.devs.model.Paciente;

@Service
public class CitaServiceImpl implements ICitaService {

	@Autowired
	private ICitaDAO dao;

	@Override
	public List<Cita> listar() {
		return dao.findAll();
	}

	@Override
	public Optional<Cita> listarPorId(Integer id) {		
		return dao.findById(id);
	}

	@Override
	public Cita registrar(Cita per) {
		return dao.save(per);
	}

	@Override
	public Cita  modificar(Cita per) {
		Optional<Cita> persona = dao.findById(per.getId());
		
		if (persona.isPresent()) {
			return dao.save(per);
		}
		return new Cita();
	}

	@Override
	public void eliminar(Cita per) {
		dao.delete(per);
	}

	@Override
	public List<Cita> listarPorIdPaciente(Integer id) {
		Paciente p=new Paciente();
		p.setId(id);
		return dao.findByPaciente(p);
	}

	@Override
	public List<Cita> listarByPacienteDia(Integer id, String dia) {
		Paciente p=new Paciente();
		p.setId(id);
		return dao.findByPacienteAndFecha(p,dia);
	}
}
