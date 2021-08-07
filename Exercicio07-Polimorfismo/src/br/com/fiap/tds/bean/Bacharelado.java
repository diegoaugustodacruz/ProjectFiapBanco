package br.com.fiap.tds.bean;

public class Bacharelado extends Formacao {
	
	private String projetoConclusao;
	private int cargaHorariaEstagio;
	
	
	//Construtores
	public Bacharelado() {
		
	}


	public Bacharelado(String descricao, int periodo, int duracao, double mensalidade, String projetoConclusao,
			int cargaHorariaEstagio) {
		super(descricao, periodo, duracao, mensalidade);
		this.projetoConclusao = projetoConclusao;
		this.cargaHorariaEstagio = cargaHorariaEstagio;
	}

	
	
	public Bacharelado(String descricao, int periodo, String projetoConclusao, int cargaHorariaEstagio) {
		super(descricao, periodo);
		this.projetoConclusao = projetoConclusao;
		this.cargaHorariaEstagio = cargaHorariaEstagio;
	}


	//Getters and Setters
	public String getProjetoConclusao() {
		return projetoConclusao;
	}


	public void setProjetoConclusao(String projetoConclusao) {
		this.projetoConclusao = projetoConclusao;
	}


	public int getCargaHorariaEstagio() {
		return cargaHorariaEstagio;
	}


	public void setCargaHorariaEstagio(int cargaHorariaEstagio) {
		this.cargaHorariaEstagio = cargaHorariaEstagio;
	}
	
	
	//Metodos
	public void calcularMensalidade(double fator) {
		mensalidade = duracao*fator*600 + cargaHorariaEstagio*12;
	}
	
	public String toString() {
		return super.toString() + "\nProjeto Conclusao: " + projetoConclusao + "\nCarga Horario Estagio: " + cargaHorariaEstagio;
	}
	
	/*
	 * public void definirDuracao() {
	 * 
	 * if(descricao.contains("ENGENHARIA")) { duracao = 60;
	 * 
	 * }else { duracao = 36; }
	 * 
	 * }
	 */

}
