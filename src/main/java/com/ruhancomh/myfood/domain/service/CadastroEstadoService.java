package com.ruhancomh.myfood.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
		return this.estadoRepository.findAll();
	}

	public Estado buscar(Long estadoId) {
		Estado estado = this.estadoRepository.findById(estadoId)
				.orElseThrow(() -> new RecursoNaoEncontradoException("estado", estadoId));
		
		return estado;
	}

	public Estado cadastrar(Estado estado) {
		return this.estadoRepository.save(estado);
	}

	public Estado atualizar(Long estadoId, Estado estado) {
		Estado estadoAtual = this.buscar(estadoId);
		
		BeanUtils.copyProperties(estado, estadoAtual, "id");
		
		return this.estadoRepository.save(estadoAtual);
	}

	public void remover(Long estadoId) {
		try {
			this.estadoRepository.deleteById(estadoId);
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoException("estado", estadoId);
		}  catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException();
		}
	}
}
