package br.com.tds.fiap.bean;

public class Cliente {
	
	private String nome, formaDePagamento;
	
	Consulta consulta;
	
	Animal animal;

	public Cliente() {
		
	}
	
	public Cliente(String nome, String formaDePagamento, Consulta consulta, Animal animal) {
		this.nome = nome;
		this.formaDePagamento = formaDePagamento;
		this.consulta = consulta;
		this.animal = animal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	
	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	
	
	
	
	
}
