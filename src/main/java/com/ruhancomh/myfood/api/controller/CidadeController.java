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
import com.ruhancomh.myfood.domain.model.Cidade;
import com.ruhancomh.myfood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CadastroCidadeService cidadeService;
	
	@GetMapping
	public List<Cidade> listar () {
		return this.cidadeService.listar();
	}
	
	@GetMapping("/{cidadeId}")
	public ResponseEntity<?> buscar (@PathVariable Long cidadeId) {
		try {
			Cidade cidade = this.cidadeService.buscar(cidadeId);
			return ResponseEntity.ok(cidade);
		} catch (RecursoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar (@RequestBody Cidade cidade) {
		try {
			Cidade cidadeCadastrada = this.cidadeService.cadastrar(cidade);
			return ResponseEntity.status(HttpStatus.CREATED).body(cidadeCadastrada);
		} catch (EntidadeRelacionadaNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{cidadeId}")
	public ResponseEntity<?> atualizar (@PathVariable Long cidadeId, @RequestBody Cidade cidade) {
		try {
			Cidade cidadeAtualizada = this.cidadeService.atualizar(cidadeId, cidade);
			return ResponseEntity.ok(cidadeAtualizada);
		} catch (RecursoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
		} catch (EntidadeRelacionadaNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{cidadeId}")
	public ResponseEntity<?> remover (@PathVariable Long cidadeId) {
		try {
			this.cidadeService.remover(cidadeId);
			return ResponseEntity.noContent().build();
		} catch (RecursoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
