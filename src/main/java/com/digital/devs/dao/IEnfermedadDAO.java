package com.digital.devs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digital.devs.model.Enfermedad;

public interface IEnfermedadDAO extends JpaRepository<Enfermedad, Integer>{
	@Query("select m from Enfermedad m where m.id in(select pm.enfermedad.id from PacienteEnfermedad pm where pm.paciente.id=:idPaciente)")
	public List<Enfermedad> findEnfermedadByPaciente(Integer idPaciente);
}
