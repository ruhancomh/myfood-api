package com.ruhancomh.myfood.api.mapper.grupo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ApiGrupoMapperFactory {

	@Autowired
	@Lazy
	private FromGrupoToGrupoResource fromGrupoToGrupoResource;
	
	@Autowired
	@Lazy
	private FromListGrupoToListGrupoResource fromListGrupoToListGrupoResource;
	
	@Autowired
	@Lazy
	private FromCreateGrupoRequestToCreateGrupoDto fromCreateGrupoRequestToCreateGrupoDto;
	
	@Autowired
	@Lazy
	private FromUpdateGrupoRequestToUpdateGrupoDto fromUpdateGrupoRequestToUpdateGrupoDto;
}
