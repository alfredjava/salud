package com.digital.devs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.devs.model.Recordatorio;

public interface IRecordatorioDAO extends JpaRepository<Recordatorio, Integer>{

}
