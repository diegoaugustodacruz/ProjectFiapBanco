package br.com.fiap.tds.bean;

public class Tecnologo extends Formacao {
	
	
	private boolean planoEstendido;
	
	//Construtores
	public Tecnologo() {
		
	}

	public Tecnologo(String descricao, int periodo, int duracao, double mensalidade, boolean planoEstendido) {
		super(descricao, periodo, duracao, mensalidade);
		this.planoEstendido = planoEstendido;
	}
	
	public Tecnologo(String descricao, int periodo, boolean planoEstendido) {
		super(descricao, periodo);
		this.planoEstendido = planoEstendido;
		
	}

	//Getters and Setters
	public boolean isPlanoEstendido() {
		return planoEstendido;
	}

	public void setPlanoEstendido(boolean planoEstendido) {
		this.planoEstendido = planoEstendido;
	}
	
	
	//Metodos
	public void calcularMensalidade(double fator) {
		mensalidade = duracao*fator*600;
		
	}
	
	public String toString() {
		return super.toString() + "\nPlano Estendido: " + planoEstendido;
	}
	
	/*
	 * public void definirDuracao() { duracao = 24; }
	 */

}
