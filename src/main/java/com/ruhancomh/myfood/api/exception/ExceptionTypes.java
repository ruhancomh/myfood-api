package com.ruhancomh.myfood.api.exception;

import lombok.Getter;

@Getter
public enum ExceptionTypes {
	ENTIDADE_EM_USO("Entidade em uso", "ENTIDADE_EM_USO"),
	RECURSO_NAO_ENCONTRADO("Recurso não encontrado", "RECURSO_NAO_ENCONTRADO"),
	ENTIDADE_RELACIONADA_NAO_ENCONTRADA("Entidade relacionada não encontrada", "ENTIDADE_RELACIONADA_NAO_ENCONTRADA"),
	NEGOCIO("Exceção de negócio", "NEGOCIO_EXCEPTION"),
	NAO_MAPEADA("Exceção não mapeada", "NAO_MAPEADA");
	
	private String title;
	private String type;
	
	private ExceptionTypes(String title, String type) {
		this.title = title;
		this.type = type;
	}
}
