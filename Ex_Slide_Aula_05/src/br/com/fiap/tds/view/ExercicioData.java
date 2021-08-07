package br.com.fiap.tds.view;

import java.util.Scanner;

import br.com.fiap.tds.bean.Data;

public class ExercicioData {
	public static void main(String[] args) {
		
		//Ler a data
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o dia: ");
		int dia = leitor.nextInt();
		
		System.out.println("Digite o mês: ");
		int mes = leitor.nextInt();
		
		System.out.println("Digite o ano: ");
		int ano = leitor.nextInt();

		//Instanciar a data
		
		Data data = new Data();
			
		//Atribuir os valores para o objeto de data
		data.setDia(dia);
		data.setMes(mes);
		data.setAno(ano);
		
		//Exibir a data formatada
		System.out.println(data.retornarData());
		
		
		//Exibir o nome do mês
		System.out.println(data.retornarMes());
		
		leitor.close();
		
	}

}
