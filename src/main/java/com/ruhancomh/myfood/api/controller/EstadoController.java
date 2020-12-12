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

import com.ruhancomh.myfood.api.mapper.estado.ApiEstadoMapperFactory;
import com.ruhancomh.myfood.api.resources.request.estado.CreateEstadoRequest;
import com.ruhancomh.myfood.api.resources.request.estado.UpdateEstadoResquest;
import com.ruhancomh.myfood.api.resources.response.estado.CreateEstadoResponse;
import com.ruhancomh.myfood.api.resources.response.estado.UpdateEstadoResponse;
import com.ruhancomh.myfood.domain.model.Estado;
import com.ruhancomh.myfood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private CadastroEstadoService estadoService;
	
	@Autowired
	private ApiEstadoMapperFactory estadoMapperFactory;
	
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
	public CreateEstadoResponse cadastrar (@RequestBody @Valid CreateEstadoRequest createEstado) {
		var response = this.estadoService.cadastrar(
				this.estadoMapperFactory
					.getFromCreateEstadoRequestToCreateEstadoDto()
					.map(createEstado)
			);
		
		return this.estadoMapperFactory.getFromEstadoToCreateEstadoResponse().map(response);
	}
	
	@PutMapping("/{estadoId}")
	public UpdateEstadoResponse atualizar (@PathVariable Long estadoId,
			@RequestBody @Valid UpdateEstadoResquest updateEstado) {
		
		var response = this.estadoService.atualizar(estadoId,
				this.estadoMapperFactory.getFromUpdateEstadoRequestToUpdateEstadoDto().map(updateEstado));
		
		return this.estadoMapperFactory.getFromEstadoToUpdateEstadoResponse().map(response);
	}
	
	@DeleteMapping("/{estadoId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover (@PathVariable Long estadoId) {
		this.estadoService.remover(estadoId);
	}
}
