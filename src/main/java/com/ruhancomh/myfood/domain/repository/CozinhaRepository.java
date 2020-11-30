package com.ruhancomh.myfood.domain.repository;

import java.util.List;

import com.ruhancomh.myfood.domain.model.Cozinha;

public interface CozinhaRepository {

	public List<Cozinha> listar();
	public Cozinha buscar(Long id);
	public Cozinha salvar(Cozinha cozinha);
	public void remover(Cozinha cozinha);
	
}
