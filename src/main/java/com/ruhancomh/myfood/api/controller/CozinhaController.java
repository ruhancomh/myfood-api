package com.ruhancomh.myfood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ruhancomh.myfood.domain.model.Cozinha;
import com.ruhancomh.myfood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping
	public List<Cozinha> listar () {
		return this.cozinhaRepository.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> buscar (@PathVariable Long id) {
		Cozinha cozinha = this.cozinhaRepository.buscar(id);
		
		if (cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Cozinha criar (@RequestBody Cozinha cozinha) {
		return this.cozinhaRepository.salvar(cozinha);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cozinha> atualizar (@PathVariable Long id, @RequestBody Cozinha cozinha) {
		Cozinha cozinhaAtual = this.cozinhaRepository.buscar(id);
		
		if (cozinhaAtual == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
		
		cozinhaAtual = this.cozinhaRepository.salvar(cozinhaAtual);
		
		return ResponseEntity.ok(cozinhaAtual);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cozinha> remover (@PathVariable Long id) {
		Cozinha cozinha = this.cozinhaRepository.buscar(id);
		
		try {
			if (cozinha == null) {
				return ResponseEntity.notFound().build();
			}
			
			this.cozinhaRepository.remover(cozinha);
			
			return ResponseEntity.noContent().build();
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
