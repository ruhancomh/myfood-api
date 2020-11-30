package com.ruhancomh.myfood.domain.repository;

import java.util.List;

import com.ruhancomh.myfood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {

	public List<FormaPagamento> listar ();
	public FormaPagamento buscar (Long id);
	public FormaPagamento salvar (FormaPagamento formaPagamento);
	public void remover (FormaPagamento formaPagamento);
	
}
