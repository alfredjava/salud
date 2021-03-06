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

import com.digital.devs.model.Recordatorio;
import com.digital.devs.service.IRecordatorioService;



@RestController
@RequestMapping(value = "/recordatorios")
public class RecordatorioController {

	@Autowired
	private IRecordatorioService service;
	
	@GetMapping
	public List<Recordatorio> listar(){
		return service.listar();
	}
	@GetMapping(value = "paciente/{id}/{dia}")
	public List<Recordatorio> listarByPaciente(@PathVariable("id") Integer id,
			@PathVariable("dia") String dia){
		return service.listarByPaciente(id,dia);
	}
	
	@GetMapping(value = "paciente/{id}")
	public List<Recordatorio> listarByPaciente(@PathVariable("id") Integer id){
		return service.listarByPacienteID(id);
	}
	
	@GetMapping(value = "/{id}")
	public Recordatorio listarPorId(@PathVariable("id") Integer id){
		Optional<Recordatorio> op = service.listarPorId(id);
		return op.isPresent() ? op.get() : new Recordatorio();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Recordatorio registrar(@RequestBody Recordatorio persona) {
		return service.registrar(persona);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Recordatorio modificar(@RequestBody Recordatorio persona) {
		return service.modificar(persona);
	}

	@DeleteMapping(value = "/{id}")
	public Integer eliminar(@PathVariable("id") Integer id) {
		Optional<Recordatorio> opt = service.listarPorId(id);
		if (opt.isPresent()) {
			Recordatorio per = new Recordatorio();
			per.setId(id);
			service.eliminar(per);
			return 1;
		}
		return 0;
	}
	
	
}
