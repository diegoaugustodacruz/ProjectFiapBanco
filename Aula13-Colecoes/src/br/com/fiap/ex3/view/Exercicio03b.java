package br.com.fiap.ex3.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import br.com.fiap.ex3.bean.Estado;

public class Exercicio03b {
	
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		Map<String, Estado> mapa = new HashMap<String, Estado>();
		
		int opcao;

		do {
			System.out.println("Escolha: \\n1-Cadastrar \\n2-Consultar \\n3-Sair");
			opcao = leitor.nextInt();
			
			switch (opcao) {
				case 1:
					
					System.out.println("Digite a sigla");
					String sigla = leitor.next();					
					Estado estado;
					
					if(mapa.containsKey(sigla)) {
						estado = mapa.get(sigla);
					}else{
						estado = new Estado(sigla);
					}
					
					do {
						System.out.println("Digite o ddd");
						int ddd = leitor.nextInt();
						estado.addDDD(ddd);
						
						System.out.println("Deseja adicionar mais? 1-Sim 0-Não");
						
					}while(leitor.nextInt() == 1);					
					
					mapa.put(sigla, estado);
					
					break;
					
				case 2:
					System.out.println("Digite a sigla: ");
					sigla = leitor.next();
					
					if(mapa.containsKey(sigla)) {
						Estado busca = mapa.get(sigla);
						Set<Integer> conjunto = busca.getDdds();
						for(int item :  conjunto) {
							System.out.println(item);
						}
					}else 
						System.out.println("Não contem a sigla " + sigla);	
					
					
					break;
				
				case 3:
					System.out.println("Finzalizando o sistema");
					break;
	
				default:
					break;
			}
			
			
	}while(opcao!=3);
	
	}
}
