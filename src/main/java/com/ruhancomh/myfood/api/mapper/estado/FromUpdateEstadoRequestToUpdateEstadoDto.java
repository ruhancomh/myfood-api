package com.ruhancomh.myfood.api.mapper.estado;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.estado.UpdateEstadoResquest;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.dto.UpdateEstadoDto;

@Component
@Lazy
public class FromUpdateEstadoRequestToUpdateEstadoDto implements Mapper<UpdateEstadoResquest, UpdateEstadoDto> {

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UpdateEstadoDto map(UpdateEstadoResquest source) {
		return this.modelMapper.map(source, UpdateEstadoDto.class);
	}

}
