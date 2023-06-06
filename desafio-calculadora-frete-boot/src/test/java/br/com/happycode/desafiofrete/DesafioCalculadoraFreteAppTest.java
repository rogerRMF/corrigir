package br.com.happycode.desafiofrete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DesafioCalculadoraFreteAppTest {



    @Test
    void calcularFretePorUF_deveRetornarValorCorretoParaSP() {
        // Arrange
        String uf = "SP";
        double valorProduto = 100.0;
        double valorEsperado = 30.0;

        // Act
        double resultado = DesafioCalculadoraFreteApp.calcularFretePorUF(uf, valorProduto);

        // Assert
        Assertions.assertEquals(valorEsperado, resultado);
    }

    @Test
    void calcularFretePorUF_deveRetornarValorCorretoParaMG() {
        // Arrange
        String uf = "MG";
        double valorProduto = 100.0;
        double valorEsperado = 30.0;

        // Act
        double resultado = DesafioCalculadoraFreteApp.calcularFretePorUF(uf, valorProduto);

        // Assert
        Assertions.assertEquals(valorEsperado, resultado);
    }

    @Test
    void calcularFretePorUF_deveRetornarValorCorretoParaRJ() {
        // Arrange
        String uf = "RJ";
        double valorProduto = 100.0;
        double valorEsperado = 30.0;

        // Act
        double resultado = DesafioCalculadoraFreteApp.calcularFretePorUF(uf, valorProduto);

        // Assert
        Assertions.assertEquals(valorEsperado, resultado);
    }

    @Test
    void calcularFretePorUF_deveRetornarValorCorretoParaOutrosEstados() {
        // Arrange
        String uf = "SC";
        double valorProduto = 100.0;
        double valorEsperado = 15.0;

        // Act
        double resultado = DesafioCalculadoraFreteApp.calcularFretePorUF(uf, valorProduto);

        // Assert
        Assertions.assertEquals(valorEsperado, resultado);
    }

    @Test
    void calcularFretePorValor_deveRetornarValorCorretoParaValorMenorQue20() {
        // Arrange
        double valorProduto = 15.0;
        double valorEsperado = 2.0;

        // Act
        double resultado = DesafioCalculadoraFreteApp.calcularFretePorValor(valorProduto);

        // Assert
        Assertions.assertEquals(valorEsperado, resultado);
    }

    @Test
    void calcularFretePorValor_deveRetornarValorCorretoParaValorEntre20E100() {
        // Arrange
        double valorProduto = 50.0;
        double valorEsperado = 8.0;

        // Act
        double resultado = DesafioCalculadoraFreteApp.calcularFretePorValor(valorProduto);

        // Assert
        Assertions.assertEquals(valorEsperado, resultado);
    }

    @Test
    void calcularFretePorValor_deveRetornarValorCorretoParaValorMaiorQue100() {
        // Arrange
        double valorProduto = 150.0;
        double valorEsperado = 0.0;

        // Act
        double resultado = DesafioCalculadoraFreteApp.calcularFretePorValor(valorProduto);

        // Assert
        Assertions.assertEquals(valorEsperado, resultado);
    }
}