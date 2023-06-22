package br.com.happycode.desafiofrete.mongo.ClienteApiTerceirosMongo;

import br.com.calculadora.fretehttpcliente.UF;

public class DadosEnderecosDTOMongo {
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private UF uf;

    public DadosEnderecosDTOMongo(String cep, String logradouro, String bairro, String cidade, UF uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
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
