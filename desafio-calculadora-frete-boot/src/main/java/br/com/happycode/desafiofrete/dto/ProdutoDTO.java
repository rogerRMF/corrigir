package br.com.happycode.desafiofrete.dto;


public class ProdutoDTO {
    private Long id;
    private String descricao;
    private Double valor;

    public ProdutoDTO(long l, String s, double v) {
    }

    public ProdutoDTO() {

    }

    // getters e setters


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
