package com.ruhancomh.myfood.api.mapper.produto;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.produto.UpdateProdutoRequest;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.dto.UpdateProdutoDto;

@Component
@Lazy
public class FromUpdateProdutoRequestToUpdateProdutoDto
	extends BaseModelMapper<UpdateProdutoRequest, UpdateProdutoDto> {

	public FromUpdateProdutoRequestToUpdateProdutoDto() {
		super(UpdateProdutoDto.class);
	}

}
