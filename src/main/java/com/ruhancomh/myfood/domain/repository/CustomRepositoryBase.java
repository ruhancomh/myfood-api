package com.ruhancomh.myfood.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomRepositoryBase<T, ID> extends JpaRepository<T, ID> {

	public Optional<T> buscarPrimeiro();
	
}
