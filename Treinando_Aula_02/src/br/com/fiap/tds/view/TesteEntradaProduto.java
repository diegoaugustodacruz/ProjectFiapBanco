package br.com.fiap.tds.view;

import java.util.Scanner;

import br.com.fiap.tds.bean.Produto;

public class TesteEntradaProduto {
	
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		Produto p = new Produto();
		
		System.out.print("Digite um produto: ");		
		String name = leitor.next() + leitor.nextLine();
		
		System.out.print("Digite o preço do produto: ");
		double pri = leitor.nextDouble();
		
		System.out.print("Digite se está disponivel: ");
		boolean avai = leitor.nextBoolean();
		
		System.out.print("Digite qual corredor está: ");
		char corr = leitor.next().charAt(0);	
		
		System.out.print("Digite a quantidade: ");
		int qttt = leitor.nextInt();
		
		p.configurarProduto(name, pri, avai, corr, qttt);
		
		String dadosP = p.retornarDados();
		
		System.out.println(dadosP);
		
		System.out.print("Digite o desconto em %: ");
		int desc = leitor.nextInt();
		
		double d = p.calcularDesconto(desc);
		
		System.out.print("O valor com desconto eh: " + d);
		
		leitor.close();
	
	
		
		
		
		
		
	}

}
