package br.com.happycode.desafiofrete.service;

import br.com.calculadora.fretehttpcliente.DadosEnderecoDTO;
import br.com.calculadora.fretehttpcliente.UF;

public class ClienteApiTerceiros {
    public DadosEnderecoDTO obterDadosEndereco(String cep) {
        return new DadosEnderecoDTO("1", "2", "3", "4", UF.AC);
    }
}
