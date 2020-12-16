package com.ruhancomh.myfood.api.mapper.produto;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.produto.SimpleProdutoResource;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.model.Produto;

@Component
@Lazy
public class FromProdutoToSimpleProdutoResource extends BaseModelMapper<Produto, SimpleProdutoResource> {

	public FromProdutoToSimpleProdutoResource() {
		super(SimpleProdutoResource.class);
	}

}
