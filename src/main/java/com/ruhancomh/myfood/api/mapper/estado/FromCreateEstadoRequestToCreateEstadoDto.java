package com.ruhancomh.myfood.api.mapper.estado;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.estado.CreateEstadoRequest;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.dto.CreateEstadoDto;

@Component
@Lazy
public class FromCreateEstadoRequestToCreateEstadoDto
	extends BaseModelMapper<CreateEstadoRequest, CreateEstadoDto> {

	public FromCreateEstadoRequestToCreateEstadoDto() {
		super(CreateEstadoDto.class);
	}

}
