package br.com.happycode.desafiofrete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidadorTest {
    @Test
    void validarCep_comCepValido_naoDeveLancarExcecao() {
        // Arrange
        Validador validador = new Validador();
        String cep = "12345678";

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> {
            validador.validadorCep(cep);
        });
    }

    @Test
    void validarCep_comCepNulo_deveLancarExcecao() {
        // Arrange
        Validador validador = new Validador();
        String cep = null;

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validador.validarCep(cep);
        });
    }

    @Test
    void validarCep_comCepVazio_deveLancarExcecao() {
        // Arrange
        Validador validador = new Validador();
        String cep = "";

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validador.validarCep(cep);
        });
    }

    @Test
    void validarCep_comCepFormatoIncorreto_deveLancarExcecao() {
        // Arrange
        Validador validador = new Validador();
        String cep = "1234ABCD";

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validador.validarCep(cep);
        });
    }
}
