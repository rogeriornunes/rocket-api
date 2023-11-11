package br.com.softnunes.rocketapi.exception;

public class ClienteCadastradoException extends RuntimeException {

    public ClienteCadastradoException(String nome ){
        super("Cliente já cadastrado." + nome);
    }
}
