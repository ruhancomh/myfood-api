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
	
	@GetMapping("/{cozinhaId}")
	public Cozinha buscar (@PathVariable Long cozinhaId) {
		return this.cadastroCozinhaService.buscaOuFalha(cozinhaId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha criar (@RequestBody Cozinha cozinha) {
		return this.cadastroCozinhaService.criar(cozinha);
	}
	
	@PutMapping("/{cozinhaId}")
	public Cozinha atualizar (@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) {	
		return this.cadastroCozinhaService.atualizar(cozinhaId, cozinha);
	}
	
	@DeleteMapping("/{cozinhaId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover (@PathVariable Long cozinhaId) {
			this.cadastroCozinhaService.remover(cozinhaId);
	}
}
