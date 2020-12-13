package com.ruhancomh.myfood.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ruhancomh.myfood.domain.dto.CreateUsuarioDto;
import com.ruhancomh.myfood.domain.dto.UpdateUsuarioDto;
import com.ruhancomh.myfood.domain.dto.UpdateUsuarioSenhaDto;
import com.ruhancomh.myfood.domain.exception.SenhaAtualIncorretaException;
import com.ruhancomh.myfood.domain.exception.UsuarioNaoEncontradoException;
import com.ruhancomh.myfood.domain.model.Usuario;
import com.ruhancomh.myfood.domain.repository.UsuarioRepository;

@Service
public class CadastroUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listar() {
		return this.usuarioRepository.findAll();
	}
	
	public Usuario buscarOuFalhar(Long usuarioId) {
		return this.usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
	}
	
	@Transactional
	public Usuario cadastrar(CreateUsuarioDto dto) {
		Usuario usuario = new Usuario();
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(dto.getSenha());
		
		return this.usuarioRepository.save(usuario);
	}
	
	@Transactional
	public Usuario atualizar(Long usuarioId, UpdateUsuarioDto dto) {
		Usuario usuario = this.buscarOuFalhar(usuarioId);
		
		usuario.setEmail(dto.getEmail());
		usuario.setNome(dto.getNome());
		
		return this.usuarioRepository.save(usuario);
	}
	
	@Transactional
	public void atualizarSenha(Long usuarioId, UpdateUsuarioSenhaDto dto) {
		Usuario usuario = this.buscarOuFalhar(usuarioId);
		
		if (! usuario.getSenha().equals(dto.getSenhaAtual())) {
			throw new SenhaAtualIncorretaException();
		}
		
		usuario.setSenha(dto.getNovaSenha());
		
		this.usuarioRepository.save(usuario);
		this.usuarioRepository.flush();
	}
	
	public void remover(Long usuarioId) {
		try {
			this.usuarioRepository.deleteById(usuarioId);
			this.usuarioRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new UsuarioNaoEncontradoException(usuarioId, e);
		}
	}
	
}
