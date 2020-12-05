package com.ruhancomh.myfood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.ruhancomh.myfood.domain.model.Restaurante;

public interface RestauranteRepositoryCustom {

	public List<Restaurante> findByNameAndTaxaFrete(String nome, BigDecimal taxaFreteInicial,
			BigDecimal taxaFreteFinal);
	
	public List<Restaurante> findComFreteGratis(String nome);
}
