package br.com.happycode.desafiofrete;

import br.com.happycode.desafiofrete.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    @Test
    void criarProduto_comValorValido_deveCriarProduto() {
        // Arrange
        String descricao = "Produto A";
        double valor = 10.0;

        // Act
        Produto produto;
        try {
            produto = new Produto(descricao, valor);
        } catch (PrecoInvalidoException e) {
            Assertions.fail("Não deveria lançar uma exceção aqui.");
            return;
        }

        // Assert
        Assertions.assertEquals(descricao, produto.getDescricao());
        Assertions.assertEquals(valor, produto.getValor());
    }

    @Test
    void criarProduto_comValorNulo_deveLancarPrecoInvalidoException() {
        // Arrange
        String descricao = "Produto B";
        Double valor = null;

        // Act & Assert
        Assertions.assertThrows(PrecoInvalidoException.class, () -> {
            new Produto(descricao, valor);
        });
    }

    @Test
    void criarProduto_comValorZero_deveLancarPrecoInvalidoException() {
        // Arrange
        String descricao = "Produto C";
        double valor = 0.0;

        // Act & Assert
        Assertions.assertThrows(PrecoInvalidoException.class, () -> {
            new Produto(descricao, valor);
        });
    }

    @Test
    void criarProduto_comValorNegativo_deveLancarPrecoInvalidoException() {
        // Arrange
        String descricao = "Produto D";
        double valor = -10.0;

        // Act & Assert
        Assertions.assertThrows(PrecoInvalidoException.class, () -> {
            new Produto(descricao, valor);
        });
    }
}
