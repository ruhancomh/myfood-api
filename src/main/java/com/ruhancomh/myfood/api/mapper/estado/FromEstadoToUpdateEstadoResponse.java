package com.ruhancomh.myfood.api.mapper.estado;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.estado.UpdateEstadoResponse;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.model.Estado;

@Component
@Lazy
public class FromEstadoToUpdateEstadoResponse implements Mapper<Estado, UpdateEstadoResponse> {

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UpdateEstadoResponse map(Estado source) {
		return this.modelMapper.map(source, UpdateEstadoResponse.class);
	}

}
