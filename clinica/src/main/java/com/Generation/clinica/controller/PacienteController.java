package com.Generation.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Generation.clinica.model.Paciente;
import com.Generation.clinica.repository.PacienteRepository;

@RestController
@RequestMapping("/paciente")
@CrossOrigin("*")
public class PacienteController {
	
	@Autowired
	private PacienteRepository repositorypaciente;
	
	
	@GetMapping("/{codPaciente}")
	public ResponseEntity <Paciente> 
	GetById(@PathVariable long codPaciente){
		return repositorypaciente.findById(codPaciente).
		map(resp->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<Paciente>> getAll(){
		return ResponseEntity.ok(repositorypaciente.findAll());
	}
		
	
	@PostMapping
	public ResponseEntity<Paciente> post(@RequestBody Paciente paciente){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorypaciente.save(paciente));
	}
	
	@PutMapping
	public ResponseEntity<Paciente> put(@RequestBody Paciente paciente){
		return ResponseEntity.status(HttpStatus.OK).body(repositorypaciente.save(paciente));
	}
	
	@DeleteMapping("/{codPaciente}")
	public void delete(@PathVariable long codPaciente) {
		repositorypaciente.deleteById(codPaciente);                                  
	}

}
