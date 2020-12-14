package com.ruhancomh.myfood.api.mapper.formaPagamento;

import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.request.formaPagamento.UpdateFormaPagamentoRequest;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.dto.UpdateFormaPagamentoDto;

@Component
public class FromUpdateFormaPagamentoRequestToUpdateFormaPagamentoDto
	extends BaseModelMapper<UpdateFormaPagamentoRequest, UpdateFormaPagamentoDto> {

	public FromUpdateFormaPagamentoRequestToUpdateFormaPagamentoDto() {
		super(UpdateFormaPagamentoDto.class);
	}

}
