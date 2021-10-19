package br.com.fiap.tds.exception;

public class DadoInvalidoException extends Exception {

	public DadoInvalidoException() {
		super("Dado inválido");
	}
	
	public DadoInvalidoException(String msg) {
		super(msg);
	}
	
}
