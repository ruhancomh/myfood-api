package com.ruhancomh.myfood.api.mapper.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class ApiRestauranteMapperFactory {

	@Autowired
	@Lazy
	private FromRestauranteToRestauranteResource fromRestauranteToRestauranteResource;
	
}
