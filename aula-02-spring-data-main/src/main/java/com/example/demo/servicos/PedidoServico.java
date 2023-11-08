package com.example.demo.servicos;

import com.example.demo.entidades.Produto;
import com.example.demo.repositorio.ProdutoRepositorioJPA;
import dtos.PedidoDto;
import dtos.ProdutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Pedido;
import com.example.demo.repositorio.PedidoRepositorioJpa;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServico {
	
	
	@Autowired
	private PedidoRepositorioJpa repository;

	@Autowired
	private ProdutoRepositorioJPA produtoRepositorioJPA;


	@Transactional
	public PedidoDto insert(PedidoDto pedido) {
		Pedido ped = new Pedido(pedido.getEndereco());

		for(ProdutoDto p : pedido.getProdutos()) {
			Produto produto = produtoRepositorioJPA.getReferenceById(p.getId());
			ped.getProdutos().add(produto);
		}

		ped = repository.save(ped);
		return new PedidoDto(ped);

	}

	@Transactional(readOnly = true)
	public List<PedidoDto> findAll (){
		List<Pedido> list = repository.findAll();
		return list.stream().map(x -> new PedidoDto(x)).collect(Collectors.toList());
	}

}
