package br.com.fiap.tds.view;

import java.util.Scanner;

import br.com.fiap.tds.exception.DescontoNegativoException;
import br.com.fiap.tds.exception.ValorBaixoException;
import br.com.fiap.tds.service.ProdutoService;

public class Exemplo02 {
	
	public static void main(String[] args) {
		
		//Instanciar o ProdutoBO
		ProdutoService bo = new ProdutoService();	
		
		Scanner leitor = new Scanner(System.in);

		
		
		try {
			//Ler o valor e o desconto		
			System.out.println("Digite o desconto: ");
			double desconto = leitor.nextDouble();
			
			System.out.println("Digite o valor: ");
			double valor = leitor.nextDouble();		
			
			//Chamar o método calcularDesconto
			double valorDeDesconto = bo.calcularDesconto(valor, desconto);
			System.out.println("O valor com desconto: " + valorDeDesconto);
			
		}catch(DescontoNegativoException e) {
			System.out.println("Erro no valor do desconto: " + e.getMessage());
			
		}catch(ValorBaixoException e) {
			System.out.println("Erro no valor produto: " + e.getMessage());

		}finally {
			leitor.close();
			
		}
		
		
	}
	

}
