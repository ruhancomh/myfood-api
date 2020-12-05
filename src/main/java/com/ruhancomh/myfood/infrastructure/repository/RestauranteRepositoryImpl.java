package com.ruhancomh.myfood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.ruhancomh.myfood.domain.model.Restaurante;
import com.ruhancomh.myfood.domain.repository.CustomRestauranteRepository;

@Repository
public class RestauranteRepositoryImpl implements CustomRestauranteRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> findByNameAndTaxaFrete(String nome, BigDecimal taxaFreteInicial,
			BigDecimal taxaFreteFinal) {
		
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		
		CriteriaQuery<Restaurante> criteriaQuery = builder.createQuery(Restaurante.class);
		Root<Restaurante> rootQuery = criteriaQuery.from(Restaurante.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (StringUtils.hasLength(nome)) {
			StringBuilder nomeParam = new StringBuilder();
			nomeParam
				.append("%")
				.append(nome)
				.append("%");
			
			predicates.add(builder.like(rootQuery.get("nome"), nomeParam.toString()));
		}
		
		if (taxaFreteInicial != null) {
			predicates.add(
				builder.greaterThanOrEqualTo(rootQuery.get("taxaFrete"), taxaFreteInicial)
			);
		}
		
		if (taxaFreteFinal != null) {
			predicates.add(
				builder.lessThanOrEqualTo(rootQuery.get("taxaFrete"), taxaFreteFinal)
			);
		}
		
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		
		return this.manager.createQuery(criteriaQuery).getResultList();
	}

}
