package br.com.fiap.tds.bean;

public class Medio extends Formacao{
	
	private String tipo;
	
	//Construtores
	public Medio() {
		
	}

	public Medio(String descricao, int periodo, int duracao, double mensalidade, String tipo) {
		super(descricao, periodo, duracao, mensalidade);
		this.tipo = tipo;
	}
		

	public Medio(String descricao, int periodo, String tipo) {
		super(descricao, periodo);
		this.tipo = tipo;
	}

	//Getters and Setters
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	//Metodos
	public void calcularMensalidade(double fator) {
		mensalidade = duracao*fator*500;
	}
	
	public String toString() {
		return super.toString() + "\nTipo: " + tipo;
	}

	/*
	 * public void definirDuracao() { duracao = 36; }
	 */
	
}
