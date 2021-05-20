package com.rodizio.rodizio.controller;

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
import java.util.List;
import com.rodizio.rodizio.model.Cadastro;
import com.rodizio.rodizio.repository.CadastroRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/listar")

public class CadastroController {
	
	@Autowired
	private CadastroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Cadastro>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cadastro>> getByName(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
		
	}
	
	@GetMapping("/grupo/{grupo}")
	public ResponseEntity<List<Cadastro>> getByGrupo(@PathVariable String grupo){
		return ResponseEntity.ok(repository.findAllByGrupoContainingIgnoreCase(grupo));
		
	}
	
	@PostMapping
	public ResponseEntity<Cadastro> post (@RequestBody Cadastro cadastro){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(cadastro));
	}
	
	@PutMapping
	public ResponseEntity<Cadastro> put (@RequestBody Cadastro cadastro) {
		return ResponseEntity.ok(repository.save(cadastro));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
