package com.example.demo.servicos;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dtos.ProdutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Produto;
import com.example.demo.repositorio.ProdutoRepositorioJPA;

@Service
public class ProdutoServico {
	
	@Autowired
	private ProdutoRepositorioJPA produtoRepositorioJPA;


	public ProdutoDto create(ProdutoDto produto){
		Produto prod = new Produto(produto.getId(), produto.getNome(), produto.getPreco());
		return new ProdutoDto(produtoRepositorioJPA.save(prod));
	}


	public List<ProdutoDto> findAll(){
		List<Produto> list = produtoRepositorioJPA.findAll();
		return list.stream().map(x -> new ProdutoDto(x)).collect(Collectors.toList());

	}

	public Optional<ProdutoDto> findById(Integer id) {
		Optional<Produto> prod = produtoRepositorioJPA.findById(id);
		Optional<ProdutoDto> prodDto = prod.map(produto -> {
			return new ProdutoDto(produto.getId(), produto.getNome(), produto.getPreco());
		});
		return prodDto;
	}
	
	public void delete(Integer id) {
		produtoRepositorioJPA.deleteById(id);
	}

	public Optional<ProdutoDto> findProdutoParam(Integer id, Double preco){
		Optional<Produto> produtoEncontrado = produtoRepositorioJPA.findProdutoParam(id, preco);
		Optional<ProdutoDto> produtoDtoEncontrado = produtoEncontrado.map(produto -> {
			return new ProdutoDto(produto.getId(), produto.getNome(), produto.getPreco());
		});
		return produtoDtoEncontrado;
	}

	public Optional<ProdutoDto> findProdutoNome(Integer id, String nome){
		Optional<Produto> produtoEncontradoNome = produtoRepositorioJPA.findProdutoByNome(id, nome);
		Optional<ProdutoDto> produtoDtoEncontradoNome = produtoEncontradoNome.map(produto -> {
			return new ProdutoDto(produto.getId(), produto.getNome(), produto.getPreco());
		});
		return produtoDtoEncontradoNome;
	}

	public Optional<ProdutoDto> findProdutoNomeSQL(Integer id, String nome){
		Optional<Produto> produtoEncontradoNomeSQL = produtoRepositorioJPA.findProdutoByNomeSQL(id, nome);
		Optional<ProdutoDto> produtoDtoEncontrado = produtoEncontradoNomeSQL.map(produto -> {
			return new ProdutoDto(produto.getId(), produto.getNome(), produto.getPreco());
		});
		return produtoDtoEncontrado;
	}


}
