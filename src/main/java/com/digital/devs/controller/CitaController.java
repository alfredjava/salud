package com.digital.devs.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.devs.model.Cita;
import com.digital.devs.service.ICitaService;



@RestController
@RequestMapping(value = "/citas")
public class CitaController {

	@Autowired
	private ICitaService service;
	
	@GetMapping
	public List<Cita> listar(){
		return service.listar();
	}
	
	@GetMapping(value = "/{id}")
	public Cita listarPorId(@PathVariable("id") Integer id){
		Optional<Cita> op = service.listarPorId(id);
		return op.isPresent() ? op.get() : new Cita();
	}
	@GetMapping(value = "paciente/{id}")
	public List<Cita> listarByPaciente(@PathVariable("id") Integer id){
		return service.listarPorIdPaciente(id);
	}
	@GetMapping(value = "paciente/{id}/{dia}")
	public List<Cita> listarByPacienteDia(@PathVariable("id") Integer id,
			@PathVariable("dia") String dia){
		return service.listarByPacienteDia(id,dia);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cita registrar(@RequestBody Cita persona) {
		return service.registrar(persona);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cita modificar(@RequestBody Cita persona) {
		return service.modificar(persona);
	}

	@DeleteMapping(value = "/{id}")
	public Integer eliminar(@PathVariable("id") Integer id) {
		Optional<Cita> opt = service.listarPorId(id);
		if (opt.isPresent()) {
			Cita per = new Cita();
			per.setId(id);
			service.eliminar(per);
			return 1;
		}
		return 0;
	}
	
}
