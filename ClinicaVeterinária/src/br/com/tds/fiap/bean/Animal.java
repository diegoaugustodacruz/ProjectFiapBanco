package br.com.tds.fiap.bean;

public class Animal {
	
	private float tamanho, peso;
	
	private int idade;
	
	private String cor, nome, doenca, tipo, raca;
	
	public Animal() {
		
	}

	public Animal(float tamanho, float peso, int idade, String cor, String nome, String doenca, String tipo,
			String raca) {
		this.tamanho = tamanho;
		this.peso = peso;
		this.idade = idade;
		this.cor = cor;
		this.nome = nome;
		this.doenca = doenca;
		this.tipo = tipo;
		this.raca = raca;
	}

	public float getTamanho() {
		return tamanho;
	}

	public void setTamanho(float tamanho) {
		this.tamanho = tamanho;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDoenca() {
		return doenca;
	}

	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	
	
	
	

}
