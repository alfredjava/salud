package com.digital.devs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "medicina_principio")
public class MedicinaPrincipio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne 
	@JoinColumn(name="id_medicina")
	private Medicina medicina;
	
	@OneToOne 
	@JoinColumn(name="id_pricipio")
	private PrincipioActivo principioActivo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Medicina getMedicina() {
		return medicina;
	}

	public void setMedicina(Medicina medicina) {
		this.medicina = medicina;
	}

	public PrincipioActivo getPrincipioActivo() {
		return principioActivo;
	}

	public void setPrincipioActivo(PrincipioActivo principioActivo) {
		this.principioActivo = principioActivo;
	}
	
	
}
