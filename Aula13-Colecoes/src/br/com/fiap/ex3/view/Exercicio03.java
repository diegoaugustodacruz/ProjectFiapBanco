package br.com.fiap.ex3.view;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;


public class Exercicio03 {

	public static void main(String[] args) {
				
		Map<String, Set<Integer>> mapa = new HashMap<String, Set<Integer>>();
		
		int opcao;
		
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha: \n1-Cadastrar \n2-Consultar \n3-Sair"));
			
			switch(opcao) {
				case 1 : 
					String sigla = JOptionPane.showInputDialog("Digite a sigla: ");
					
					Set<Integer> ddds;
					
					if(mapa.containsKey(sigla)) {
						ddds = mapa.get(sigla);
					}else {
						ddds = new HashSet<Integer>();
						}
					
					do {
						int ddd = Integer.parseInt(JOptionPane.showInputDialog("Digite o ddd"));
						ddds.add(ddd);
						
					}while(JOptionPane.showConfirmDialog(null, "Quer continuar cadastrando?") == JOptionPane.YES_OPTION);					
					
					mapa.put(sigla, ddds);
					
					break;
				
				case 2 : 
											
					sigla = JOptionPane.showInputDialog("Digite a sigla: ");
					
				
					//Exibir os valores
					if(mapa.containsKey(sigla)) {
						Set<Integer> conjunto = mapa.get(sigla);
						conjunto.forEach(item -> System.out.println(item));

						
					}else 
						System.out.println("Não contem a sigla " + sigla);					
						
					break;
					
				case 3 : 
					System.out.println("Finalizando o sistema");
					break;
				default:
					System.out.println("Opcao invalida");			
			}
			
		}while(opcao!=3);
		
		
	}
}
