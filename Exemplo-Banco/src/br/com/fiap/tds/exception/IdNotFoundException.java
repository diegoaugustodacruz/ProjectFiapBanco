package br.com.fiap.tds.exception;

public class IdNotFoundException extends Exception {

	public IdNotFoundException() {
		super("C�digo n�o encontrado");
	}
	
	public IdNotFoundException(String msg) {
		super(msg);
	}
	
}