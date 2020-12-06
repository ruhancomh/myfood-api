package com.ruhancomh.myfood.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ruhancomh.myfood.domain.exception.EntidadeEmUsoException;
import com.ruhancomh.myfood.domain.exception.EntidadeRelacionadaNaoEncontradaException;
import com.ruhancomh.myfood.domain.exception.RecursoNaoEncontradoException;
import com.ruhancomh.myfood.domain.model.Cozinha;
import com.ruhancomh.myfood.domain.model.Restaurante;
import com.ruhancomh.myfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	private static final String NOME_RECURSO = "restaurante";

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroCozinhaService cadastroCozinhaService;
	
	public List<Restaurante> listar () {
		return this.restauranteRepository.findAll();
	}
	
	public Restaurante buscarOuFalhar (Long restauranteId) {
		Restaurante restaurante = this.restauranteRepository.findById(restauranteId)
				.orElseThrow(() -> new RecursoNaoEncontradoException(NOME_RECURSO, restauranteId));
		
		return restaurante;
	}
	
	public Restaurante criar (Restaurante restaurante)  {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = this.getCozinhaRelacionada(cozinhaId);
		
		restaurante.setCozinha(cozinha);
		
		return this.restauranteRepository.save(restaurante);	
	}

	public Restaurante atualizar(Long restauranteId, Restaurante restaurante) {
		Restaurante restauranteAtual = this.buscarOuFalhar(restauranteId);
		
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = this.getCozinhaRelacionada(cozinhaId);
		
		BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento", "endereco",
				"dataCadastro", "produtos");
		
		restauranteAtual.setCozinha(cozinha);
		
		return this.restauranteRepository.save(restauranteAtual);
	}

	public void remover(Long restauranteId) {
		try {
			this.restauranteRepository.deleteById(restauranteId);
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoException(NOME_RECURSO, restauranteId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException();
		}
	}
	
	
	private Cozinha getCozinhaRelacionada(Long cozinhaId) {
		try {
			return this.cadastroCozinhaService.buscarOuFalhar(cozinhaId);
		} catch (EntidadeRelacionadaNaoEncontradaException e) {
			throw new EntidadeRelacionadaNaoEncontradaException("cozinha", cozinhaId);
		}
	}
}
