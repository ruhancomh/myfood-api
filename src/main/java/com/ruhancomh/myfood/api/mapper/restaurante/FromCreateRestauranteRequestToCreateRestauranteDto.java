package com.ruhancomh.myfood.api.mapper.restaurante;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.restaurante.CreateRestauranteRequest;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.dto.CreateRestauranteDto;

@Component
@Lazy
public class FromCreateRestauranteRequestToCreateRestauranteDto
	extends BaseModelMapper<CreateRestauranteRequest, CreateRestauranteDto> {

	public FromCreateRestauranteRequestToCreateRestauranteDto() {
		super(CreateRestauranteDto.class);
	}

}
