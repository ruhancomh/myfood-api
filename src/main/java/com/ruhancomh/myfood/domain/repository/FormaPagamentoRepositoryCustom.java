package com.ruhancomh.myfood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ruhancomh.myfood.domain.model.FormaPagamento;

@Repository
public interface FormaPagamentoRepositoryCustom {

	@Query("select fp from FormaPagamento fp join fp.restaurantes r where r.id = :restauranteId")
	public List<FormaPagamento> findByRestaurante(@Param("restauranteId") Long restauranteId);
	
}
