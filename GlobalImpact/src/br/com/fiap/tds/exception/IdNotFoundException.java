package br.com.fiap.tds.exception;

public class IdNotFoundException extends Exception{

	public IdNotFoundException() {
		super("Id não encontrado");
	}
	
	public IdNotFoundException(String msg) {
		super(msg);
	}
	
}
