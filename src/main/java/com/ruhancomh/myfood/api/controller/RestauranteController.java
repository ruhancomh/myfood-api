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
import org.springframework.web.bind.annotation.RestController;

import com.ruhancomh.myfood.domain.exception.EntidadeRelacionadaNaoEncontradaException;
import com.ruhancomh.myfood.domain.exception.RecursoNaoEncontradoException;
import com.ruhancomh.myfood.domain.model.Restaurante;
import com.ruhancomh.myfood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private CadastroRestauranteService cadastroRestauranteService;
	
	@GetMapping
	public List<Restaurante> listar () {
		return this.cadastroRestauranteService.listar();
	}
	
	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar (@PathVariable Long restauranteId) {
		try {
			return ResponseEntity.ok(this.cadastroRestauranteService.buscar(restauranteId));
		} catch (RecursoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
			
		}
	}
	
	@PostMapping
	public ResponseEntity<?> criar (@RequestBody Restaurante restaurante) {
		try {
			Restaurante restauranteCriado = this.cadastroRestauranteService.criar(restaurante);
			return ResponseEntity.status(HttpStatus.CREATED).body(restauranteCriado);
		} catch (RecursoNaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{restauranteId}")
	public ResponseEntity<?> atualizar (@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
		try {
			Restaurante restauranteAtualizado = this.cadastroRestauranteService.atualizar(restauranteId, restaurante);
			return ResponseEntity.ok(restauranteAtualizado);
		} catch (RecursoNaoEncontradoException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (EntidadeRelacionadaNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{restauranteId}")
	public ResponseEntity<?> remover (@PathVariable Long restauranteId) {
		try {
			this.cadastroRestauranteService.remover(restauranteId);
			return ResponseEntity.noContent().build();
		} catch (RecursoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
