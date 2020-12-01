package com.ruhancomh.myfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ruhancomh.myfood.domain.exception.RecursoNaoEncontradoException;
import com.ruhancomh.myfood.domain.exception.EntidadeEmUsoException;
import com.ruhancomh.myfood.domain.model.Cozinha;
import com.ruhancomh.myfood.domain.service.CadastroCozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
	
	@Autowired
	private CadastroCozinhaService cadastroCozinhaService;
	
	@GetMapping
	public List<Cozinha> listar () {
		return this.cadastroCozinhaService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> buscar (@PathVariable Long id) {
		try {
			Cozinha cozinha = this.cadastroCozinhaService.buscar(id);
			return ResponseEntity.ok(cozinha);
			
		}catch (RecursoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
			
		}
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Cozinha criar (@RequestBody Cozinha cozinha) {
		return this.cadastroCozinhaService.criar(cozinha);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cozinha> atualizar (@PathVariable Long id, @RequestBody Cozinha cozinha) {
		try {
			return ResponseEntity.ok(this.cadastroCozinhaService.atualizar(id, cozinha));
			
		} catch (RecursoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
			
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cozinha> remover (@PathVariable Long id) {
		try {
			this.cadastroCozinhaService.remover(id);
			return ResponseEntity.noContent().build();
			
		} catch (RecursoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
			
		}catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		}
	}
}
