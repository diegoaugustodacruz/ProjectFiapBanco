package br.com.fiap.tds.ltp.pacotes.ex2.produtos;

public class Produto {
	
	protected int codigo, preco;
	
	public Produto() {
		
	}
	
	public Produto (int codigo, int preco) {
		this.codigo = codigo;
		this.preco = preco;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}
	
	
	

}
