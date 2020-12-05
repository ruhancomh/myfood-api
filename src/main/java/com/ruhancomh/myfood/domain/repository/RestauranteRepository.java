package com.ruhancomh.myfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ruhancomh.myfood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository
	extends JpaRepository<Restaurante, Long>, RestauranteRepositoryCustom,
	JpaSpecificationExecutor<Restaurante> {
}
