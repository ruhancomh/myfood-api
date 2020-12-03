package com.ruhancomh.myfood.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ruhancomh.myfood.domain.exception.RecursoNaoEncontradoException;
import com.ruhancomh.myfood.domain.exception.EntidadeEmUsoException;
import com.ruhancomh.myfood.domain.model.Cozinha;
import com.ruhancomh.myfood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public List<Cozinha> listar () {
		return this.cozinhaRepository.listar();
	}
	
	public Cozinha buscar (Long cozinhaId) {
		Cozinha cozinha = this.buscar(cozinhaId);
		
		if (cozinha != null) {
			throw new RecursoNaoEncontradoException("cozinha", cozinhaId);
		}
		
		return cozinha;
	}
	
	public Cozinha criar(Cozinha cozinha) {
		return this.cozinhaRepository.salvar(cozinha);
	}
	
	public Cozinha atualizar (Long cozinhaId, Cozinha cozinha) {
		Cozinha cozinhaAtual = this.cozinhaRepository.buscar(cozinhaId);
		
		if (cozinhaAtual == null) {
			throw new RecursoNaoEncontradoException("cozinha", cozinhaId);
		}
		
		BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
		
		return this.cozinhaRepository.salvar(cozinhaAtual);
	}
	
	public void remover (Long cozinhaId) {
		try {
			this.cozinhaRepository.remover(cozinhaId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoException("cozinha", cozinhaId);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException();
			
		}
	}
}
