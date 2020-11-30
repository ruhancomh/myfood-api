package com.ruhancomh.myfood.domain.repository;

import java.util.List;

import com.ruhancomh.myfood.domain.model.Permissao;

public interface PermissaoRepository {

	public List<Permissao> listar ();
	public Permissao buscar (Long id);
	public Permissao salvar (Permissao permissao);
	public void remover (Permissao permissao);
	
}
