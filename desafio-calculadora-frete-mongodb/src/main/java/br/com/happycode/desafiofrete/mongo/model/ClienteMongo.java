package br.com.happycode.desafiofrete.mongo.model;

import br.com.calculadora.fretehttpcliente.UF;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.time.LocalDate;
@Document(collection = "cliente")
public class ClienteMongo {
    @Id
    @Field("_id")
    private Long id;
    private String nome;
    private LocalDate dataDeAniversario;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private UF uf;

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

    public String getCep() {
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

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }
}
