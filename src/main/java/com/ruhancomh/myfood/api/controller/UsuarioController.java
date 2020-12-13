package com.ruhancomh.myfood.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ruhancomh.myfood.api.mapper.usuario.ApiUsuarioMapperFactory;
import com.ruhancomh.myfood.api.resources.request.usuario.CreateUsuarioRequest;
import com.ruhancomh.myfood.api.resources.request.usuario.UpdateUsuarioRequest;
import com.ruhancomh.myfood.api.resources.request.usuario.UpdateUsuarioSenhaRequest;
import com.ruhancomh.myfood.api.resources.response.usuario.UsuarioResource;
import com.ruhancomh.myfood.domain.service.CadastroUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	
	@Autowired
	private ApiUsuarioMapperFactory usuarioMapperFactory;
	
	@RequestMapping
	public List<UsuarioResource> listar() {
		var listUsuarios = this.cadastroUsuarioService.listar();
		
		return this.usuarioMapperFactory
				.getFromListUsuarioToListUsuarioResource()
				.map(listUsuarios);
	}
	
	@RequestMapping("/{usuarioId}")
	public UsuarioResource buscar(@PathVariable Long usuarioId) {
		var usuario = this.cadastroUsuarioService.buscarOuFalhar(usuarioId);
		
		return this.usuarioMapperFactory
				.getFromUsuarioToUsuarioResource()
				.map(usuario);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UsuarioResource cadastrar(@RequestBody @Valid CreateUsuarioRequest request) {
		var usuario = this.cadastroUsuarioService.cadastrar(this.usuarioMapperFactory
				.getFromCreateUsuarioRequestToCreateUsuarioDto()
				.map(request));
		
		return this.usuarioMapperFactory
				.getFromUsuarioToUsuarioResource()
				.map(usuario);
	}
	
	@PutMapping("/{usuarioId}")
	public UsuarioResource atualizar(@PathVariable Long usuarioId,
			@RequestBody @Valid UpdateUsuarioRequest request) {
		
		var usuario = this.cadastroUsuarioService.atualizar(usuarioId,
				this.usuarioMapperFactory
				.getFromUpdateUsuarioRequestToUpdateUsuarioDto()
				.map(request));
		
		return this.usuarioMapperFactory
				.getFromUsuarioToUsuarioResource()
				.map(usuario);
	}
	
	@PutMapping("/{usuarioId}/senha")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void atualizarSenha(@PathVariable Long usuarioId,
			@RequestBody @Valid UpdateUsuarioSenhaRequest request) {
		
		this.cadastroUsuarioService.atualizarSenha(usuarioId,
				this.usuarioMapperFactory
					.getFromUpdateUsuarioSenhaRequestToUpdateUsuarioSenhaDto()
					.map(request));
	}
	
	@DeleteMapping("/{usuarioId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long usuarioId) {
		this.cadastroUsuarioService.remover(usuarioId);
	}
	
}
