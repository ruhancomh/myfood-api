package com.ruhancomh.myfood.api.mapper.restaurante;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.restaurante.CreateRestauranteRequest;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.dto.CreateRestauranteDto;

@Component
@Lazy
public class FromCreateRestauranteRequestToCreateRestauranteDto
	implements Mapper<CreateRestauranteRequest, CreateRestauranteDto>{

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CreateRestauranteDto map(CreateRestauranteRequest source) {
		return this.modelMapper.map(source, CreateRestauranteDto.class);
	}

}
