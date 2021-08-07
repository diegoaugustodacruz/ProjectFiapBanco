package br.com.fiap.tds.bean;

public class Formacao {
	
	
	protected String descricao;
	protected int periodo, duracao;
	protected double mensalidade;
	
	
	//Construtores
	public Formacao() {
		
	}	
	
	public Formacao(String descricao, int periodo, int duracao, double mensalidade) {
		super();
		this.descricao = descricao;
		this.periodo = periodo;
		this.duracao = duracao;
		this.mensalidade = mensalidade;
	}
	
	public Formacao (String descricao, int periodo) {
		this.descricao = descricao;
		this.periodo = periodo;
	}

	//Getters and Setters
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(double mensalidade) {
		this.mensalidade = mensalidade;
	}
	
	
	
	//Metodos
	public String toString() {
		return "Descricao: " + descricao + "\nPeriodo: " + periodo + "\nDuracao: " + duracao + "\nMensalidade: " + mensalidade;
	}
	
	public double exibirMedia(double ps1, double ps2) {
		
		return (ps1+ps2)/2;
		
	}
	
	public double exibirMedia(double ps1, double ps2, double nac1, double nac2) {
		
		return (ps1+ps2+nac1+nac2)/4;
		
	}
	
	public double exibirMedia(double ps1, double ps2, double nac1, double nac2, double am1, double am2) {
		
		return ((ps1+ps2)/2)*0.5 + ((am1+am2)/2)*0.3 + ((nac1+nac2)/2)*0.2;
		
	}
	
	public void definirDuracao() {
		//Objeto instanceof Classe -> verifica se o objeto é uma instancia da classe
		//this representa o objeto atual
		if(this instanceof Tecnologo) {
			duracao = 24;
			
		} else if(this instanceof Medio) {
			duracao = 36;
			
		}else if(this instanceof Bacharelado) {
			if(descricao != null && descricao.toUpperCase().contains("ENGENHARIA")) {
				duracao = 60;
			}else {
				duracao = 48;
			}
			
		}
		
		
	}
	
	

}
