package br.com.empresa.cadastro.entidades;

public class Cliente extends Pessoa{
	
	private String titulo;
	
	
	public Cliente() {
		
	}

	public Cliente(String titulo, String nome) {
		super(nome);
		this.titulo = titulo;
	}
		
	public Cliente(int id, String nome, String titulo) {
		super(id, nome);
		this.titulo = titulo;
	}

	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	public void exibirNomeFormatado() {
		System.out.print(titulo.toUpperCase() + " - ");
		super.exibirNomeFormatado();
	}

	
	

}
