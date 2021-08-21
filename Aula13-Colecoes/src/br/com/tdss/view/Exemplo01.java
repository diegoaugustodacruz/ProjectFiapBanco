package br.com.tdss.view;

import java.util.ArrayList;
import java.util.List;

public class Exemplo01 {
	
	public static void main(String[] args) {
		
		//O generics sempre utilizam as classes, nunca os primitivos
		List<Double> num = new ArrayList<>();
		
		//Declarar uma lista e instanciar o objeto que representa a lista		
		List<String> lista = new ArrayList<>();
		
		//Adicionar um elemento na lista		
		lista.add("Skol"); //0
		lista.add("Itaipava"); //1
		lista.add("Antartica"); //2
		lista.add("Brahma"); //3
		lista.add("Kaiser"); //4
		
		lista.add(1, "Bohemia"); //Adicionando o elemento na posição 1 -> vem da List
		
		//Remove um elemento pelo nome -. collection
		lista.remove("Skol");
		
		//Remove um elemento pelo indice
		lista.remove(1);
		
		//substituir um elemento
		lista.set(1, "Bohemia");
		
		//exibir a posicao da primeira ocorrencia de bohemia
		System.out.println("Primeira posicao: " + lista.indexOf("Bohemia"));
		
		//exibir a posicao da ultima ocorrencia de bohemia
		System.out.println("Ultima posicao: " + lista.lastIndexOf("Bohemia"));
		
		//Recuperar um elemento dado o index
		System.out.println("Primeira posição do vetor:  " + lista.get(0));
		
		//Percorrer a lista e exibir os elementos		
		for(int i = 0; i<lista.size(); i++) {
			System.out.println(i + " " + lista.get(i));
		}				
		for(String churros: lista)
			System.out.println(churros);		
		
		
		//Criar uma sublista a partir de uma lista		
		List<String> cervejas = lista.subList(1, 3);
		
		for(int i = 0; i<cervejas.size(); i++) {
			System.out.println(i + " " + cervejas.get(i));
		}
		
		//cervejas.clear();
		
		
		//Verificar se a Brahma esta na sublista
		if(cervejas.contains("Brahama")) {
			System.out.println("A sublista possui Brahma");
		}else {
			System.out.println("A sublista não possui Brahma");
		}
		
		//verificar se lista esta vazia
		if(cervejas.isEmpty()) {
			System.out.println("A lista esta vazia");
		} else {
			for(int i = 0; i<cervejas.size(); i++) {
				System.out.println(i + " " + cervejas.get(i));
			}
			
		}
		
		//Transformar uma lista em um vetor
		Object[] vetor = cervejas.toArray();	
		System.out.println("Vetor: ");
		for(Object churros: vetor) {
			System.out.println(churros);
			
		}
		
		
		
		
		
	}//main
}//class
