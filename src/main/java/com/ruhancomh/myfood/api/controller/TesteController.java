package com.ruhancomh.myfood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruhancomh.myfood.domain.model.Restaurante;
import com.ruhancomh.myfood.domain.repository.RestauranteRepository;

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
	
	@GetMapping("/restaurantes/primeiro")
	public Optional<Restaurante> buscaPrimeiroRestaurante () {
		return this.restauranteRepository.buscarPrimeiro();
	}
}
