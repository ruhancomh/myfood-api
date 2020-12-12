package com.ruhancomh.myfood.domain.mapper.estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class EstadoMapperFactory {

	@Autowired
	private FromCreateEstadoDtoToEstado fromCreateEstadoDtoToEstado;
	
}
