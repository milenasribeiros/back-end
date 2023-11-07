package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Pedido;

public interface PedidoRepositorioJpa extends JpaRepository<Pedido, Integer> {

	
	
}
