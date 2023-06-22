package br.com.happycode.desafiofrete.mongo.dto;

import java.time.LocalDate;

public class ClienteDTOMongo {

    private Long id;
    private String nome;
    private LocalDate dataDeAniversario = LocalDate.now();
    private static String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeAniversario() {
        return dataDeAniversario;
    }

    public void setDataDeAniversario(LocalDate dataDeAniversario) {
        this.dataDeAniversario = dataDeAniversario;
    }

    public static String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
