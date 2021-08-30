package br.com.tdss.bean;

import java.util.List;

public class Aluno {
	
	private int rm;
	
	private String nome;	
	
	private int idade;
	
	private List<Float> notas;
	
	public Aluno() {
		
	}

	public Aluno(int rm, String nome, int idade, List<Float> notas) {
		super();
		this.rm = rm;
		this.nome = nome;
		this.idade = idade;
		this.notas = notas;
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Float> getNotas() {
		return notas;
	}

	public void setNotas(List<Float> notas) {
		this.notas = notas;
	}
	
	
	public float calcularMedia() {
		float soma = 0;
		for(int i = 0; i<notas.size(); i++) {
			soma = soma + notas.get(i);
		}
		return soma/notas.size();
	}
	
	@Override
	public String toString() {
		return "RM: " + rm + " Nome: " + nome + " Idade: " + idade + " Notas: " + notas + " Media" + calcularMedia();
	}
}
