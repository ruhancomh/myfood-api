package com.ruhancomh.myfood.api.mapper.restaurante;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.restaurante.RestauranteResource;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.model.Restaurante;

@Component
@Lazy
public class FromRestauranteToRestauranteResource implements Mapper<Restaurante, RestauranteResource> {

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public RestauranteResource map(Restaurante source) {
		return this.modelMapper.map(source, RestauranteResource.class);
	}

}
