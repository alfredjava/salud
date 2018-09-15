package com.digital.devs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paciente_medicina")
public class PacienteMedicina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne 
	@JoinColumn(name="id_paciente")
	private Paciente paciente;
	
	@OneToOne 
	@JoinColumn(name="id_medicina")
	private Medicina medicina;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medicina getMedicina() {
		return medicina;
	}
	public void setMedicina(Medicina medicina) {
		this.medicina = medicina;
	}
}
