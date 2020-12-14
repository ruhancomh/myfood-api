package com.ruhancomh.myfood.api.mapper.estado;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.estado.UpdateEstadoResquest;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.dto.UpdateEstadoDto;

@Component
@Lazy
public class FromUpdateEstadoRequestToUpdateEstadoDto
	extends BaseModelMapper<UpdateEstadoResquest, UpdateEstadoDto> {

	public FromUpdateEstadoRequestToUpdateEstadoDto() {
		super(UpdateEstadoDto.class);
	}

}
