package com.ruhancomh.myfood.api.mapper.formaPagamento;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.formaPagamento.FormaPagamentoResource;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.model.FormaPagamento;

@Component
@Lazy
public class FromFormaPagamentoToFormaPagamentoResource
	extends BaseModelMapper<FormaPagamento, FormaPagamentoResource> {

	public FromFormaPagamentoToFormaPagamentoResource() {
		super(FormaPagamentoResource.class);
	}

}
