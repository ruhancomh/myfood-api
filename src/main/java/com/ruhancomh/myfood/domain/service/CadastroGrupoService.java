package com.ruhancomh.myfood.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ruhancomh.myfood.domain.dto.CreateGrupoDto;
import com.ruhancomh.myfood.domain.dto.UpdateGrupoDto;
import com.ruhancomh.myfood.domain.exception.GrupoEmUsoException;
import com.ruhancomh.myfood.domain.exception.GrupoNaoEncontradoException;
import com.ruhancomh.myfood.domain.model.Grupo;
import com.ruhancomh.myfood.domain.repository.GrupoRespository;

@Service
public class CadastroGrupoService {
	
	@Autowired
	private GrupoRespository grupoRepository;
	
	public List<Grupo> listar() {
		return this.grupoRepository.findAll();
	}
	
	public Grupo buscarOuFalhar(Long grupoId) {
		return this.grupoRepository.findById(grupoId)
				.orElseThrow(() -> new GrupoNaoEncontradoException(grupoId));
	}
	
	@Transactional
	public Grupo criar(CreateGrupoDto dto) {
		Grupo grupo = new Grupo();
		grupo.setNome(dto.getNome());
		
		return this.grupoRepository.save(grupo);
	}
	
	@Transactional
	public Grupo atualizar(Long grupoId, UpdateGrupoDto dto) {
		var grupo = this.buscarOuFalhar(grupoId);
		grupo.setNome(dto.getNome());
		
		return this.grupoRepository.save(grupo);
	}
	
	@Transactional
	public void remover(Long grupoId) {
		try {
			this.grupoRepository.deleteById(grupoId);
			this.grupoRepository.flush();
		}  catch (EmptyResultDataAccessException e) {
			throw new GrupoNaoEncontradoException(grupoId, e);
		} catch (DataIntegrityViolationException e) {
			throw new GrupoEmUsoException(e);
		}
	}
}
