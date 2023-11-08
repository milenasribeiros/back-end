package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import dtos.ProdutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Produto;
import com.example.demo.servicos.ProdutoServico;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoServico servico;

	@PostMapping
	public ResponseEntity<String> insert(@RequestBody ProdutoDto produto){
		ProdutoDto prod = servico.create(produto);
		return prod !=  null ? new ResponseEntity<>("Produto criado com sucesso", HttpStatus.CREATED)
				: new ResponseEntity<>("Erro ao criar produto", HttpStatus.BAD_REQUEST);
	}


	@GetMapping
	public ResponseEntity<List<ProdutoDto>> findAll(){
		List<ProdutoDto> list = servico.findAll();
		return !list.isEmpty() ?  new ResponseEntity<>(list, HttpStatus.OK)
				: new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/produto-jpa-id/{id}")
	public ResponseEntity<Optional<ProdutoDto>> findById(@PathVariable Integer id){
		Optional<ProdutoDto> prod = servico.findById(id);
		return prod.isPresent() ?  new ResponseEntity<>(prod, HttpStatus.OK)
				: new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/produto-update")
	public ResponseEntity<String> update(@RequestBody ProdutoDto produto) {
		ProdutoDto prod = servico.create(produto);
		return prod != null ? new ResponseEntity<>("Produto atualizado com sucesso", HttpStatus.OK)
				: new ResponseEntity<>("Erro ao atualizar produto", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/produto-delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		servico.delete(id);
		Optional<ProdutoDto> prod = servico.findById(id);
		return !prod.isPresent() ? new ResponseEntity<>("Produto deletado com sucesso", HttpStatus.OK)
							 : new ResponseEntity<>("Erro ao deletar produto", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/produto-jpa-id-preco-jpql/{id}/{preco}")
	public ResponseEntity<Optional<ProdutoDto>> findByIdPrecoJpql(@PathVariable Integer id, @PathVariable Double preco){
		Optional<ProdutoDto> prod = servico.findProdutoParam(id, preco);
		return prod.isPresent() ?  new ResponseEntity<>(prod, HttpStatus.OK)
				: new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/produto-jpa-id-nome-sql/{id}/{preco}")
	public ResponseEntity<Optional<ProdutoDto>> findByIdNomeSql(@PathVariable Integer id, @PathVariable String nome){
		Optional<ProdutoDto> prod = servico.findProdutoNomeSQL(id, nome);
		return prod.isPresent() ?  new ResponseEntity<>(prod, HttpStatus.OK)
				: new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
	}
}
