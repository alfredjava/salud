package com.digital.devs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.devs.model.Paciente;

public interface IPacienteDAO extends JpaRepository<Paciente, Integer>{

}
