package com.ruhancomh.myfood.infrastructure.repository.spec;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.domain.model.Restaurante;

@Component
public class RestauranteRepositorySpecFactory {
	
	public Specification<Restaurante> comFreteGratis() {
		return new RestauranteComFreteGratisSpec();
	}
	
	public Specification<Restaurante> comNomeSemelhante(String nome) {
		return new RestauranteComNomeSemelhanteSpec(nome);
	}
	
}
