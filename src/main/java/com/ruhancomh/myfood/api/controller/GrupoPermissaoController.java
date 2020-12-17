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

import com.ruhancomh.myfood.api.mapper.permissao.ApiPermissaoMapperFactory;
import com.ruhancomh.myfood.api.resources.response.permissao.PermissaoRessource;
import com.ruhancomh.myfood.domain.service.CadastroGrupoService;
import com.ruhancomh.myfood.domain.service.CadastroPermissaoService;

@RestController
@RequestMapping("/grupos/{grupoId}/permissoes")
public class GrupoPermissaoController {

	@Autowired
	private CadastroGrupoService cadastroGrupoService;
	
	@Autowired
	private CadastroPermissaoService cadastroPermissaoService;
	
	@Autowired
	private ApiPermissaoMapperFactory permissaoMapperFactory;
	
	@GetMapping
	public List<PermissaoRessource> listar(@PathVariable Long grupoId) {
		var listPermissao = this.cadastroPermissaoService.listarPorGrupo(grupoId);
		
		return this.permissaoMapperFactory
				.getFromListPermissaoToListPermissaoRessource()
				.map(listPermissao);
	}
	
	@PutMapping("/{permissaoId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void associarPermissao(@PathVariable Long grupoId,
			@PathVariable Long permissaoId) {
		
		this.cadastroGrupoService.associarPermissao(grupoId, permissaoId);
	}
	
	@DeleteMapping("/{permissaoId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void desassociarPermissao(@PathVariable Long grupoId,
			@PathVariable Long permissaoId) {
		
		this.cadastroGrupoService.desassociarPermissao(grupoId, permissaoId);
	}
	
}
