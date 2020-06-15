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

import com.Generation.clinica.model.Especialidade;
import com.Generation.clinica.repository.EspecialidadeRepository;

@RestController
@RequestMapping("/especialidade")
@CrossOrigin("*")
public class EspecialidadeController {
	
	@Autowired
	private EspecialidadeRepository repositoryEspecialidade;
	
	
	@GetMapping("/{codEspecialidade}")
	public ResponseEntity <Especialidade> 
	GetById(@PathVariable long id){
		return repositoryEspecialidade.findById(id).
		map(resp->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<Especialidade>> getAll(){
		return ResponseEntity.ok(repositoryEspecialidade.findAll());
	}
		
	@GetMapping("/nomeProduto/{nomeProduto}")
	public ResponseEntity<List<Especialidade>> GetByName(@PathVariable String nomeEspecialidade){
		return ResponseEntity.ok(repositoryEspecialidade.findAllByNomeEspecialidadeContainingIgnoreCase(nomeEspecialidade));
	}
	
	@PostMapping
	public ResponseEntity<Especialidade> post(@RequestBody Especialidade especialidade){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryEspecialidade.save(especialidade));
	}
	
	@PutMapping
	public ResponseEntity<Especialidade> put(@RequestBody Especialidade especialidade){
		return ResponseEntity.status(HttpStatus.OK).body(repositoryEspecialidade.save(especialidade));
	}
	
	@DeleteMapping("/{codEspecialidade}")
	public void delete(@PathVariable long id) {
		repositoryEspecialidade.deleteById(id);                                  
	}

}
