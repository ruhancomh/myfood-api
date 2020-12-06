package com.ruhancomh.myfood.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ruhancomh.myfood.domain.exception.EntidadeEmUsoException;
import com.ruhancomh.myfood.domain.exception.RecursoNaoEncontradoException;
import com.ruhancomh.myfood.domain.model.Cozinha;
import com.ruhancomh.myfood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	private static final String NOME_RECURSO = "cozinha";
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public List<Cozinha> listar () {
		return this.cozinhaRepository.findAll();
	}
	
	public Cozinha buscarOuFalhar (Long cozinhaId) {
		return this.cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new RecursoNaoEncontradoException(NOME_RECURSO, cozinhaId));
	}
	
	public Cozinha criar(Cozinha cozinha) {
		return this.cozinhaRepository.save(cozinha);
	}
	
	public Cozinha atualizar (Long cozinhaId, Cozinha cozinha) {
		Cozinha cozinhaAtual = this.buscarOuFalhar(cozinhaId);
		
		BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
		
		return this.cozinhaRepository.save(cozinhaAtual);
	}
	
	public void remover (Long cozinhaId) {
		try {
			this.cozinhaRepository.deleteById(cozinhaId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoException(NOME_RECURSO, cozinhaId);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException();
			
		}
	}
}
