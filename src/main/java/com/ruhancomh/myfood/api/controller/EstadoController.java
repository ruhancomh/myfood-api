package com.ruhancomh.myfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
	public Estado buscar (@PathVariable Long estadoId) {
		return this.estadoService.buscarOuFalhar(estadoId);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Estado cadastrar (@RequestBody Estado estado) {
		return this.estadoService.cadastrar(estado);
	}
	
	@PutMapping("/{estadoId}")
	public Estado atualizar (@PathVariable Long estadoId, @RequestBody Estado estado) {
		return this.estadoService.atualizar(estadoId, estado);
	}
	
	@DeleteMapping("/{estadoId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover (@PathVariable Long estadoId) {
		this.estadoService.remover(estadoId);
	}
}
