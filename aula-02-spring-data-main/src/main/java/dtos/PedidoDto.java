package dtos;

import com.example.demo.entidades.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoDto {
    private Integer id;
    private String endereco;
    private List<ProdutoDto> produtos = new ArrayList<>();

    public PedidoDto() {}

    public PedidoDto(Integer id, String endereco) {
        super();
        this.id = id;
        this.endereco = endereco;
    }


    public PedidoDto(Pedido pedido) {
        id = pedido.getId();
        endereco = pedido.getEndereco();
        produtos = pedido.getProdutos().stream().map(x -> new ProdutoDto(x)).collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<ProdutoDto> getProdutos() {
        return produtos;
    }

}
