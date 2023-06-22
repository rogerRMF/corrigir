package br.com.happycode.desafiofrete.mongo.service;


import br.com.happycode.desafiofrete.mongo.dto.ProdutoDTOMongo;
import br.com.happycode.desafiofrete.mongo.exception.PrecoInvalidoExceptionMongo;
import br.com.happycode.desafiofrete.mongo.exception.ProdutoNaoEncontradoExceptionMongo;
import br.com.happycode.desafiofrete.mongo.model.ProdutoMongo;
import br.com.happycode.desafiofrete.mongo.repository.ProdutoRepositoryMongo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceMongo {


    private static ProdutoRepositoryMongo produtoRepositoryMongo = null;

    public ProdutoServiceMongo(ProdutoRepositoryMongo produtoRepositoryMongo) {
        this.produtoRepositoryMongo = produtoRepositoryMongo;
    }


    public ProdutoDTOMongo cadastrarProduto(ProdutoDTOMongo produtoDTOMongo) {

        ProdutoMongo produtoMongo = new ProdutoMongo();
        produtoMongo.setDescricao(produtoDTOMongo.getDescricao());
        produtoMongo.setValor(produtoDTOMongo.getValor());

        // Fazer validações e conversões necessárias
        if (produtoDTOMongo.getValor() == null || produtoDTOMongo.getValor() <= 0) {
            throw new PrecoInvalidoExceptionMongo("O valor do produto está inválido pois deve ser maior que zero!");
        }

        ProdutoMongo produto = new ProdutoMongo();
        BeanUtils.copyProperties(produtoDTOMongo, produto);

        produtoRepositoryMongo.save(produtoMongo);
        produto = produtoRepositoryMongo.save(produto);

        BeanUtils.copyProperties(produto, produtoDTOMongo);
        return produtoDTOMongo;
    }

    public static ProdutoDTOMongo obterProdutoMongo(Long id) {
        Optional<ProdutoMongo> optionalProduto = produtoRepositoryMongo.findById(id);
        ProdutoMongo produto = optionalProduto.orElseThrow(() -> new ProdutoNaoEncontradoExceptionMongo("Produto não encontrado"));
        ProdutoDTOMongo produtoDTO = new ProdutoDTOMongo();
        BeanUtils.copyProperties(produto, produtoDTO);
        return produtoDTO;
    }

    public void deletarProduto(Long id) {
        if (!produtoRepositoryMongo.existsById(id)) {
            throw new ProdutoNaoEncontradoExceptionMongo("Produto não encontrado");
        }
        produtoRepositoryMongo.deleteById(id);
    }

    public static List<ProdutoDTOMongo> buscarTodosProdutos() {
        List<ProdutoMongo> produtos = produtoRepositoryMongo.findAll();
        return produtos.stream()
                .map(produto -> {
                    ProdutoDTOMongo produtoDTOMongo = new ProdutoDTOMongo();
                    BeanUtils.copyProperties(produto, produtoDTOMongo);
                    return produtoDTOMongo;
                })
                .collect(Collectors.toList());
    }

    public ProdutoDTOMongo atualizarProduto(Long id, ProdutoDTOMongo produtoDTOMongo) {
        return produtoDTOMongo;
    }
}