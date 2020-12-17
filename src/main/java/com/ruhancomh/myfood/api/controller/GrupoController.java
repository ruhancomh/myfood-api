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

import com.ruhancomh.myfood.api.mapper.grupo.ApiGrupoMapperFactory;
import com.ruhancomh.myfood.api.resources.request.grupo.CreateGrupoRequest;
import com.ruhancomh.myfood.api.resources.request.grupo.UpdateGrupoRequest;
import com.ruhancomh.myfood.api.resources.response.grupo.GrupoRessource;
import com.ruhancomh.myfood.domain.service.CadastroGrupoService;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

	@Autowired
	private CadastroGrupoService grupoService;
	
	@Autowired
	private ApiGrupoMapperFactory grupoMapperFactory;
	
	@GetMapping
	public List<GrupoRessource> listar() {
		var listGrupos = this.grupoService.listar();
		
		return this.grupoMapperFactory.getFromListGrupoToListGrupoResource()
				.map(listGrupos);
	}
	
	@GetMapping("/{grupoId}")
	public GrupoRessource buscar(@PathVariable Long grupoId) {
		var grupo = this.grupoService.buscarOuFalhar(grupoId);
		
		return this.grupoMapperFactory.getFromGrupoToGrupoResource()
				.map(grupo);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public GrupoRessource cadastrar(@RequestBody @Valid CreateGrupoRequest request) {
		var grupo = this.grupoService.criar(this.grupoMapperFactory
				.getFromCreateGrupoRequestToCreateGrupoDto()
				.map(request));
		
		return this.grupoMapperFactory.getFromGrupoToGrupoResource()
				.map(grupo);
	}
	
	@PutMapping("/{grupoId}")
	public GrupoRessource atualizar(@PathVariable Long grupoId,
			@RequestBody @Valid UpdateGrupoRequest request) {
		
		var grupo = this.grupoService.atualizar(grupoId,
				this.grupoMapperFactory
					.getFromUpdateGrupoRequestToUpdateGrupoDto()
					.map(request));
		
		return this.grupoMapperFactory.getFromGrupoToGrupoResource()
				.map(grupo);
	}
	
	@DeleteMapping("/{grupoId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long grupoId) {
		this.grupoService.remover(grupoId);
	}
}
