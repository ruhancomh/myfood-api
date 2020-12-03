package com.ruhancomh.myfood.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ruhancomh.myfood.domain.exception.EntidadeEmUsoException;
import com.ruhancomh.myfood.domain.exception.RecursoNaoEncontradoException;
import com.ruhancomh.myfood.domain.model.Estado;
import com.ruhancomh.myfood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> listar () {
		return this.estadoRepository.listar();
	}

	public Estado buscar(Long estadoId) {
		Estado estado = this.estadoRepository.buscar(estadoId);
		
		if (estado == null) {
			throw new RecursoNaoEncontradoException("estado", estadoId);
		}
		
		return estado;
	}

	public Estado cadastrar(Estado estado) {
		estado = this.estadoRepository.salvar(estado);
		return estado;
	}

	public Estado atualizar(Long estadoId, Estado estado) {
		Estado estadoAtual = this.estadoRepository.buscar(estadoId);
		
		if (estadoAtual == null) {
			throw new RecursoNaoEncontradoException("estado", estadoId);
		}
		
		BeanUtils.copyProperties(estado, estadoAtual, "id");
		
		estadoAtual = this.estadoRepository.salvar(estadoAtual);
		
		return estadoAtual;
	}

	public void remover(Long estadoId) {
		Estado estado = this.estadoRepository.buscar(estadoId);
		
		if (estado == null) {
			throw new RecursoNaoEncontradoException("estado", estadoId);
		}
		
		try {
			this.estadoRepository.remover(estado);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException();
		}
	}
}
