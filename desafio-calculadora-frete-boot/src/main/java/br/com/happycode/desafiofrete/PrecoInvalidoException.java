package br.com.happycode.desafiofrete;

public class PrecoInvalidoException extends IllegalArgumentException {
    public PrecoInvalidoException(String message) {
        super(message);
    }

    public static void invalido(String s) {
    }
}
