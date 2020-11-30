package com.ruhancomh.myfood.domain.repository;

import java.util.List;

import com.ruhancomh.myfood.domain.model.Cidade;

public interface CidadeRepository {

	public List<Cidade> listar ();
	public Cidade buscar (Long id);
	public Cidade salvar (Cidade cidade);
	public void remover (Cidade cidade);
	
}
