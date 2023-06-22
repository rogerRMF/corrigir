package br.com.happycode.desafiofrete.mongo.service;

import br.com.calculadora.fretehttpcliente.UF;
import br.com.happycode.desafiofrete.mongo.ClienteApiTerceirosMongo.ClienteApiTerceirosMongo;
import br.com.happycode.desafiofrete.mongo.ClienteApiTerceirosMongo.DadosEnderecosDTOMongo;
import br.com.happycode.desafiofrete.mongo.dto.ClienteDTOMongo;
import br.com.happycode.desafiofrete.mongo.exception.ClienteNaoEncontradoExceptionMongo;
import br.com.happycode.desafiofrete.mongo.model.ClienteMongo;
import br.com.happycode.desafiofrete.mongo.repository.ClienteRepositoryMongo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceMongo {

    private static ClienteRepositoryMongo clienteRepositoryMongo = null;
    private final ClienteApiTerceirosMongo clienteApiTerceirosMongo;

    public ClienteServiceMongo(ClienteRepositoryMongo clienteRepositoryMongo, ClienteApiTerceirosMongo clienteApiTerceirosMongo) {
        ClienteServiceMongo.clienteRepositoryMongo = clienteRepositoryMongo;
        this.clienteApiTerceirosMongo = clienteApiTerceirosMongo;
    }

    public ClienteDTOMongo cadastrarCliente(ClienteDTOMongo clienteDTOMongo) throws IOException, URISyntaxException {
        String cep = ClienteDTOMongo.getCep();
        ClienteMongo clienteMongo = new ClienteMongo();

        // Obtém os dados do endereço a partir de uma API de terceiros
        DadosEnderecosDTOMongo dadosEnderecosDTOMongo = clienteApiTerceirosMongo.obterDadosEnderecosDTOMongo(cep);
        if (dadosEnderecosDTOMongo != null) {
            clienteMongo.setUf(dadosEnderecosDTOMongo.getUf());
            clienteMongo.setLogradouro(dadosEnderecosDTOMongo.getLogradouro());
            clienteMongo.setBairro(dadosEnderecosDTOMongo.getBairro());
            clienteMongo.setCidade(dadosEnderecosDTOMongo.getCidade());
        } else {
            throw new ClienteNaoEncontradoExceptionMongo("Dados do CEP não encontrados");
        }

        clienteMongo.setNome(clienteDTOMongo.getNome());
        clienteMongo.setCep(ClienteDTOMongo.getCep());

        ClienteMongo savedClienteMongo = clienteRepositoryMongo.save(clienteMongo);

        ClienteDTOMongo savedClienteDTOMongo = new ClienteDTOMongo();
        BeanUtils.copyProperties(savedClienteMongo, savedClienteDTOMongo);
        return savedClienteDTOMongo;
    }

    public static ClienteDTOMongo obterClienteMongo(String id) {
        Optional<ClienteMongo> optionalCliente = clienteRepositoryMongo.findById(id);
        ClienteMongo clienteMongo = optionalCliente.orElseThrow(() -> new ClienteNaoEncontradoExceptionMongo("Cliente não encontrado"));

        ClienteDTOMongo clienteDTOMongo = new ClienteDTOMongo();
        BeanUtils.copyProperties(clienteMongo, clienteDTOMongo);
        return clienteDTOMongo;
    }

    public void deletarCliente(String id) {
        if (!clienteRepositoryMongo.existsById(id)) {
            throw new ClienteNaoEncontradoExceptionMongo("Cliente não encontrado");
        }
        clienteRepositoryMongo.deleteById(id);
    }

    public static List<ClienteDTOMongo> buscarTodosClientes() {
        List<ClienteMongo> clienteMongoList = clienteRepositoryMongo.findAll();
        return clienteMongoList.stream()
                .map(clienteMongo -> {
                    ClienteDTOMongo clienteDTOMongo = new ClienteDTOMongo();
                    BeanUtils.copyProperties(clienteMongo, clienteDTOMongo);
                    return clienteDTOMongo;
                })
                .collect(Collectors.toList());
    }

    public ClienteDTOMongo atualizarCliente(String id, ClienteDTOMongo clienteDTOMongo) {
        Optional<ClienteMongo> optionalCliente = clienteRepositoryMongo.findById(id);
        if (optionalCliente.isPresent()) {
            ClienteMongo clienteMongo = optionalCliente.get();
            clienteMongo.setNome(clienteDTOMongo.getNome());
            clienteMongo.setBairro(clienteDTOMongo.getBairro());
            clienteMongo.setUf(UF.fromValue(clienteDTOMongo.getUf()));
            clienteMongo.setCep(ClienteDTOMongo.getCep());
            clienteMongo.setLogradouro(clienteDTOMongo.getLogradouro());
            clienteMongo.setDataDeAniversario(clienteDTOMongo.getDataDeAniversario());
            clienteRepositoryMongo.save(clienteMongo);

            ClienteDTOMongo updatedClienteDTOMongo = new ClienteDTOMongo();
            BeanUtils.copyProperties(clienteMongo, updatedClienteDTOMongo);
            return updatedClienteDTOMongo;
        } else {
            throw new ClienteNaoEncontradoExceptionMongo("Cliente não encontrado");
        }
    }
}
