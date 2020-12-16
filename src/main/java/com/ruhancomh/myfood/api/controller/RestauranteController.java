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
import com.ruhancomh.myfood.api.resources.request.restaurante.CreateRestauranteRequest;
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
	public List<RestauranteResource> listar () {
		var restaurantes = this.cadastroRestauranteService.listar();
		
		return  this.restauranteMapperFactory.getFromListRestauranteToListRestauranteResource()
					.map(restaurantes);
	}
	
	@GetMapping("/{restauranteId}")
	public RestauranteResource buscar (@PathVariable Long restauranteId) {
		var response = this.cadastroRestauranteService.buscarOuFalhar(restauranteId);
		return this.restauranteMapperFactory.getFromRestauranteToRestauranteResource().map(response);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Restaurante criar (@RequestBody @Valid CreateRestauranteRequest restauranteRequest) {
		return this.cadastroRestauranteService.criar(
				this.restauranteMapperFactory
					.getFromCreateRestauranteRequestToCreateRestauranteDto()
					.map(restauranteRequest));
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
	
	@PatchMapping("/{restauranteId}/fechamento")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void fechar(@PathVariable Long restauranteId) {
		this.cadastroRestauranteService.fechar(restauranteId);
	}
	
	@PatchMapping("/{restauranteId}/abertura")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void abrir(@PathVariable Long restauranteId) {
		this.cadastroRestauranteService.abrir(restauranteId);
	}
}
