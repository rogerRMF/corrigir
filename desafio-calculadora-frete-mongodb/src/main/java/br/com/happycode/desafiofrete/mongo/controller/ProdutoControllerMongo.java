package br.com.happycode.desafiofrete.mongo.controller;


import br.com.happycode.desafiofrete.mongo.dto.ProdutoDTOMongo;
import br.com.happycode.desafiofrete.mongo.service.ProdutoServiceMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Document(collection = "produto")
public class ProdutoControllerMongo {

    @Autowired
    private final ProdutoServiceMongo produtoServiceMongo;

    public ProdutoControllerMongo(ProdutoServiceMongo produtoServiceMongo) {
        this.produtoServiceMongo = produtoServiceMongo;
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProdutoDTOMongo> cadastrarProduto(@RequestBody ProdutoDTOMongo produtoDTOMongo) throws IOException, URISyntaxException {
        ProdutoDTOMongo produtoCadastrado = produtoServiceMongo.cadastrarProduto(produtoDTOMongo);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCadastrado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTOMongo> obterProduto(@PathVariable Long id) {
        ProdutoDTOMongo produtoDTOMongo = ProdutoServiceMongo.obterProdutoMongo(id);
        if (produtoDTOMongo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoDTOMongo);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTOMongo>> buscarTodosProduto() {
        List<ProdutoDTOMongo> ProdutoMongo = ProdutoServiceMongo.buscarTodosProdutos();
        return ResponseEntity.ok(ProdutoMongo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTOMongo> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTOMongo produtoDTOMongo) {
        ProdutoDTOMongo produtoAtualizado = produtoServiceMongo.atualizarProduto(id, produtoDTOMongo);
        if (produtoAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoServiceMongo.deletarProduto(id);
        return ResponseEntity.ok().build();
    }

}
