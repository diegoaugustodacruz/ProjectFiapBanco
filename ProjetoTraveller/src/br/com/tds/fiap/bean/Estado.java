package br.com.tds.fiap.bean;

public class Estado extends Localidade{
	
	private String capitalEstado, siglaEstado;
	
	//Construtores
	
	public Estado(String nome, double area, double habitantes, String siglaEstado, String capitalEstado) {
		super(nome, area, habitantes);
		this.siglaEstado = siglaEstado;
		this.capitalEstado = capitalEstado;
	}
	public Estado() {
		
	}
	
	//Métodos gets e sets
	
	public String getSiglaEstado() {
		return siglaEstado;
	}
	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}
	public String getCapitalEstado() {
		return capitalEstado;
	}
	public void setCapitalEstado(String capitalEstado) {
		this.capitalEstado = capitalEstado;
	}
	
	
	//Métodos específicos 
	
	@Override
	public String toString() {
		return "ESTADO: \nSigla Estado = " + siglaEstado + "\nCapital Estado = " + capitalEstado + "\nNome = " + nome + "\nArea = "
				+ area + "\nHabitantes = " + habitantes;
	}
	
}
