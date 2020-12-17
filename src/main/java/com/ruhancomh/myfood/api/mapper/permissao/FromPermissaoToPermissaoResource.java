package com.ruhancomh.myfood.api.mapper.permissao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.permissao.PermissaoRessource;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.model.Permissao;

@Component
@Lazy
public class FromPermissaoToPermissaoResource
 extends BaseModelMapper<Permissao, PermissaoRessource>{

	public FromPermissaoToPermissaoResource() {
		super(PermissaoRessource.class);
	}

}
