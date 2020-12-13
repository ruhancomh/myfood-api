package com.ruhancomh.myfood.api.mapper.estado;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.estado.CreateEstadoResponse;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.model.Estado;

@Component
@Lazy
public class FromEstadoToCreateEstadoResponse implements Mapper<Estado, CreateEstadoResponse> {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CreateEstadoResponse map(Estado source) {
		return this.modelMapper.map(source, CreateEstadoResponse.class);
	}
	
}
