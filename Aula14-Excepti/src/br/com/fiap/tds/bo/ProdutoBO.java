package br.com.fiap.tds.bo;

import br.com.fiap.tds.exception.DescontoNegativoException;
import br.com.fiap.tds.exception.ValorBaixoException;

/**
 * Classe que possui as regras de negócio do Produto do ecommerce
 * @author Thiago Yamamoto
 * @version 1.0
 */

public class ProdutoBO {
	/**
	 * Calcula o valor do desconto do produto
	 * @param valor valor do produto
	 * @param desconto valor do desconto em % (Ex. 10, 20)
	 * @return valor do desconto do produto
	 * @throws DescontoNegativoException se o valor do desconto seja negativo
	 * @throws ValorBaixoException se o valor do produto for abaixo do permitido para o desconto
	 */
	public double calcularDesconto(double valor, double desconto) throws DescontoNegativoException, ValorBaixoException {
		//Validar se o desconto é negativo
		if (desconto < 0) {
			//Lançar uma exception
			throw new DescontoNegativoException();
		}
		//Validar se o valor do produto é menor do que 100
		if(valor<100) {
			throw new ValorBaixoException("O valor do produto não pode ser menor do que 101");
			
		}
		
		return valor * desconto/100;
	}

}
