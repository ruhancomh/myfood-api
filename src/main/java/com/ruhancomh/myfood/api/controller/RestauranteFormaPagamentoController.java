package com.ruhancomh.myfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ruhancomh.myfood.api.mapper.formaPagamento.ApiFormaPagamentoMapperFactory;
import com.ruhancomh.myfood.api.resources.response.formaPagamento.FormaPagamentoResource;
import com.ruhancomh.myfood.domain.service.CadastroFormaPagamentoService;
import com.ruhancomh.myfood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes/{restauranteId}/formas-pagamento")
public class RestauranteFormaPagamentoController {

	@Autowired
	private CadastroFormaPagamentoService cadastroFormaPagamentoService;
	
	@Autowired
	private CadastroRestauranteService cadastroRestauranteService;
	
	@Autowired
	private ApiFormaPagamentoMapperFactory formaPagamentoMapperFactory;
	
	@GetMapping
	public List<FormaPagamentoResource> listar(@PathVariable Long restauranteId) {
		var listFormaPagamento = this.cadastroFormaPagamentoService.listarPorRestaurante(restauranteId);
		
		return this.formaPagamentoMapperFactory
				.getFromListFormaPagamentoToListFormaPagamentoResource()
				.map(listFormaPagamento);
	}
	
	@DeleteMapping("/{formaPagamentoId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void desassociar(@PathVariable Long restauranteId, @PathVariable Long formaPagamentoId) {
		this.cadastroRestauranteService.desassociarFormaPagamento(restauranteId, formaPagamentoId);
	}
	
	@PutMapping("/{formaPagamentoId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void associar(@PathVariable Long restauranteId, @PathVariable Long formaPagamentoId) {
		this.cadastroRestauranteService.associarFormaDePagamento(restauranteId, formaPagamentoId);
	}
}
