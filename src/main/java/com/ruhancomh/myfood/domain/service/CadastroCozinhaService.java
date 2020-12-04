package com.ruhancomh.myfood.domain.service;

import java.util.List;
import java.util.Optional;

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
		return this.cozinhaRepository.findAll();
	}
	
	public Cozinha buscar (Long cozinhaId) {
		Optional<Cozinha> cozinha = this.cozinhaRepository.findById(cozinhaId);
		
		if (cozinha.isEmpty()) {
			throw new RecursoNaoEncontradoException("cozinha", cozinhaId);
		}
		
		return cozinha.get();
	}
	
	public Cozinha criar(Cozinha cozinha) {
		return this.cozinhaRepository.save(cozinha);
	}
	
	public Cozinha atualizar (Long cozinhaId, Cozinha cozinha) {
		Optional<Cozinha> cozinhaOptional = this.cozinhaRepository.findById(cozinhaId);
		
		if (cozinhaOptional.isEmpty()) {
			throw new RecursoNaoEncontradoException("cozinha", cozinhaId);
		}
		
		Cozinha cozinhaAtual = cozinhaOptional.get();
		
		BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
		
		return this.cozinhaRepository.save(cozinhaAtual);
	}
	
	public void remover (Long cozinhaId) {
		try {
			this.cozinhaRepository.deleteById(cozinhaId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoException("cozinha", cozinhaId);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException();
			
		}
	}
}
