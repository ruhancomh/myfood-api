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

import com.ruhancomh.myfood.api.mapper.grupo.ApiGrupoMapperFactory;
import com.ruhancomh.myfood.api.resources.response.grupo.GrupoRessource;
import com.ruhancomh.myfood.domain.service.CadastroGrupoService;
import com.ruhancomh.myfood.domain.service.CadastroUsuarioService;

@RestController
@RequestMapping("/usuarios/{usuarioId}/grupos")
public class UsuarioGrupoController {

	@Autowired
	private CadastroGrupoService cadastroGrupoService;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	
	@Autowired
	private ApiGrupoMapperFactory grupoMapperFactory;
	
	@GetMapping
	public List<GrupoRessource> list(@PathVariable Long usuarioId) {
		var listGrupo = this.cadastroGrupoService.listarPorUsuario(usuarioId);
		
		return this.grupoMapperFactory
				.getFromListGrupoToListGrupoResource()
				.map(listGrupo);
	}
	
	@PutMapping("/{grupoId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void associar(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
		this.cadastroUsuarioService.associarGrupo(usuarioId, grupoId);
	}
	
	@DeleteMapping("/{grupoId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void desassociar(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
		this.cadastroUsuarioService.desassociarGrupo(usuarioId, grupoId);
	}
	
}
