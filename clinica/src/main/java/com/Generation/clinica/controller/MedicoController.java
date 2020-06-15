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

import com.Generation.clinica.model.Medico;
import com.Generation.clinica.repository.MedicoRepository;


@RestController
@RequestMapping("/medico")
@CrossOrigin("*")
public class MedicoController {

	
	@Autowired
	private MedicoRepository repositoryMedico;
	
	
	@GetMapping("/{crm}")
	public ResponseEntity <Medico> 
	GetById(@PathVariable String crm){
		return repositoryMedico.findById(crm).
		map(resp->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<Medico>> getAll(){
		return ResponseEntity.ok(repositoryMedico.findAll());
	}
		
	@GetMapping("/nomeProduto/{nomeProduto}")
	public ResponseEntity<List<Medico>> GetByName(@PathVariable String nome){
		return ResponseEntity.ok(repositoryMedico.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Medico> post(@RequestBody Medico medico){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryMedico.save(medico));
	}
	
	@PutMapping
	public ResponseEntity<Medico> put(@RequestBody Medico medico){
		return ResponseEntity.status(HttpStatus.OK).body(repositoryMedico.save(medico));
	}
	
	@DeleteMapping("/{crm}")
	public void delete(@PathVariable String crm) {
		repositoryMedico.deleteById(crm);                                  
	}
}
