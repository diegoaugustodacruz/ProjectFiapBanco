package br.com.empresa.cadastro.entidades;

public class Pessoa {
	
	private int id;
	protected String nome;
	
	public Pessoa () {
		
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public Pessoa(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public void exibirNomeFormatado() {
		System.out.println(nome.toUpperCase());

	}
	
	
	
	
	

}
