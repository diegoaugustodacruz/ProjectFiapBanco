package br.com.fiap.tdss.bean;

public class Produto {

	String nome;
	
	int quantidade;
	
	float preco, desconto;
	
	public Produto() {
		
	}

	public Produto(String nome, int quantidade, float preco, float desconto) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.desconto = desconto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	
	
	
	
	
	
}