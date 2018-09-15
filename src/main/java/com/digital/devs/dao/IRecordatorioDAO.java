package com.digital.devs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.devs.model.Paciente;
import com.digital.devs.model.Recordatorio;

public interface IRecordatorioDAO extends JpaRepository<Recordatorio, Integer>{
	public List<Recordatorio> findByPacienteAndDia(Paciente paciente,String dia);
	public List<Recordatorio> findByPaciente(Paciente paciente);
}
