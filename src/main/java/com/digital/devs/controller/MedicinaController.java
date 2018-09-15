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

import com.digital.devs.model.Medicina;
import com.digital.devs.service.IMedicinaService;



@RestController
@RequestMapping(value = "/medicinas")
public class MedicinaController {

	@Autowired
	private IMedicinaService service;
	
	@GetMapping
	public List<Medicina> listar(){
		return service.listar();
	}
	
	@GetMapping(value = "/{id}")
	public Medicina listarPorId(@PathVariable("id") Integer id){
		Optional<Medicina> op = service.listarPorId(id);
		return op.isPresent() ? op.get() : new Medicina();
	}

	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Medicina registrar(@RequestBody Medicina persona) {
		return service.registrar(persona);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Medicina modificar(@RequestBody Medicina persona) {
		return service.modificar(persona);
	}

	@DeleteMapping(value = "/{id}")
	public Integer eliminar(@PathVariable("id") Integer id) {
		Optional<Medicina> opt = service.listarPorId(id);
		if (opt.isPresent()) {
			Medicina per = new Medicina();
			per.setId(id);
			service.eliminar(per);
			return 1;
		}
		return 0;
	}
	
	@GetMapping(value = "paciente/{id}")
	public List<Medicina> listarPorIdPaciente(@PathVariable("id") Integer id){		
		return service.listarPorIdPaciente(id);
	}
}
