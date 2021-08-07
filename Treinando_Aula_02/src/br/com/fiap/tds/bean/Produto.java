package br.com.fiap.tds.bean;

public class Produto {
	
	public String nome;
	
	public double preco;
	
	public boolean disponivel;
	
	public char corredor;
	
	public int quantidade;
	
	
	
	public double calcularDesconto(double valorDesconto) {
		double valor = preco-preco*valorDesconto/100;
		return valor;
		
	}
	
	
	public void configurarProduto(String n, double p, boolean disp, char c, int qtd) {
		
		nome = n;
		preco = p;
		disponivel = disp;
		corredor = c;
		quantidade = qtd;	
				
	}
	
	public String retornarDados() {
		String dados = nome + " Preço: " + preco + "Disponivel: " + disponivel + " Corredor: " + corredor + "Quantidade: " + quantidade;
		return dados;
	}

}
