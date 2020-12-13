package com.ruhancomh.myfood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ruhancomh.myfood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository
	extends CustomRepositoryBase<Restaurante, Long>, RestauranteRepositoryCustom,
	JpaSpecificationExecutor<Restaurante> {
	
	@Query("from Restaurante r join fetch r.cozinha")
	public List<Restaurante> findAll();
	
}
