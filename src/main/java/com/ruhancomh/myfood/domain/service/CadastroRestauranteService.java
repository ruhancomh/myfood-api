package com.ruhancomh.myfood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruhancomh.myfood.domain.exception.RecursoNaoEncontradoException;
import com.ruhancomh.myfood.domain.model.Restaurante;
import com.ruhancomh.myfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public List<Restaurante> listar () {
		return this.restauranteRepository.listar();
	}
	
	public Restaurante buscar (Long id) {
		Restaurante restaurante = this.restauranteRepository.buscar(id);
		
		if (restaurante == null) {
			throw new RecursoNaoEncontradoException("restaurante", id);
		}
		
		return restaurante;
	}
}
