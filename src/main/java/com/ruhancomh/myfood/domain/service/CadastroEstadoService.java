package com.ruhancomh.myfood.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ruhancomh.myfood.domain.dto.CreateEstadoDto;
import com.ruhancomh.myfood.domain.dto.UpdateEstadoDto;
import com.ruhancomh.myfood.domain.exception.EstadoEmUsoException;
import com.ruhancomh.myfood.domain.exception.EstadoNaoEncontradoException;
import com.ruhancomh.myfood.domain.mapper.estado.EstadoMapperFactory;
import com.ruhancomh.myfood.domain.model.Estado;
import com.ruhancomh.myfood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EstadoMapperFactory estadoMapperFactory;
	
	public List<Estado> listar () {
		return this.estadoRepository.findAll();
	}

	public Estado buscarOuFalhar(Long estadoId) {
		Estado estado = this.estadoRepository.findById(estadoId)
				.orElseThrow(() -> new EstadoNaoEncontradoException(estadoId));
		
		return estado;
	}

	@Transactional
	public Estado cadastrar(CreateEstadoDto createEstadoDto) {
		return this.estadoRepository.save(
				this.estadoMapperFactory.getFromCreateEstadoDtoToEstado().map(createEstadoDto)
				);
	}

	@Transactional
	public Estado atualizar(Long estadoId, UpdateEstadoDto updateEstadoDto) {
		Estado estadoAtual = this.buscarOuFalhar(estadoId);
		
		estadoAtual.setNome(updateEstadoDto.getNome());
		
		return this.estadoRepository.save(estadoAtual);
	}

	@Transactional
	public void remover(Long estadoId) {
		try {
			this.estadoRepository.deleteById(estadoId);
			this.estadoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new EstadoNaoEncontradoException(estadoId, e);
		}  catch (DataIntegrityViolationException e) {
			throw new EstadoEmUsoException(e);
		}
	}
}
