package com.ruhancomh.myfood.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ruhancomh.myfood.domain.exception.EstadoEmUsoException;
import com.ruhancomh.myfood.domain.exception.EstadoNaoEncontradoException;
import com.ruhancomh.myfood.domain.model.Estado;
import com.ruhancomh.myfood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> listar () {
		return this.estadoRepository.findAll();
	}

	public Estado buscarOuFalhar(Long estadoId) {
		Estado estado = this.estadoRepository.findById(estadoId)
				.orElseThrow(() -> new EstadoNaoEncontradoException(estadoId));
		
		return estado;
	}

	@Transactional
	public Estado cadastrar(Estado estado) {
		return this.estadoRepository.save(estado);
	}

	@Transactional
	public Estado atualizar(Long estadoId, Estado estado) {
		Estado estadoAtual = this.buscarOuFalhar(estadoId);
		
		BeanUtils.copyProperties(estado, estadoAtual, "id");
		
		return this.estadoRepository.save(estadoAtual);
	}

	@Transactional
	public void remover(Long estadoId) {
		try {
			this.estadoRepository.deleteById(estadoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EstadoNaoEncontradoException(estadoId, e);
		}  catch (DataIntegrityViolationException e) {
			throw new EstadoEmUsoException(e);
		}
	}
}
