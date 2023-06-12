package br.com.happycode.desafiofrete.service;

import br.com.calculadora.fretehttpcliente.DadosEnderecoDTO;
import br.com.happycode.desafiofrete.dto.ClienteDTO;
import br.com.happycode.desafiofrete.exception.ClienteNaoEncontradoException;
import br.com.happycode.desafiofrete.model.Cliente;
import br.com.happycode.desafiofrete.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO) {
        String cep = clienteDTO.getCep();
        Cliente cliente = new Cliente();

        //TO D
       //Buscar os dados lá na api de ceps  NovaClasse

        //substituir os dados do  cliente

        ClienteApiTerceiros clienteApiTerceiros = new ClienteApiTerceiros();
        DadosEnderecoDTO dadosEnderecoDTO = clienteApiTerceiros.obterDadosEndereco(cep);

        if (dadosEnderecoDTO != null) {
            cliente.setUf(dadosEnderecoDTO.getUf());
            cliente.setLogradouro(dadosEnderecoDTO.getLogradouro());
            cliente.setBairro(dadosEnderecoDTO.getBairro());
            cliente.setCidade(dadosEnderecoDTO.getCidade());
        } else {
            throw new ClienteNaoEncontradoException("Dados do CEP não encontrados");
        }


        BeanUtils.copyProperties(clienteDTO, cliente);
        cliente = clienteRepository.save(cliente);
        BeanUtils.copyProperties(cliente, clienteDTO);
        return clienteDTO;
    }

    public ClienteDTO obterCliente(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        Cliente cliente = optionalCliente.orElseThrow();
        ClienteDTO clienteDTO = new ClienteDTO();
        BeanUtils.copyProperties(cliente, clienteDTO);
        return clienteDTO;
    }

    public void deletarCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }

    public List<ClienteDTO> buscarTodosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(cliente -> {
                    ClienteDTO clienteDTO = new ClienteDTO();
                    BeanUtils.copyProperties(cliente, clienteDTO);
                    return clienteDTO;
                })
                .collect(Collectors.toList());
    }

    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) {
        return clienteDTO;
    }
}
