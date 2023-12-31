package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Pedido;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepositorioJpa extends JpaRepository<Pedido, Integer> {

    @Query("SELECT ped FROM Pedido ped JOIN FETCH ped.produtos")
    List<Pedido> findJoinProduto();

    @Query(value = "SELECT p.id,"
            + "p.endereco,"
            + "pr.id,"
            + "pr.nome,"
            + "pr.pr_preco"
            + "FROM tb_pedido_produto ped"
            + "JOIN tb_pedido p ON ped.pedido_id = p.id"
            + "JOIN tb_produto pr ON ped.produto_id = pr.id", nativeQuery = true)
    List<Pedido> findJoinProdutoSql();
	
}
