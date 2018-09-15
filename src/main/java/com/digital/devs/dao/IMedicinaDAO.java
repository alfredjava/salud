package com.digital.devs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digital.devs.model.Medicina;

public interface IMedicinaDAO extends JpaRepository<Medicina, Integer>{
	@Query("select m from Medicina m where m.id in(select pm.medicina.id from PacienteMedicina pm where pm.paciente.id=:idPaciente)")
	public List<Medicina> findMedicinaByPaciente(Integer idPaciente);
	
}
