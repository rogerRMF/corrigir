package br.com.happycode.desafiofrete.service;

import br.com.happycode.desafiofrete.dto.ProdutoDTO;
import br.com.happycode.desafiofrete.exception.PrecoInvalidoException;
import br.com.happycode.desafiofrete.exception.ProdutoNaoEncontradoException;
import br.com.happycode.desafiofrete.model.Produto;
import br.com.happycode.desafiofrete.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoDTO cadastrarProduto(ProdutoDTO produtoDTO) {
        // Fazer validações e conversões necessárias
        if (produtoDTO.getValor() == null || produtoDTO.getValor() <= 0) {
            throw new PrecoInvalidoException("O valor do produto está inválido pois deve ser maior que zero!");
        }

        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto);
        produto = produtoRepository.save(produto);

        BeanUtils.copyProperties(produto, produtoDTO);
        return produtoDTO;
    }

    public ProdutoDTO obterProduto(Long id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        Produto produto = optionalProduto.orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado"));
        ProdutoDTO produtoDTO = new ProdutoDTO();
        BeanUtils.copyProperties(produto, produtoDTO);
        return produtoDTO;
    }

    public void deletarProduto(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }

    public List<ProdutoDTO> buscarTodosProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produto -> {
                    ProdutoDTO produtoDTO = new ProdutoDTO();
                    BeanUtils.copyProperties(produto, produtoDTO);
                    return produtoDTO;
                })
                .collect(Collectors.toList());
    }

    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        return produtoDTO;
    }
}
