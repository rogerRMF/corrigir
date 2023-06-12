package br.com.calculadora.fretehttpcliente;

public class DadosEnderecoDTO {
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

    public DadosEnderecoDTO(String logradouro, String bairro, String cidade, String uf) {
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
        return UF.valueOf(uf);
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
