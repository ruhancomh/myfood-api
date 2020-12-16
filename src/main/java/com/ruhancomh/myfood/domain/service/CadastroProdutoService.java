package com.ruhancomh.myfood.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruhancomh.myfood.domain.dto.CreateProdutoDto;
import com.ruhancomh.myfood.domain.dto.UpdateProdutoDto;
import com.ruhancomh.myfood.domain.exception.ProdutoNaoEncontradoException;
import com.ruhancomh.myfood.domain.model.Produto;
import com.ruhancomh.myfood.domain.repository.ProdutoRepository;

@Service
public class CadastroProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CadastroRestauranteService cadastroRestauranteService;
	
	public List<Produto> listarPorRestaurante(Long restauranteId){
		return this.produtoRepository.findAllByRestaurante(restauranteId);
	}
	
	public Produto buscarPorRestauranteOuFalhar(Long restauranteId, Long produtoId) {
		return this.produtoRepository.findByIdAndRestauranteId(produtoId, restauranteId)
				.orElseThrow(() -> new ProdutoNaoEncontradoException(produtoId, restauranteId));
	}
	
	@Transactional
	public Produto cadastrar(Long restauranteId, CreateProdutoDto dto) {
		var restaurante = this.cadastroRestauranteService.buscarOuFalhar(restauranteId);
		
		var produto = new Produto();
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setPreco(dto.getPreco());
		produto.setAtivo(dto.getAtivo());
		produto.setRestaurante(restaurante);
		
		return this.produtoRepository.save(produto);
	}
	
	@Transactional
	public Produto atualizar(Long restauranteId, Long produtoId, UpdateProdutoDto dto) {
		var produto = this.buscarPorRestauranteOuFalhar(restauranteId, produtoId);
		
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setPreco(dto.getPreco());
		produto.setAtivo(dto.getAtivo());
		
		return this.produtoRepository.save(produto);
	}
	
}
