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

import com.ruhancomh.myfood.domain.model.Cidade;
import com.ruhancomh.myfood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CadastroCidadeService cidadeService;
	
	@GetMapping
	public List<Cidade> listar () {
		return this.cidadeService.listar();
	}
	
	@GetMapping("/{cidadeId}")
	public Cidade buscar (@PathVariable Long cidadeId) {
		return this.cidadeService.buscarOuFalhar(cidadeId);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cidade cadastrar (@RequestBody @Valid Cidade cidade) {
		return this.cidadeService.cadastrar(cidade);
	}
	
	@PutMapping("/{cidadeId}")
	public Cidade atualizar (@PathVariable Long cidadeId,
			@RequestBody @Valid Cidade cidade) {
		return this.cidadeService.atualizar(cidadeId, cidade);
	}
	
	@DeleteMapping("/{cidadeId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover (@PathVariable Long cidadeId) {
		this.cidadeService.remover(cidadeId);
	}
}
