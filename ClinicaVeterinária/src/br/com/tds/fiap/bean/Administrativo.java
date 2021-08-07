package br.com.tds.fiap.bean;

public class Administrativo extends Profissional{

	private String funcao, senha, login;
	
	private int numeroComputador;
	
		
	public Administrativo () {
		
	}

	public Administrativo(String nome, String horaEntrada, String horaSaida, int matricula,
			int idade, double salario, String funcao, String senha, String login, int numeroComputador) {
		super(nome, horaEntrada, horaSaida, matricula, idade, salario);
		this.funcao = funcao;
		this.senha = senha;
		this.login = login;
		this.numeroComputador = numeroComputador;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getNumeroComputador() {
		return numeroComputador;
	}

	public void setNumeroComputador(int numeroComputador) {
		this.numeroComputador = numeroComputador;
	}
	
	
	
	
	
}
