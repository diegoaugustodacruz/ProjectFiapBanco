package br.com.tdss.view;

import java.util.HashSet;
import java.util.Set;

public class Exemplo02 {	
	
	//Set -> conjunto não pode conter elementos repetidos. Não possuem posições
	public static void main(String[] args) {
		
		Set<String> conjunto = new HashSet<>();
		
		//Adicionar valores no conjunto
		conjunto.add("Brasil");
		conjunto.add("Japão");
		conjunto.add("Africa do Sul");
		conjunto.add("Austrália");
		
		//Adicionar valor repetido
		conjunto.add("Brasil");
		
		//Exibir a quantidade de elementos no conjunto
		
		System.out.println("Quantidade é: " + conjunto.size());
		
		
		//Remover um elemento do conjunto
		conjunto.remove("Brasil");
		System.out.println("Nova lista é: " + conjunto.size());
		
		//Verificar se o conjunto esta vazio
		if(conjunto.isEmpty()) {
			System.out.println("Conjunto esta vazio");
		}else 
			System.out.println("Conjunto nao esta vazio");
		
		//Verificar se existe um país especifico no conjunto
		if(conjunto.contains("Brasil")) {
			System.out.println("O conjunto possui o Brasil");
		} else
			System.out.println("O conjunto nao possui o Brasil");
		
		
		//Remover todos os elementos		
		conjunto.clear();
		
		
		//Exibir os elementos do conjunto
		System.out.println("Elementos no conjunto: ");
		for(String item: conjunto) {
			System.out.println(item);
		}
		
		//Outra opcao para exibir os elementos
		conjunto.forEach(item -> System.out.println(item));
		
		
		//Transformar o conjunto em um array vetor
		Object[] vetor = conjunto.toArray();
		System.out.println("Elementos no vetor: ");
		for(int i = 0; i < vetor.length; i++) {
			System.out.println("[" + i + "] " + vetor[i]);
		}
		
		
	}

}
