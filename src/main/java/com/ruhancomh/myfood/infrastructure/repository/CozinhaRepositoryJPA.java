package com.ruhancomh.myfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.domain.model.Cozinha;
import com.ruhancomh.myfood.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryJPA implements CozinhaRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cozinha> listar() {
		return this.manager.createQuery("from cozinhas", Cozinha.class).getResultList();
	}

	@Override
	public Cozinha buscar(Long id) {
		return this.manager.find(Cozinha.class, id);
	}

	@Override
	public Cozinha salvar(Cozinha cozinha) {
		return this.manager.merge(cozinha);
	}

	@Override
	public void remover(Cozinha cozinha) {
		cozinha = this.buscar(cozinha.getId());
		this.manager.remove(cozinha);	
	}

}
