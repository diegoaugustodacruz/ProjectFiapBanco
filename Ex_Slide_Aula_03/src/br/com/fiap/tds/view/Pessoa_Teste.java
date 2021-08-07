package br.com.fiap.tds.view;

import java.util.Scanner;

import br.com.fiap.tds.bean.Pessoa;



public class Pessoa_Teste {
	
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Digite o nome: ");
		String nome = leitor.next() + leitor.nextLine();
		
		System.out.print("Digite a idade: ");
		int idade = leitor.nextInt();
		
		System.out.print("Digite a altura: ");
		float altura = leitor.nextFloat();
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.alterar_dados(nome, idade, altura);
		
		String dados = pessoa.obterTudo();
		System.out.print(dados);

		leitor.close();
		
		
		
		
		
	}

}
