package com.ruhancomh.myfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.domain.model.Restaurante;
import com.ruhancomh.myfood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryJPA implements RestauranteRepository {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Restaurante> listar() {
		return this.manager.createQuery("from restaurantes", Restaurante.class).getResultList();
	}

	@Override
	public Restaurante buscar(Long id) {
		return this.manager.find(Restaurante.class, id);
	}

	@Override
	public Restaurante salvar(Restaurante restaurante) {
		return this.manager.merge(restaurante);
	}

	@Override
	public void remover(Restaurante restaurante) {
		restaurante = this.buscar(restaurante.getId());
		this.manager.remove(restaurante);
	}

}