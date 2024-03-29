package com.ruhancomh.myfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruhancomh.myfood.domain.model.FormaPagamento;

@Repository
public interface FormaPagamentoRepository
	extends JpaRepository<FormaPagamento, Long>, FormaPagamentoRepositoryCustom{
}
