package com.ruhancomh.myfood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ruhancomh.myfood.domain.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query("from Produto p where restaurante.id = :restauranteId and p.id = :produtoId")
	public Optional<Produto> findByIdAndRestauranteId(@Param("produtoId") Long produtoId,
			@Param("restauranteId") Long restauranteId);
	
	@Query("from Produto p where restaurante.id = :restauranteId")
	public List<Produto> findAllByRestaurante(@Param("restauranteId") Long restauranteId);
	
}
