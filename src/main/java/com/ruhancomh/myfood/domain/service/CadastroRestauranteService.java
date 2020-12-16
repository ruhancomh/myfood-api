package com.ruhancomh.myfood.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ruhancomh.myfood.domain.dto.CreateRestauranteDto;
import com.ruhancomh.myfood.domain.exception.CozinhaNaoEncontradaException;
import com.ruhancomh.myfood.domain.exception.EntidadeRelacionadaNaoEncontradaException;
import com.ruhancomh.myfood.domain.exception.RestauranteEmUsoException;
import com.ruhancomh.myfood.domain.exception.RestauranteNaoEncontradoException;
import com.ruhancomh.myfood.domain.model.Cozinha;
import com.ruhancomh.myfood.domain.model.Restaurante;
import com.ruhancomh.myfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroCozinhaService cadastroCozinhaService;
	
	@Autowired
	private CadastroFormaPagamentoService cadastroFormaPagamentoService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<Restaurante> listar () {
		return this.restauranteRepository.findAll();
	}
	
	public Restaurante buscarOuFalhar (Long restauranteId) {
		Restaurante restaurante = this.restauranteRepository.findById(restauranteId)
				.orElseThrow(() -> new RestauranteNaoEncontradoException(restauranteId));
		
		return restaurante;
	}
	
	@Transactional
	public Restaurante criar (CreateRestauranteDto dto)  {
		Long cozinhaId = dto.getCozinhaId();
		Cozinha cozinha = this.getCozinhaRelacionada(cozinhaId);
		
		Restaurante restaurante = this.modelMapper.map(dto, Restaurante.class);
		
		restaurante.setCozinha(cozinha);
		restaurante.setId(null);
		
		return this.restauranteRepository.save(restaurante);	
	}

	@Transactional
	public Restaurante atualizar(Long restauranteId, Restaurante restaurante) {
		Restaurante restauranteAtual = this.buscarOuFalhar(restauranteId);
		
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = this.getCozinhaRelacionada(cozinhaId);
		
		BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento", "endereco",
				"dataCadastro", "produtos");
		
		restauranteAtual.setCozinha(cozinha);
		
		return this.restauranteRepository.save(restauranteAtual);
	}

	@Transactional
	public void remover(Long restauranteId) {
		try {
			this.restauranteRepository.deleteById(restauranteId);
			this.restauranteRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new RestauranteNaoEncontradoException(restauranteId, e);
		} catch (DataIntegrityViolationException e) {
			throw new RestauranteEmUsoException(e);
		}
	}
	
	@Transactional
	public void ativar(Long restauranteId) {
		var restaurante = this.buscarOuFalhar(restauranteId);
		restaurante.setAtivo(Boolean.TRUE);
	}
	
	@Transactional
	public void inativar(Long restauranteId) {
		var restaurante = this.buscarOuFalhar(restauranteId);
		restaurante.setAtivo(Boolean.FALSE);
	}
	
	@Transactional
	public void desassociarFormaPagamento(Long restauranteId, Long formaPagamentoId) {
		var restaurante = this.buscarOuFalhar(restauranteId);
		var formaPagamento = this.cadastroFormaPagamentoService.buscarOuFalhar(formaPagamentoId);
		
		restaurante.getFormasPagamento().remove(formaPagamento);
	}
	
	@Transactional
	public void associarFormaDePagamento(Long restauranteId, Long formaPagamentoId) {
		var restaurante = this.buscarOuFalhar(restauranteId);
		var formaPagamento = this.cadastroFormaPagamentoService.buscarOuFalhar(formaPagamentoId);
		
		restaurante.getFormasPagamento().add(formaPagamento);
	}
	
	@Transactional
	public void abrir(Long restauranteId) {
		var restaurante = this.buscarOuFalhar(restauranteId);
		restaurante.setAberto(Boolean.TRUE);
	}
	
	@Transactional
	public void fechar(Long restauranteId) {
		var restaurante = this.buscarOuFalhar(restauranteId);
		restaurante.setAberto(Boolean.FALSE);
	}
	
	private Cozinha getCozinhaRelacionada(Long cozinhaId) {
		try {
			return this.cadastroCozinhaService.buscarOuFalhar(cozinhaId);
		} catch (CozinhaNaoEncontradaException e) {
			throw new EntidadeRelacionadaNaoEncontradaException("cozinha", cozinhaId);
		}
	}
}
