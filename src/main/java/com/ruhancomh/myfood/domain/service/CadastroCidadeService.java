package com.ruhancomh.myfood.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return this.cidadeRepository.listar();
	}
	
	public Cidade buscar (Long cidadeId) {
		Cidade cidade = this.cidadeRepository.buscar(cidadeId);
		
		if (cidade == null) {
			throw new RecursoNaoEncontradoException("cidade", cidadeId);
		}
		
		return cidade;
	}
	
	public Cidade cadastrar (Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = this.estadoRepository.buscar(estadoId);
		
		if (estado == null) {
			throw new EntidadeRelacionadaNaoEncontradaException("estado", estadoId);
		}
		
		cidade.setEstado(estado);
		
		return this.cidadeRepository.salvar(cidade);
	}
	
	public Cidade atualizar(Long cidadeId, Cidade cidade) {
		Cidade cidadeAtual = this.cidadeRepository.buscar(cidadeId);
		
		if (cidadeAtual == null) {
			throw new RecursoNaoEncontradoException("cidade", cidadeId);
		}
		
		Long estadoId = cidade.getEstado().getId();
		Estado estado = this.estadoRepository.buscar(estadoId);
		
		if (estado == null) {
			throw new EntidadeRelacionadaNaoEncontradaException("estado", estadoId);
		}
		
		BeanUtils.copyProperties(cidade, cidadeAtual, "id");
		cidadeAtual.setEstado(estado);
		
		return this.cidadeRepository.salvar(cidadeAtual);
	}
	
	public void remover (Long cidadeId) {
		Cidade cidade = this.cidadeRepository.buscar(cidadeId);
		
		if (cidade == null) {
			throw new RecursoNaoEncontradoException("cidade", cidadeId);
		}
		
		this.cidadeRepository.remover(cidade);
	}
}
