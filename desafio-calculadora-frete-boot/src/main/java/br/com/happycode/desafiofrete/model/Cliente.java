package br.com.happycode.desafiofrete.model;


import br.com.happycode.desafiofrete.UF;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;


@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataDeAniversario;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private UF uf;

    public Cliente() {
        this.nome = nome;
        this.dataDeAniversario = dataDeAniversario;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

        public String getNome () {
            return nome;
        }

        public void setNome (String nome){
            this.nome = nome;
        }

        public LocalDate getDataDeAniversario () {
            return dataDeAniversario;
        }

        public void setDataDeAniversario (LocalDate dataDeAniversario){
            this.dataDeAniversario = dataDeAniversario;
        }

        public String getCep () {
            return cep;
        }

        public void setCep (String cep){
            this.cep = cep;
        }

        public String getLogradouro () {
            return logradouro;
        }

        public void setLogradouro (String logradouro){
            this.logradouro = logradouro;
        }

        public String getBairro () {
            return bairro;
        }

        public void setBairro (String bairro){
            this.bairro = bairro;
        }

        public String getCidade () {
            return cidade;
        }

        public void setCidade (String cidade){
            this.cidade = cidade;
        }

        public UF getUf () {
            return uf;
        }

        public void setUf (UF uf){
            this.uf = uf;
        }
    }

