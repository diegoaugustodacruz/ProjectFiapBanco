package br.com.fiap.tdss.bean;

public class Aluno {
	
	private String nome;
	private float[] notas;
	
	
	public Aluno() {
		
	}
	
	public Aluno(String nome, float[] notas) {
		super();
		this.nome = nome;
		this.notas = notas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float[] getNotas() {
		return notas;
	}

	public void setNotas(float[] notas) {
		this.notas = notas;
	}
	
	
	public float getMaiorNota() {
		float maior = notas[0];
				
		for(int i=1; i<notas.length ; i++) {
			if(notas[i]>maior) {
				maior = notas[i];
			}
		}
		return maior;	
	}
	
	
	
	
}
