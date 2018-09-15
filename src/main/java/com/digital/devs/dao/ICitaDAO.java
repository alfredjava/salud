package com.digital.devs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.devs.model.Cita;
import com.digital.devs.model.Paciente;

public interface ICitaDAO extends JpaRepository<Cita, Integer>{
	public List<Cita> findByPaciente(Paciente paciente);
	public List<Cita> findByPacienteAndFecha(Paciente paciente,String fecha);
}
