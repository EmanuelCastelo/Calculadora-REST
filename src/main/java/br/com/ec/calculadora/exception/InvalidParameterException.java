package br.com.ec.calculadora.exception;

public class InvalidParameterException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public InvalidParameterException(String message) {
        super(message);
    }
}