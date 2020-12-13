package com.ruhancomh.myfood.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ruhancomh.myfood.api.mapper.restaurante.ApiRestauranteMapperFactory;
import com.ruhancomh.myfood.api.resources.response.restaurante.RestauranteResource;
import com.ruhancomh.myfood.domain.model.Restaurante;
import com.ruhancomh.myfood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private CadastroRestauranteService cadastroRestauranteService;
	
	@Autowired
	private ApiRestauranteMapperFactory restauranteMapperFactory;
	
	@GetMapping
	public List<Restaurante> listar () {
		return this.cadastroRestauranteService.listar();
	}
	
	@GetMapping("/{restauranteId}")
	public RestauranteResource buscar (@PathVariable Long restauranteId) {
		var response = this.cadastroRestauranteService.buscarOuFalhar(restauranteId);
		return this.restauranteMapperFactory.getFromRestauranteToRestauranteResource().map(response);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Restaurante criar (@RequestBody @Valid Restaurante restaurante) {
		return this.cadastroRestauranteService.criar(restaurante);
	}
	
	@PutMapping("/{restauranteId}")
	public Restaurante atualizar (@PathVariable Long restauranteId,
			@RequestBody @Valid Restaurante restaurante) {
		return this.cadastroRestauranteService.atualizar(restauranteId, restaurante);
	}
	
	@DeleteMapping("/{restauranteId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover (@PathVariable Long restauranteId) {
		this.cadastroRestauranteService.remover(restauranteId);
	}
	
	@PatchMapping("/{restauranteId}/ativo")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void ativar(@PathVariable Long restauranteId) {
		this.cadastroRestauranteService.ativar(restauranteId);
	}
	
	@PatchMapping("/{restauranteId}/inativo")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void inativar(@PathVariable Long restauranteId) {
		this.cadastroRestauranteService.inativar(restauranteId);
	}
	
}
