package com.ruhancomh.myfood.api.mapper.estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class ApiEstadoMapperFactory {

	@Autowired
	@Lazy
	private FromCreateEstadoRequestToCreateEstadoDto fromCreateEstadoRequestToCreateEstadoDto;
	
	@Autowired
	@Lazy
	private FromEstadoToCreateEstadoResponse fromEstadoToCreateEstadoResponse;
	
	@Autowired
	@Lazy
	private FromUpdateEstadoRequestToUpdateEstadoDto fromUpdateEstadoRequestToUpdateEstadoDto;

	@Autowired
	@Lazy
	private FromEstadoToUpdateEstadoResponse fromEstadoToUpdateEstadoResponse;
}
