package br.com.fiap.ex06;

public class Teste {

	public static void main(String[] args) {
		Aluno dados = new Aluno();
		
		dados.atribuirNotas(8, 9, 7);
		
		String nome = dados.atribuirNome("Diego");
		dados.obterNome();
		
		double m = dados.obterMedia();
		
		System.out.println("O aluno " + dados.obterNome() + " obteve a média: " + m);
		
		
		
		
		
	}
}
