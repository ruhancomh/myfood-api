package com.ruhancomh.myfood.api.mapper.produto;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.produto.CreateProdutoRequest;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.dto.CreateProdutoDto;

@Component
@Lazy
public class FromCreateProdutoRequestToCreateProdutoDto
	extends BaseModelMapper<CreateProdutoRequest, CreateProdutoDto> {

	public FromCreateProdutoRequestToCreateProdutoDto() {
		super(CreateProdutoDto.class);
	}

}
