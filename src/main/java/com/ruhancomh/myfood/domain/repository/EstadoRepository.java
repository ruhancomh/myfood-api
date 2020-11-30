package com.ruhancomh.myfood.domain.repository;

import java.util.List;

import com.ruhancomh.myfood.domain.model.Estado;

public interface EstadoRepository {

	public List<Estado> listar ();
	public Estado buscar (Long id);
	public Estado salvar (Estado estado);
	public void remover (Estado estado);
	
}
