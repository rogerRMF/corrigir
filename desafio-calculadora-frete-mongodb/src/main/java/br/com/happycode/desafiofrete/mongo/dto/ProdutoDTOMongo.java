package br.com.happycode.desafiofrete.mongo.dto;

public class ProdutoDTOMongo {
    private Long id;
    private String descricao;
    private Double valor;

    public ProdutoDTOMongo(Long id, String descricao, Double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public ProdutoDTOMongo(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
