package com.digital.devs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.devs.model.Paciente;
import com.digital.devs.model.PacienteMedicina;

public interface IPacienteMedicinaDAO extends JpaRepository<PacienteMedicina, Integer>{
	public List<PacienteMedicina> findByPaciente(Paciente paciente);

}
