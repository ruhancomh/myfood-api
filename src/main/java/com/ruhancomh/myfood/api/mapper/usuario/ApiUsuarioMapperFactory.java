package com.ruhancomh.myfood.api.mapper.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ApiUsuarioMapperFactory {

	@Autowired
	@Lazy
	private FromUsuarioToUsuarioResource fromUsuarioToUsuarioResource;
	
	@Autowired
	@Lazy
	private FromListUsuarioToListUsuarioResource fromListUsuarioToListUsuarioResource;
	
	@Autowired
	@Lazy
	private FromCreateUsuarioRequestToCreateUsuarioDto fromCreateUsuarioRequestToCreateUsuarioDto;
	
	@Autowired
	@Lazy
	private FromUpdateUsuarioRequestToUpdateUsuarioDto fromUpdateUsuarioRequestToUpdateUsuarioDto;
	
	@Autowired
	@Lazy
	private FromUpdateUsuarioSenhaRequestToUpdateUsuarioSenhaDto fromUpdateUsuarioSenhaRequestToUpdateUsuarioSenhaDto;

}
