package br.com.tds.fiap.bean;

public class Veterinario extends Profissional{
	
	private int crmv;
	
	private String especialidade;
	
	Consulta consulta;

	
	
	public double reajusteSalarioAnual(double salarioAjustado) {
		
				
		return salarioAjustado*1.2 ;

		
	}
	
	public Veterinario() {
		
	}

	public Veterinario(String nome, String horaEntrada, String horaSaida, int matricula,
			int idade, double salario, int crmv, String especialidade, Consulta consulta) {
		super(nome, horaEntrada, horaSaida, matricula, idade, salario);
		this.crmv = crmv;
		this.especialidade = especialidade;
		this.consulta = consulta;
	}

	public int getCrmv() {
		return crmv;
	}

	public void setCrmv(int crmv) {
		this.crmv = crmv;
	}

	
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	
	
	
	
}