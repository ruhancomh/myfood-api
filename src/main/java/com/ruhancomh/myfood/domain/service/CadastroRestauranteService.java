package com.ruhancomh.myfood.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ruhancomh.myfood.domain.exception.EntidadeRelacionadaNaoEncontradaException;
import com.ruhancomh.myfood.domain.exception.RecursoNaoEncontradoException;
import com.ruhancomh.myfood.domain.model.Cozinha;
import com.ruhancomh.myfood.domain.model.Restaurante;
import com.ruhancomh.myfood.domain.repository.CozinhaRepository;
import com.ruhancomh.myfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public List<Restaurante> listar () {
		return this.restauranteRepository.findAll();
	}
	
	public Restaurante buscar (Long restauranteId) {
		Restaurante restaurante = this.restauranteRepository.findById(restauranteId)
				.orElseThrow(() -> new RecursoNaoEncontradoException("restaurante", restauranteId));
		
		return restaurante;
	}
	
	public Restaurante criar (Restaurante restaurante)  {	
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = this.cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new RecursoNaoEncontradoException("cozinha", cozinhaId));
		
		restaurante.setCozinha(cozinha);
		
		return this.restauranteRepository.save(restaurante);	
	}

	public Restaurante atualizar(Long restauranteId, Restaurante restaurante) {
		Restaurante restauranteAtual = this.restauranteRepository.findById(restauranteId)
				.orElseThrow(() -> new RecursoNaoEncontradoException("restaurante", restauranteId));
		
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = this.cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeRelacionadaNaoEncontradaException("cozinha", cozinhaId));
		
		BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento", "endereco");
		restauranteAtual.setCozinha(cozinha);
		
		return this.restauranteRepository.save(restauranteAtual);
	}

	public void remover(Long restauranteId) {
		try {
			this.restauranteRepository.deleteById(restauranteId);
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoException("restaurante", restauranteId);
		}
	}
}
