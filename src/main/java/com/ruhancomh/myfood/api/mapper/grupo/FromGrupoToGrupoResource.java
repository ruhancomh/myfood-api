package com.ruhancomh.myfood.api.mapper.grupo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.grupo.GrupoRessource;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.model.Grupo;

@Component
@Lazy
public class FromGrupoToGrupoResource
	extends BaseModelMapper<Grupo, GrupoRessource> {

	public FromGrupoToGrupoResource() {
		super(GrupoRessource.class);
	}

}
