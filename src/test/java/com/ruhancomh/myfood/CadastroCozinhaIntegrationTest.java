package com.ruhancomh.myfood;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ruhancomh.myfood.domain.exception.CozinhaNaoEncontradaException;
import com.ruhancomh.myfood.domain.exception.EntidadeEmUsoException;
import com.ruhancomh.myfood.domain.model.Cozinha;
import com.ruhancomh.myfood.domain.service.CadastroCozinhaService;

@SpringBootTest
class CadastroCozinhaIntegrationTest {

	@Autowired
	private CadastroCozinhaService cadastroCozinhaService;
	
	@Test
	public void shouldRegisterNewCozinhaWithSuccess() {
		// Arrange
		Cozinha cozinha = new Cozinha();
		cozinha.setNome("Cozinha de teste");
		
		// Act
		var result = this.cadastroCozinhaService.criar(cozinha);
		
		// Assert
		assertThat(result).isNotNull();
		assertThat(result.getId()).isNotNull();
		assertThat(result.getNome()).isEqualTo(cozinha.getNome());
	}
	
	@Test()
	public void shouldFailWhenRegisterNewCozinhaWithoutName() {
		// Arrange
		Cozinha cozinha = new Cozinha();
		
		// Act
		var result = assertThatThrownBy(() -> this.cadastroCozinhaService.criar(cozinha));
		
		// Assert
		result.isInstanceOf(ConstraintViolationException.class);
	}
	
	@Test
	public void deveFalhar_QuandoExcluirCozinhaEmUso() {
		// Arrange
		Long cozinhaId = 1L;
		
		// Act
		var result = assertThatThrownBy(() -> this.cadastroCozinhaService.remover(cozinhaId));
		
		// Assert
		result.isInstanceOf(EntidadeEmUsoException.class);
	}
	
	public void deveFalhar_QuandoExcluirCozinhaInexistente() {
		// Arrange
		Long cozinhaId = 1000L;
		
		// Act
		var result = assertThatThrownBy(() -> this.cadastroCozinhaService.remover(cozinhaId));
		
		// Assert
		result.isInstanceOf(CozinhaNaoEncontradaException.class);
	}

}
