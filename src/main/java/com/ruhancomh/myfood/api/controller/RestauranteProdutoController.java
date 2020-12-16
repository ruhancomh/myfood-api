package com.ruhancomh.myfood.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ruhancomh.myfood.api.mapper.produto.ApiProdutoMapperFactory;
import com.ruhancomh.myfood.api.resources.request.produto.CreateProdutoRequest;
import com.ruhancomh.myfood.api.resources.request.produto.UpdateProdutoRequest;
import com.ruhancomh.myfood.api.resources.response.produto.SimpleProdutoResource;
import com.ruhancomh.myfood.domain.service.CadastroProdutoService;

@RestController
@RequestMapping("/restaurantes/{restauranteId}/produtos")
public class RestauranteProdutoController {
	
	@Autowired
	private CadastroProdutoService cadastroProdutoService;
	
	@Autowired
	private ApiProdutoMapperFactory produtoMapperFactory;

	@GetMapping
	public List<SimpleProdutoResource> listar(@PathVariable Long restauranteId) {
		var listProduto = this.cadastroProdutoService.listarPorRestaurante(restauranteId);
		
		return this.produtoMapperFactory
				.getFromListProdutoToListSimpleProdutoResource()
				.map(listProduto);
	}
	
	@GetMapping("/{produtoId}")
	public SimpleProdutoResource buscar(@PathVariable Long restauranteId,
			@PathVariable Long produtoId) {
		
		var produto = this.cadastroProdutoService.buscarPorRestauranteOuFalhar(restauranteId, produtoId);
		
		return this.produtoMapperFactory
				.getFromProdutoToSimpleProdutoResource()
				.map(produto);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public SimpleProdutoResource cadastrar(@PathVariable Long restauranteId,
			@RequestBody @Valid CreateProdutoRequest request) {
		
		var createProdutoDto = this.produtoMapperFactory
								.getFromCreateProdutoRequestToCreateProdutoDto()
								.map(request);
		
		var produto = this.cadastroProdutoService.cadastrar(restauranteId, createProdutoDto);
		
		return this.produtoMapperFactory
				.getFromProdutoToSimpleProdutoResource()
				.map(produto);
	}
	
	@PutMapping("/{produtoId}")
	public SimpleProdutoResource atualizar(@PathVariable Long restauranteId,
			@PathVariable Long produtoId, @RequestBody @Valid UpdateProdutoRequest request) {
		
		var updateProdutoDto = this.produtoMapperFactory
								.getFromUpdateProdutoRequestToUpdateProdutoDto()
								.map(request);
		
		var produto = this.cadastroProdutoService.atualizar(restauranteId, produtoId, updateProdutoDto);
		
		return this.produtoMapperFactory
				.getFromProdutoToSimpleProdutoResource()
				.map(produto);
	}
}
