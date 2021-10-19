package br.com.fiap.tds.bean;

import java.util.List;

public class Categoria {

	private int codigo;
	
	private String nome;
	
	private String data;
	
	private List<Produto> produtos;
	
	public Categoria() {}

	public Categoria(String nome, String data) {
		this.nome = nome;
		this.data = data;
	}
	
	public Categoria(int codigo, String nome, String data) {
		this.codigo = codigo;
		this.nome = nome;
		this.data = data;
	}

	public Categoria(int categoria) {
		this.codigo = categoria;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@Override
	public String toString() {
		return "Código: " + codigo + ", nome: " + nome + ", data: " + data;
	}
	
}
