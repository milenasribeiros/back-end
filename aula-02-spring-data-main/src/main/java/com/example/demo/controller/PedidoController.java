package com.example.demo.controller;

import dtos.PedidoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entidades.Pedido;
import com.example.demo.servicos.PedidoServico;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoServico servico;
	
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody PedidoDto pedido){
		PedidoDto prod = servico.insert(pedido);
		return prod !=  null ? new ResponseEntity<>("Pedido criado com sucesso", HttpStatus.CREATED) : new ResponseEntity<>("Erro ao criar produto", HttpStatus.BAD_REQUEST);
		
	}

	@GetMapping
	public ResponseEntity<List<PedidoDto>> findAll(){
		List<PedidoDto> list = servico.findAll();
		return !list.isEmpty() ?  new ResponseEntity<>(list, HttpStatus.OK)
				: new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
	}
	

}
