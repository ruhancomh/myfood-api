package com.ruhancomh.myfood.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ruhancomh.myfood.domain.exception.CozinhaEmUsoException;
import com.ruhancomh.myfood.domain.exception.CozinhaNaoEncontradaException;
import com.ruhancomh.myfood.domain.model.Cozinha;
import com.ruhancomh.myfood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public List<Cozinha> listar () {
		return this.cozinhaRepository.findAll();
	}
	
	public Cozinha buscarOuFalhar (Long cozinhaId) {
		return this.cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new CozinhaNaoEncontradaException(cozinhaId));
	}
	
	@Transactional
	public Cozinha criar(Cozinha cozinha) {
		return this.cozinhaRepository.save(cozinha);
	}
	
	@Transactional
	public Cozinha atualizar (Long cozinhaId, Cozinha cozinha) {
		Cozinha cozinhaAtual = this.buscarOuFalhar(cozinhaId);
		
		BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
		
		return this.cozinhaRepository.save(cozinhaAtual);
	}
	
	@Transactional
	public void remover (Long cozinhaId) {
		try {
			this.cozinhaRepository.deleteById(cozinhaId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new CozinhaNaoEncontradaException(cozinhaId, e);
			
		} catch (DataIntegrityViolationException e) {
			throw new CozinhaEmUsoException(e);
			
		}
	}
}
