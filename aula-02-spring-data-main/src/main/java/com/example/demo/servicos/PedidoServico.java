package com.example.demo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Pedido;
import com.example.demo.repositorio.PedidoRepositorioJpa;

@Service
public class PedidoServico {
	
	
	@Autowired
	private PedidoRepositorioJpa repository;
	
	
	public Pedido insert(Pedido pedido) {
		return repository.save(pedido);
		
	}

}
