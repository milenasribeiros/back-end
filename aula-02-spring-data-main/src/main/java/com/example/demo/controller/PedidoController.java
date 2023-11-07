package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Pedido;
import com.example.demo.entidades.Produto;
import com.example.demo.servicos.PedidoServico;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoServico servico;
	
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody Pedido pedido){
		Pedido prod = servico.insert(pedido);
		return prod !=  null ? new ResponseEntity<>("Pedido criado com sucesso", HttpStatus.CREATED) : new ResponseEntity<>("Erro ao criar produto", HttpStatus.BAD_REQUEST);
		
	}
	

}
