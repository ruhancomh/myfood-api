package com.ruhancomh.myfood.api.mapper.permissao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ApiPermissaoMapperFactory {

	@Autowired
	@Lazy
	private FromPermissaoToPermissaoResource fromPermissaoToPermissaoResource;
	
	@Autowired
	@Lazy
	private FromListPermissaoToListPermissaoRessource fromListPermissaoToListPermissaoRessource;
	
}
