package br.com.fiap.tds.view;

import br.com.fiap.tds.bean.Produto;

public class TesteProduto {
	
	public static void main(String[] args) {
		Produto livro = new Produto();
		
		livro.nome = "Harry Potter";
		livro.preco = 100;
		livro.disponivel = true;
		livro.corredor = 'B';
		livro.quantidade = 100;
		
		double x = livro.calcularDesconto(20);
		System.out.println("O valor do desconto é: " + x);
		
		Produto tv = new Produto();
		
		tv.configurarProduto("LG", 1000, true, 'a', 50);
		
		double y = tv.calcularDesconto(10);
		System.out.println("O valor da TV com desconto eh: " + y);
		
		System.out.println(tv.nome + " " + tv.preco);
		
		String dadosTv = tv.retornarDados();
		System.out.println(dadosTv);
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
}
