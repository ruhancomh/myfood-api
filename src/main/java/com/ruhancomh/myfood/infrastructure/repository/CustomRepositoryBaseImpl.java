package com.ruhancomh.myfood.infrastructure.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.ruhancomh.myfood.domain.repository.CustomRepositoryBase;

public class CustomRepositoryBaseImpl<T, ID> extends SimpleJpaRepository<T, ID>
	implements CustomRepositoryBase<T, ID> {

	private EntityManager manager;
	
	public CustomRepositoryBaseImpl(JpaEntityInformation<T, ?> entityInformation,
			EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.manager = entityManager;
	}

	@Override
	public Optional<T> buscarPrimeiro() {
		
		var jpql = (new StringBuilder())
				.append("from ")
				.append(this.getDomainClass().getName());
		
		T entity = this.manager.createQuery(jpql.toString(), this.getDomainClass())
				.setMaxResults(1)
				.getSingleResult();
		
		return Optional.ofNullable(entity);
	}

}
