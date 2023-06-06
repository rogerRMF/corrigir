package br.com.happycode.desafiofrete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe responsavel por inicializar a aplicação
 * */
@SpringBootApplication
public class DesafioCalculadoraFreteApp {
    public static double calcularFretePorUF(String uf, double valorProduto) {
        if (uf.equals("SP") || uf.equals("MG") || uf.equals("RJ")) {
            return valorProduto * 0.3;
        } else {
            return valorProduto * 0.15;
        }
    }

    public static double calcularFretePorValor(double valorProduto) {
        if (valorProduto < 20.0) {
            return 2.0;
        } else if (valorProduto >= 20.0 && valorProduto <= 100.0) {
            return 8.0;
        } else {
            return 0.0;
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(DesafioCalculadoraFreteApp.class, args);
       /*String ufCliente = "SP";
        double valorProduto = 10.0;

        double fretePorUF = calcularFretePorUF(ufCliente, valorProduto);
        double fretePorValor = calcularFretePorValor(valorProduto);

        System.out.println("Frete por UF: " + fretePorUF);
        System.out.println("Valor do Frete: " + fretePorValor);

        */
    }
}

