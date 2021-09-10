package br.com.fiap.tds.exception;

public class ValorBaixoException extends Exception{
	
	public ValorBaixoException () {
		super("Valor não pode ser menor que 100 reais");
	}
	
	public ValorBaixoException (String mensagem) {
		super(mensagem);
	}
	

}
