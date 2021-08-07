package br.com.tds.fiap.bean;

public class Profissional {
	
	
	protected String nome, horaEntrada, horaSaida;
	
	protected int matricula, idade;
	
	protected double salario;
	
	
	
	
	public double reajusteSalarioAnual(double salarioAjustado, double reajuste) {
		
		return salarioAjustado*(1+(reajuste/100));
		
	}
	
	public double reajusteSalarioAnual(double salarioAjustado) {
		
		return salarioAjustado*(1+(10/100));
		
	}
	
	
	
	
	public Profissional () {
		
	}


	public Profissional(String nome, String horaEntrada, String horaSaida, int matricula,
			int idade, double salario) {
		this.nome = nome;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.matricula = matricula;
		this.idade = idade;
		this.salario = salario;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getHoraEntrada() {
		return horaEntrada;
	}


	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}


	public String getHoraSaida() {
		return horaSaida;
	}


	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	

	public int getMatricula() {
		return matricula;
	}


	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	
	
	
	
	
	
	
	

}
