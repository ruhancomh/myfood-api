package com.ruhancomh.myfood.domain.mapper.estado;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.dto.CreateEstadoDto;
import com.ruhancomh.myfood.domain.model.Estado;

@Component
public class FromCreateEstadoDtoToEstado implements Mapper<CreateEstadoDto, Estado> {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Estado map (CreateEstadoDto dto) {
		return this.modelMapper.map(dto, Estado.class);
	}
	
}
