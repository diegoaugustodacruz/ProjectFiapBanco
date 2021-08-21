package br.com.fiap.ex1.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.tdss.bean.Aluno;

public class Exercicio {	
	
	public static void main(String[] args) {
		
		//Variavel para ler a opcap esoclhida pelo usuario
		int opcao;
		
		//Criar a lista de aluno
		List<Aluno> alunos = new ArrayList<>();
		
		
		//Laço
		do {
			//ler os dados do aluno
			int rm = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM do aluno: "));
			String nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno: "));
			
			
			List<Float> notas = new ArrayList<>();
			do {
				//Ler a nota
				float nota = Float.parseFloat(JOptionPane.showInputDialog("Digite a nota:"));
				//Adicionar na lista
				notas.add(nota);
				
			}while(JOptionPane.showConfirmDialog(null, "Deseja adicionar mais uma nota? ") == JOptionPane.YES_OPTION);
			
			
			
			//instanciar o aluno
			Aluno aluno = new Aluno(rm, nome, idade, notas);
			
			
			//adicionar na lista
			alunos.add(aluno);			
			
			//ler se o usuario deseja adicionar mais um aluno
			opcao = JOptionPane.showConfirmDialog(null, "Deseja adicionar mais um aluno?");
		}while(opcao == JOptionPane.YES_OPTION);
		
		
		System.out.println("Total de alunos cadastrados: " + alunos.size());
		
		//----
		float somaMedias = alunos.get(0).calcularMedia();
		float somaIdades = alunos.get(0).getIdade();
		int maiorIdade = alunos.get(0).getIdade();	
		int menorIdade = alunos.get(0).getIdade();		


		
		
		for(int i = 1; i<alunos.size();i++) {
			somaIdades = somaIdades + alunos.get(i).getIdade();

			somaMedias = somaMedias + alunos.get(i).calcularMedia();
			
			if(alunos.get(i).getIdade() > maiorIdade) {
				maiorIdade = alunos.get(i).getIdade();
			}
			if(alunos.get(i).getIdade() < menorIdade) {
				menorIdade = alunos.get(i).getIdade();
			}
			
		}	
		
		
		System.out.println("Média geral das notas: " + somaMedias/alunos.size());
		
		
		System.out.println("Média geral de idades: " + somaIdades/alunos.size());
	
		System.out.println("Maior idade: " + maiorIdade);
		
		
		System.out.println("Menor idade: " + menorIdade);
		
		
		
		do {
			 opcao = Integer.parseInt(JOptionPane.showInputDialog("MENU: \n1 - Imprimir os nomes e médias de todos os alunos "
					+ "\n2 - Imprimir apenas os nomes dos alunos que possuem média acima de 6.0"
					 + "\n3- Imprimir apenas os nomes dos alunos que possuem idade acima de 30 anos"
					 + "\n4 - Excluir os alunos com médias menores que 3.0\n"
					 + "\n0 - Sair do sistema"));
			
			 switch (opcao) {
				case 1:
					for(int i = 0; i<alunos.size();i++) {
						System.out.println("Aluno: " + alunos.get(i).getNome() + "\nMedia: " + alunos.get(i).calcularMedia());
					}
					break;
					
				case 2:
					for(int i = 0; i<alunos.size();i++) {
						
						System.out.println("Alunos com média acima de 6: ");
					}
					
					
					break;
					
				case 3:
					System.out.println("Alunos com idade acima de 30 anos: ");
					break;
				
				case 4:
					System.out.println("Excluindo alunos que repetiram de ano: ");
					break;
				
				case 0:
					System.out.println("Saindo do sistema...");
					break;


			default:
				System.out.println("Opcao invalida");
				break;
			}
				
			
			}while(opcao!=0);
			
		
		
	}//main	
	


}//class
