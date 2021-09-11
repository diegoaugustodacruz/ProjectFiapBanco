package br.com.fiap.tds.service;

import br.com.fiap.tds.bo.ProdutoBO;
import br.com.fiap.tds.exception.DescontoNegativoException;
import br.com.fiap.tds.exception.ValorBaixoException;

public class ProdutoService {
	
	private ProdutoBO bo;
	
	//Construtor que inicia o produtoBo
	public ProdutoService() {
		bo = new ProdutoBO();
	}
	
	//Criar um método que calcula o desconto
	//propaga a exception que foi gerada no ProdutoBO, deixando a responsabilidade para a outra classe
	//que chamar o método calcularDesconto do Service
	public double calcularDesconto(double valor, double desconto) throws DescontoNegativoException, ValorBaixoException{
		return bo.calcularDesconto(valor, desconto);
	}
	
	
	
}
