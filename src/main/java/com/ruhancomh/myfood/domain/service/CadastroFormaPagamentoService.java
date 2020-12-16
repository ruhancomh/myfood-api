package com.ruhancomh.myfood.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ruhancomh.myfood.domain.dto.CreateFormaPagamentoDto;
import com.ruhancomh.myfood.domain.dto.UpdateFormaPagamentoDto;
import com.ruhancomh.myfood.domain.exception.FormaDePagamentoEmUsoException;
import com.ruhancomh.myfood.domain.exception.FormaDePagamentoNaoEncontradaException;
import com.ruhancomh.myfood.domain.model.FormaPagamento;
import com.ruhancomh.myfood.domain.repository.FormaPagamentoRepository;

@Service
public class CadastroFormaPagamentoService {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	public List<FormaPagamento> listar(){
		return this.formaPagamentoRepository.findAll();
	}
	
	public List<FormaPagamento> listarPorRestaurante(Long restauranteId) {
		return this.formaPagamentoRepository.findByRestaurante(restauranteId);
	}
	
	public FormaPagamento buscarOuFalhar(Long formaPagamentoid) {
		return this.formaPagamentoRepository.findById(formaPagamentoid)
				.orElseThrow(() -> new FormaDePagamentoNaoEncontradaException(formaPagamentoid));
	}
	
	
	@Transactional
	public FormaPagamento cadastrar(CreateFormaPagamentoDto dto) {
		var formaPagamento = new FormaPagamento();
		formaPagamento.setDescricao(dto.getDescricao());
		
		return this.formaPagamentoRepository.save(formaPagamento);
	}
	
	@Transactional
	public FormaPagamento atualizar(Long formaPagamentoId, UpdateFormaPagamentoDto dto) {
		var formaPagamento = this.buscarOuFalhar(formaPagamentoId);
		formaPagamento.setDescricao(dto.getDescricao());
		
		return this.formaPagamentoRepository.save(formaPagamento);
	}
	
	@Transactional
	public void remover(Long formaPagamentoId) {
		try {
			this.formaPagamentoRepository.deleteById(formaPagamentoId);
			this.formaPagamentoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new FormaDePagamentoNaoEncontradaException(formaPagamentoId, e);
		} catch (DataIntegrityViolationException e) {
			throw new FormaDePagamentoEmUsoException(e);
		}
	}
	
}
