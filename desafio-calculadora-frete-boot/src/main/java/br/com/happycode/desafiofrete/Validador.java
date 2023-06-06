package br.com.happycode.desafiofrete;

public class Validador {

    void validarCep(String cep) {
        if (cep == null || cep.isEmpty()) {
            throw new IllegalArgumentException("Cep inválido! O formato correto deveria ser XXXXXXXX");
        }
        // remove hífen, se existir
        cep = cep.replaceAll("-", "");
        if (!cep.matches("\\d{8}")) {
            throw new IllegalArgumentException("Cep inválido! O formato correto deveria ser XXXXXXXX");
        }

    }

    public void validadorCep(String cep) {
    }
}
