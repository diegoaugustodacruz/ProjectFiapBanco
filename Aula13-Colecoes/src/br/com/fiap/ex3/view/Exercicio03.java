package br.com.fiap.ex3.view;

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
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha: \n1-Cadastrar \n2-Cosultar \n3-Sair"));
			
			switch(opcao) {
				case 1 : 
					String sigla = JOptionPane.showInputDialog("Digite a sigla");
					
					Set<Integer> ddds;
					
					if(mapa.containsKey(sigla)) {
						ddds = mapa.get(sigla);
					}else {
						ddds = new HashSet<Integer>();
						}
					break;
				
				case 2 : 
						
					break;
					
				case 3 : 
					
					break;
				default:
					System.out.println("Opcao invalida");
			
			}
			
		}while(opcao!=3);
		
		
	}
}
