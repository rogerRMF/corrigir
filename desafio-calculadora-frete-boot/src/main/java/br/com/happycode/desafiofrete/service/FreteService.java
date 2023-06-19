package br.com.happycode.desafiofrete.service;

import br.com.calculadora.fretehttpcliente.UF;
import br.com.happycode.desafiofrete.dto.FreteDTO;
import br.com.happycode.desafiofrete.model.Cliente;
import br.com.happycode.desafiofrete.model.Frete;
import br.com.happycode.desafiofrete.model.Produto;
import br.com.happycode.desafiofrete.mongo.model.FreteMongo;
import br.com.happycode.desafiofrete.mongo.repository.FreteRepositoryMongo;
import br.com.happycode.desafiofrete.repository.ClienteRepository;
import br.com.happycode.desafiofrete.repository.FreteRepository;
import br.com.happycode.desafiofrete.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FreteService {

    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;
    private final FreteRepository freteRepository;
    private final FreteRepositoryMongo freteRepositoryMongo;

    public FreteService(ProdutoRepository produtoRepository, ClienteRepository clienteRepository, FreteRepository freteRepository, FreteRepositoryMongo freteRepositoryMongo) {
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
        this.freteRepository = freteRepository;
        this.freteRepositoryMongo = freteRepositoryMongo;
    }

    public double calcularFrete(TipoCalculo tipoCalculo, Long idProduto, Long idCliente) {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        double valorFrete = 0;

        if (tipoCalculo == TipoCalculo.POR_UF) {
            valorFrete = calcularFretePorUF(cliente.getUf(), produto.getValor());
        } else if (tipoCalculo == TipoCalculo.POR_VALOR) {
            valorFrete = calcularFretePorValor(produto.getValor());
        }

        Frete frete = new Frete(produto, cliente.getUf(), valorFrete);
        freteRepository.save(frete);

        return valorFrete;
    }

    private double calcularFretePorUF(UF uf, double valorProduto) {
        if (uf == UF.SP || uf == UF.MG || uf == UF.RJ) {
            return valorProduto * 0.3;
        } else {
            return valorProduto * 0.15;
        }
    }

    private double calcularFretePorValor(double valorProduto) {
        if (valorProduto < 20.0) {
            return 2.0;
        } else if (valorProduto >= 20.0 && valorProduto <= 100.0) {
            return 8.0;
        } else {
            return 0.0;
        }
    }

    public FreteDTO obterFrete(Long id) {
        Optional<Frete> optionalFrete = freteRepository.findById(id);
        Frete frete = optionalFrete.orElseThrow(() -> new IllegalArgumentException("Frete não encontrado"));

        FreteDTO freteDTO = new FreteDTO();
        FreteMongo freteMongo = new FreteMongo();
        freteRepositoryMongo.save(freteMongo);
        BeanUtils.copyProperties(frete, freteDTO);
        return freteDTO;
    }

    public void deletarFrete(Long id) {
        if (!freteRepository.existsById(id)) {
            throw new IllegalArgumentException("Frete não encontrado");
        }
        freteRepository.deleteById(id);
    }

    public List<FreteDTO> buscarTodosFretes() {
        List<Frete> fretes = freteRepository.findAll();
        return fretes.stream()
                .map(frete -> {
                    FreteDTO freteDTO = new FreteDTO();
                    BeanUtils.copyProperties(frete, freteDTO);
                    return freteDTO;
                })
                .collect(Collectors.toList());
    }

    public FreteDTO atualizarFrete(Long id, FreteDTO freteDTO) {
        return freteDTO;
    }
}
