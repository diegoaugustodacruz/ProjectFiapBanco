package br.com.fiap.tds.exception;

public class ValorNegativoException extends Exception{
	
	public ValorNegativoException() {
		super("Valor negativo nao permitido");
	}
	
	public ValorNegativoException(String mensagem) {
		super(mensagem);
	}

}
