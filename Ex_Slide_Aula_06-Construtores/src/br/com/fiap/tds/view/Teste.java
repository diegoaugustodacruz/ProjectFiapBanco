package br.com.fiap.tds.view;

import java.util.Scanner;

import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.bean.Profissao;

public class Teste {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		System.out.print("Digite a profissão: ");
		String nomeProfissao = leitor.next() + leitor.nextLine();
		
		
		Profissao dados = new Profissao(nomeProfissao);
				
		System.out.print("Digite a matricula: ");
		long matricula = leitor.nextLong();
		
		System.out.print("Digite o nome do funcionario: ");
		String nomeFuncionario = leitor.next() + leitor.nextLine();
		
		System.out.print("Digite o salário: ");
		double salario = leitor.nextDouble();
		
				
		Funcionario funcionario = new Funcionario(matricula, nomeFuncionario, dados);
		funcionario.setSalario(salario);

		System.out.println(funcionario.exibirDados());
		
		
		
		leitor.close();
		
		
		
		
	}
}
