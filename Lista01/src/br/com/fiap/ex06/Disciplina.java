package br.com.fiap.ex06;

public class Disciplina {
	
	double nota1, nota2, nota3;
	
	void atribuirNotas(double n1, double n2, double n3) {
		nota1 = n1;
		nota2 = n2;
		nota3 = n3;
				
	}
	
	
	String obterNotas() {
		String dados = "Nota 01: " + nota1 + " , Nota 02: " + " , Nota 03: " + nota3;
		return dados;
	}
	
	
	double obterMedia() {
		double media = (nota1 + nota2 + nota3)/3;
		return media;
	}


	

	
}
