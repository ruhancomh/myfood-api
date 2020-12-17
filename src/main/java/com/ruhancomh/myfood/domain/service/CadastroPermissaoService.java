package com.ruhancomh.myfood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruhancomh.myfood.domain.exception.PermissaoNaoEncontradaException;
import com.ruhancomh.myfood.domain.model.Permissao;
import com.ruhancomh.myfood.domain.repository.PermissaoRepository;

@Service
public class CadastroPermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	public List<Permissao> listarPorGrupo(Long grupoId) {
		return this.permissaoRepository.findByGrupo(grupoId);
	}
	
	public Permissao buscarOuFalhar(Long permissaoId) {
		return this.permissaoRepository.findById(permissaoId)
				.orElseThrow(() -> new PermissaoNaoEncontradaException(permissaoId));
	}
	
}
