package br.com.fiap.ex06;

public class Aluno {

	Disciplina notas = new Disciplina();
	
	String disciplina, nome;
			
	String atribuirDisciplina(String d) {
		disciplina = d;
		return disciplina;
					
	}
		
	String obterDisciplina() {
		String dados = "Sua disciplina é: " + disciplina;
		return dados;
		
	}
	
	String atribuirNome(String n) {
		nome = n;
		return nome;
	}
	
	String obterNome() {
		String dados = nome;
		return dados;
	}
	
	
	
	void atribuirNotas(double n1, double n2, double n3) {
		notas.atribuirNotas(n1, n2, n3);
	
		
	}
	
	double obterMedia() {
		double m = notas.obterMedia();
		return m;
	}
	
	
		
	}
	

