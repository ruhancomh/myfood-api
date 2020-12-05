package com.ruhancomh.myfood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.ruhancomh.myfood.domain.model.Restaurante;

public interface CustomRestauranteRepository {

	public List<Restaurante> findByNameAndTaxaFrete(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
	
}
