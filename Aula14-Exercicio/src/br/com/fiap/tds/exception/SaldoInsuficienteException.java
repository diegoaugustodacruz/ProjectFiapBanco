package br.com.fiap.tds.exception;

public class SaldoInsuficienteException extends Exception{
	
	public SaldoInsuficienteException() {
		super("Saque maior que o limite");
	}
	
	public SaldoInsuficienteException(String mensagem) {
		super(mensagem);
	}

}
