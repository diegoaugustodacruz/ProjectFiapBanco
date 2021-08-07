package br.com.tds.fiap.bean;

public class Localidade {

	protected String nome;
	protected double area;
	protected double habitantes;
	
	// Construtores 
	
	public Localidade(String nome, double area, double habitantes) {
		this.nome = nome;
		this.area = area;
		this.habitantes = habitantes;
	}
	public Localidade() {
		
	}
	
	//Métodos gets e sets
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(double habitantes) {
		this.habitantes = habitantes;
	}
	// Métodos específicos
	@Override
	public String toString() {
		return "Localidade \nNome =" + nome + "\nArea =" + area + "\nHabitantes =" + habitantes;
	}
	
	public double densidade() {
		return habitantes/area;
	}
	}
