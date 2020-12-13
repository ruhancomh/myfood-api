package com.ruhancomh.myfood.api.mapper.formaPagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ApiFormaPagamentoMapperFactory {

	@Autowired
	@Lazy
	private FromFormaPagamentoToFormaPagamentoResource fromFormaPagamentoToFormaPagamentoResource;
	
	@Autowired
	@Lazy
	private FromListFormaPagamentoToListFormaPagamentoResource fromListFormaPagamentoToListFormaPagamentoResource;

	@Autowired
	@Lazy
	private FromCreateFormaPagamentoRequestToCreateFormaPagamentoDto fromCreateFormaPagamentoRequestToCreateFormaPagamentoDto;

	@Autowired
	@Lazy
	private FromUpdateFormaPagamentoRequestToUpdateFormaPagamentoDto fromUpdateFormaPagamentoRequestToUpdateFormaPagamentoDto;
	
}
