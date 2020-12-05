package com.ruhancomh.myfood.domain.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ruhancomh.myfood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository
	extends CustomRepositoryBase<Restaurante, Long>, RestauranteRepositoryCustom,
	JpaSpecificationExecutor<Restaurante> {
}
