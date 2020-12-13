package com.ruhancomh.myfood.api.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.ruhancomh.myfood.api.mapper.formaPagamento.ApiFormaPagamentoMapperFactory;
import com.ruhancomh.myfood.api.request.formaPagamento.UpdateFormaPagamentoRequest;
import com.ruhancomh.myfood.api.resources.request.formaPagamento.CreateFormaPagamentoRequest;
import com.ruhancomh.myfood.api.resources.response.formaPagamento.FormaPagamentoResource;
import com.ruhancomh.myfood.domain.service.CadastroFormaPagamentoService;

@RestController
@RequestMapping("/formas-pagamento")
public class FormaPagamentoController {

	@Autowired
	private CadastroFormaPagamentoService cadastroFormaPagamentoService;
	
	@Autowired
	private ApiFormaPagamentoMapperFactory formaPagamentoMapperFactoy;
	
	@GetMapping
	public List<FormaPagamentoResource> listar() {
		var listFormaPagamento = this.cadastroFormaPagamentoService.listar();
		
		return this.formaPagamentoMapperFactoy.getFromListFormaPagamentoToListFormaPagamentoResource()
				.map(listFormaPagamento);
	}
	
	@GetMapping("/{formaPagamentoId}")
	public FormaPagamentoResource buscar(@PathVariable Long formaPagamentoId) {
		var formaPagamento = this.cadastroFormaPagamentoService.buscarOuFalhar(formaPagamentoId);
		
		return this.formaPagamentoMapperFactoy.getFromFormaPagamentoToFormaPagamentoResource()
				.map(formaPagamento);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public FormaPagamentoResource criar(@RequestBody @Valid CreateFormaPagamentoRequest request) {
		var formaPagamento = this.cadastroFormaPagamentoService.cadastrar(
				this.formaPagamentoMapperFactoy
					.getFromCreateFormaPagamentoRequestToCreateFormaPagamentoDto()
					.map(request)
			);
		
		return this.formaPagamentoMapperFactoy
				.getFromFormaPagamentoToFormaPagamentoResource()
				.map(formaPagamento);
	}
	
	@PutMapping("/{formaPagamentoId}")
	public FormaPagamentoResource atualizar(@PathVariable Long formaPagamentoId,
			@RequestBody @Valid UpdateFormaPagamentoRequest request) {
		
		var formaPagamento = this.cadastroFormaPagamentoService.atualizar(formaPagamentoId,
				this.formaPagamentoMapperFactoy
					.getFromUpdateFormaPagamentoRequestToUpdateFormaPagamentoDto()
					.map(request));
		
		return this.formaPagamentoMapperFactoy
				.getFromFormaPagamentoToFormaPagamentoResource()
				.map(formaPagamento);
	}
	
	@DeleteMapping("/{formaPagamentoId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long formaPagamentoId) {
		this.cadastroFormaPagamentoService.remover(formaPagamentoId);
	}
	
}
