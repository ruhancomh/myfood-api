package com.ruhancomh.myfood.api.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruhancomh.myfood.domain.model.Restaurante;
import com.ruhancomh.myfood.domain.repository.RestauranteRepository;
import com.ruhancomh.myfood.infrastructure.repository.spec.RestauranteRepositorySpecFactory;

@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping("/restaurantes-por-nome-taxa")
	public List<Restaurante> buscaPorNomeETaxaFrete (String nome, BigDecimal taxaFreteInicial,
			BigDecimal taxaFreteFinal) {
		return this.restauranteRepository.findByNameAndTaxaFrete(nome, taxaFreteInicial, taxaFreteFinal);
	}
	
	@GetMapping("/restaurantes-com-frete-gratis")
	public List<Restaurante> buscaComFreteGratis (String nome) {
		return this.restauranteRepository.findComFreteGratis(nome);
	}
}
