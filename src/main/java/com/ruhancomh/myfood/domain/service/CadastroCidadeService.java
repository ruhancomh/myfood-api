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
import com.ruhancomh.myfood.domain.model.Cidade;
import com.ruhancomh.myfood.domain.model.Estado;
import com.ruhancomh.myfood.domain.repository.CidadeRepository;
import com.ruhancomh.myfood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> listar () {
		return this.cidadeRepository.findAll();
	}
	
	public Cidade buscaOuFalha (Long cidadeId) {
		Cidade cidade = this.cidadeRepository.findById(cidadeId)
				.orElseThrow(() -> new RecursoNaoEncontradoException("cidade", cidadeId));
		
		return cidade;
	}
	
	public Cidade cadastrar (Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = this.estadoRepository.findById(estadoId)
				.orElseThrow(() -> new EntidadeRelacionadaNaoEncontradaException("estado", estadoId));
		
		cidade.setEstado(estado);
		
		return this.cidadeRepository.save(cidade);
	}
	
	public Cidade atualizar(Long cidadeId, Cidade cidade) {
		Cidade cidadeAtual = this.buscaOuFalha(cidadeId);
		
		Long estadoId = cidade.getEstado().getId();
		Estado estado = this.estadoRepository.findById(estadoId)
				.orElseThrow(() -> new EntidadeRelacionadaNaoEncontradaException("estado", estadoId));
		
		BeanUtils.copyProperties(cidade, cidadeAtual, "id");
		cidadeAtual.setEstado(estado);
		
		return this.cidadeRepository.save(cidadeAtual);
	}
	
	public void remover (Long cidadeId) {
		try {
			this.cidadeRepository.deleteById(cidadeId);
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoException("cidade", cidadeId);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException();
			
		}
	}
}
