package br.com.fiap.tds.exception;

//Excepiton -> Checked, não compila se não tratada/lançada
//RunTimeException -> Unchecked, não checada em tempo de compilação

public class DescontoNegativoException extends Exception{
	
	//Construtor com mensagem padrão
	public DescontoNegativoException () {
		super("O desconto não pode ser negativo");
	}
	
	//Construtor que recebe uma mensagem
	public DescontoNegativoException(String mensagem) {
		super(mensagem);
	}
	
	

}
