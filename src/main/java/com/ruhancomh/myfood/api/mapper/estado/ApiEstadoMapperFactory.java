package com.ruhancomh.myfood.api.mapper.estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class ApiEstadoMapperFactory {

	@Autowired
	private FromCreateEstadoRequestToCreateEstadoDto fromCreateEstadoRequestToCreateEstadoDto;
	
	@Autowired
	private FromEstadoToCreateEstadoResponse fromEstadoToCreateEstadoResponse;
	
	@Autowired
	private FromUpdateEstadoRequestToUpdateEstadoDto fromUpdateEstadoRequestToUpdateEstadoDto;

	@Autowired
	private FromEstadoToUpdateEstadoResponse fromEstadoToUpdateEstadoResponse;
}
