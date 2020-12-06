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
	public Restaurante buscar (@PathVariable Long restauranteId) {
		return this.cadastroRestauranteService.buscaOuFalha(restauranteId);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Restaurante criar (@RequestBody Restaurante restaurante) {
		return this.cadastroRestauranteService.criar(restaurante);
	}
	
	@PutMapping("/{restauranteId}")
	public Restaurante atualizar (@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
		return this.cadastroRestauranteService.atualizar(restauranteId, restaurante);
	}
	
	@DeleteMapping("/{restauranteId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover (@PathVariable Long restauranteId) {
		this.cadastroRestauranteService.remover(restauranteId);
	}
	
}
