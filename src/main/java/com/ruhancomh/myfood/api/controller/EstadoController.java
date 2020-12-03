package com.ruhancomh.myfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruhancomh.myfood.domain.exception.EntidadeEmUsoException;
import com.ruhancomh.myfood.domain.exception.RecursoNaoEncontradoException;
import com.ruhancomh.myfood.domain.model.Estado;
import com.ruhancomh.myfood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private CadastroEstadoService estadoService;
	
	@GetMapping
	public List<Estado> listar () {
		return this.estadoService.listar();
	}
	
	@GetMapping("/{estadoId}")
	public ResponseEntity<?> buscar (@PathVariable Long estadoId) {
		try {
			Estado estado = this.estadoService.buscar(estadoId);
			return ResponseEntity.ok(estado);
		} catch (RecursoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Estado cadastrar (@RequestBody Estado estado) {
		return this.estadoService.cadastrar(estado);
	}
	
	@PutMapping("/{estadoId}")
	public ResponseEntity<?> atualizar (@PathVariable Long estadoId, @RequestBody Estado estado) {
		try {
			Estado estadoAtualizado = this.estadoService.atualizar(estadoId, estado);
			return ResponseEntity.ok(estadoAtualizado);
		} catch (RecursoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{estadoId}")
	public ResponseEntity<?> remover (@PathVariable Long estadoId) {
		try {
			this.estadoService.remover(estadoId);
			return ResponseEntity.noContent().build();
		} catch (RecursoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
