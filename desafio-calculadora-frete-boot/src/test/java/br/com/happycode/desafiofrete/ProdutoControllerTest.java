package br.com.happycode.desafiofrete;

import br.com.happycode.desafiofrete.controller.ProdutoController;
import br.com.happycode.desafiofrete.dto.ProdutoDTO;
import br.com.happycode.desafiofrete.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProdutoControllerTest {

    @Mock
    private ProdutoService produtoService;

    private ProdutoController produtoController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        produtoController = new ProdutoController(produtoService);
    }

    @Test
    public void cadastrarProduto_deveRetornarStatusCreated() {
        // Dado
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setDescricao("Produto de teste");
        produtoDTO.setValor(10.0);

        ProdutoDTO produtoCadastrado = new ProdutoDTO();
        produtoCadastrado.setId(1L);
        produtoCadastrado.setDescricao("Produto de teste");
        produtoCadastrado.setValor(10.0);

        when(produtoService.cadastrarProduto(produtoDTO)).thenReturn(produtoCadastrado);

        // Quando
        ResponseEntity<ProdutoDTO> response = produtoController.cadastrarProduto(produtoDTO);

        // Então
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(produtoCadastrado, response.getBody());
    }

    @Test
    public void obterProduto_deveRetornarProdutoExistente() {
        // Dado
        Long produtoId = 1L;
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produtoId);
        produtoDTO.setDescricao("Produto de teste");
        produtoDTO.setValor(10.0);

        when(produtoService.obterProduto(produtoId)).thenReturn(produtoDTO);

        // Quando
        ResponseEntity<ProdutoDTO> response = produtoController.obterProduto(produtoId);

        // Então
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(produtoDTO, response.getBody());
    }

    @Test
    public void obterProduto_deveRetornarNotFoundParaProdutoInexistente() {
        // Dado
        Long produtoId = 1L;
        when(produtoService.obterProduto(produtoId)).thenReturn(null);

        // Quando
        ResponseEntity<ProdutoDTO> response = produtoController.obterProduto(produtoId);

        // Então
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    public void atualizarProduto_deveRetornarProdutoAtualizado() {
        // Dado
        Long produtoId = 1L;
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produtoId);
        produtoDTO.setDescricao("Produto atualizado");
        produtoDTO.setValor(20.0);

        ProdutoDTO produtoAtualizado = new ProdutoDTO();
        produtoAtualizado.setId(produtoId);
        produtoAtualizado.setDescricao("Produto atualizado");
        produtoAtualizado.setValor(20.0);

        when(produtoService.atualizarProduto(produtoId, produtoDTO)).thenReturn(produtoAtualizado);

        // Quando
        ResponseEntity<ProdutoDTO> response = produtoController.atualizarProduto(produtoId, produtoDTO);

        // Então
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(produtoAtualizado, response.getBody());
    }

    @Test
    public void atualizarProduto_deveRetornarNotFoundParaProdutoInexistente() {
        // Dado
        Long produtoId = 1L;
        ProdutoDTO produtoDTO = new ProdutoDTO();
        when(produtoService.atualizarProduto(produtoId, produtoDTO)).thenReturn(null);

        // Quando
        ResponseEntity<ProdutoDTO> response = produtoController.atualizarProduto(produtoId, produtoDTO);

        // Então
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    public void deletarProduto_deveRetornarNoContent() {
        // Dado
        Long produtoId = 1L;

        // Quando
        ResponseEntity<Void> response = produtoController.deletarProduto(produtoId);

        // Então
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(produtoService, times(1)).deletarProduto(produtoId);
    }

    @Test
    public void buscarTodosProdutos_deveRetornarListaDeProdutos() {
        // Dado
        List<ProdutoDTO> produtos = new ArrayList<>();
        produtos.add(new ProdutoDTO(1L, "Produto 1", 10.0));
        produtos.add(new ProdutoDTO(2L, "Produto 2", 20.0));

        when(produtoService.buscarTodosProdutos()).thenReturn(produtos);

        // Quando
        ResponseEntity<List<ProdutoDTO>> response = produtoController.buscarTodosProdutos();

        // Então
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(produtos, response.getBody());
    }
}
