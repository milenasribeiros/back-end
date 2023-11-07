package com.example.demo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Produto;
import com.example.demo.repositorio.ProdutoRepositorioJPA;

@Service
public class ProdutoServico {
	
	@Autowired
	private ProdutoRepositorioJPA produtoRepositorioJPA;
	
	public Produto insert(Produto produto) {
		return produtoRepositorioJPA.save(produto);
		
	}
	
	
	public List<Produto> findAll() {
		return produtoRepositorioJPA.findAll();
		
	}
	
	public Optional<Produto> findById(Integer id) {
		return produtoRepositorioJPA.findById(id);
		
	}
	
	public void delete(Integer id) {
		produtoRepositorioJPA.deleteById(id);
	}
	
	public Optional<Produto> findByIdPrecoJpql(Integer id, Double preco) {
		return produtoRepositorioJPA.findProdutoParam(id, preco);
		
	}
	
	public Optional<Produto> findByIdPrecoSql(Integer id, Double preco) {
		return produtoRepositorioJPA.findProdutoParamSql(id, preco);
		
	}
	

}
