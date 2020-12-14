package com.ruhancomh.myfood.api.mapper.formaPagamento;

import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.formaPagamento.CreateFormaPagamentoRequest;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.dto.CreateFormaPagamentoDto;

@Component
public class FromCreateFormaPagamentoRequestToCreateFormaPagamentoDto
	extends BaseModelMapper<CreateFormaPagamentoRequest, CreateFormaPagamentoDto> {

	public FromCreateFormaPagamentoRequestToCreateFormaPagamentoDto() {
		super(CreateFormaPagamentoDto.class);
	}

}
