package com.ruhancomh.myfood.api.mapper.estado;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.estado.CreateEstadoRequest;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.dto.CreateEstadoDto;

@Component
@Lazy
public class FromCreateEstadoRequestToCreateEstadoDto implements Mapper<CreateEstadoRequest, CreateEstadoDto> {

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CreateEstadoDto map(CreateEstadoRequest source) {
		return this.modelMapper.map(source, CreateEstadoDto.class);
	}

}
