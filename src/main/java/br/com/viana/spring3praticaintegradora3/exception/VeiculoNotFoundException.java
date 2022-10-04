package br.com.viana.spring3praticaintegradora3.exception;

public class VeiculoNotFoundException extends RuntimeException{
    public VeiculoNotFoundException(String message) {
        super(message);
    }
}
