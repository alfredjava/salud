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

import com.digital.devs.model.Paciente;
import com.digital.devs.service.IPacienteService;



@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {

	@Autowired
	private IPacienteService service;
	
	@GetMapping
	public List<Paciente> listar(){
		return service.listar();
	}
	
	@GetMapping(value = "/{id}")
	public Paciente listarPorId(@PathVariable("id") Integer id){
		Optional<Paciente> op = service.listarPorId(id);
		return op.isPresent() ? op.get() : new Paciente();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Paciente registrar(@RequestBody Paciente persona) {
		return service.registrar(persona);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Paciente modificar(@RequestBody Paciente persona) {
		return service.modificar(persona);
	}

	@DeleteMapping(value = "/{id}")
	public Integer eliminar(@PathVariable("id") Integer id) {
		Optional<Paciente> opt = service.listarPorId(id);
		if (opt.isPresent()) {
			Paciente per = new Paciente();
			per.setId(id);
			service.eliminar(per);
			return 1;
		}
		return 0;
	}
	
}
