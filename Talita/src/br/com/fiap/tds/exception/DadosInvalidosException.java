package br.com.fiap.tds.exception;

public class DadosInvalidosException extends Exception{

	public DadosInvalidosException() {
		super("Dado invalido");
	}
	
	public DadosInvalidosException(String msg) {
		super(msg);
	}
}
