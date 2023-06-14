package br.com.happycode.desafiofrete.model;

import br.com.happycode.desafiofrete.exception.PrecoInvalidoException;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Double valor;

    public Produto(String descricao, Double valor) throws PrecoInvalidoException {
        if (valor == null || valor <= 0) {
            throw new PrecoInvalidoException("O valor do produto " + descricao + " está inválido pois deve ser maior que zero !");
        }
        this.descricao = descricao;
        this.valor = valor;
    }

    public Produto() {

    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

