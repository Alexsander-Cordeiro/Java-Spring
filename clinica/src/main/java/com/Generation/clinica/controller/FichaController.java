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

import com.Generation.clinica.model.Ficha;
import com.Generation.clinica.repository.FichaRepository;

@RestController
@RequestMapping("/ficha")
@CrossOrigin("*")
public class FichaController {
	

	@Autowired
	private FichaRepository repositoryficha;
	
	
	@GetMapping("/{crm}")
	public ResponseEntity <Ficha> 
	GetById(@PathVariable long codFicha){
		return repositoryficha.findById(codFicha).
		map(resp->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<Ficha>> getAll(){
		return ResponseEntity.ok(repositoryficha.findAll());
	}
		
	
	@PostMapping
	public ResponseEntity<Ficha> post(@RequestBody Ficha ficha){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryficha.save(ficha));
	}
	
	@PutMapping
	public ResponseEntity<Ficha> put(@RequestBody Ficha ficha){
		return ResponseEntity.status(HttpStatus.OK).body(repositoryficha.save(ficha));
	}
	
	@DeleteMapping("/{crm}")
	public void delete(@PathVariable long codFicha) {
		repositoryficha.deleteById(codFicha);                                  
	}


}
