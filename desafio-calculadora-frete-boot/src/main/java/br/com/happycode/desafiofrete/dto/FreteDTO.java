package br.com.happycode.desafiofrete.dto;

import br.com.happycode.desafiofrete.service.TipoCalculo;

public class FreteDTO {
    private Long idProduto;
    private Long idCliente;
    private String tipoCalculo;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }



    public void setTipoCalculo(String tipoCalculo) {
        this.tipoCalculo = tipoCalculo;
    }

    public TipoCalculo getTipoCalculo() {
        return null;
    }
}
