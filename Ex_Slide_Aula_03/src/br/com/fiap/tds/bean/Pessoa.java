package br.com.fiap.tds.bean;

public class Pessoa {
	
	public String nome;
	
	public int idade;
	
	public float altura;
	
	
	public void alterar_dados(String n, int i, float alt) {
		nome = n;
		idade = i;
		altura = alt;
				
	}
	
	public String obterTudo() {
		return "Nome: " + nome + " Idade: " + idade + " Altura: " + altura;
		
	}
	
}
