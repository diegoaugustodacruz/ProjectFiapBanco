package br.com.tdss.view;

import java.util.ArrayList;
import java.util.List;

public class Exemplo01 {
	
	public static void main(String[] args) {
		
		//Declarar uma lista e instanciar o objeto que representa a lista		
		List lista = new ArrayList();
		
		//Adicionar um elemento na lista		
		lista.add(1);
		lista.add(2);
		lista.add(10);
		
		//Recuperar um elemento dado o index
		System.out.println(lista.get(2));
		
		//Percorrer a lista e exibir os elementos
		
		for(int i = 0; i<lista.size(); i++) {
			System.out.println(lista.get(i));
		}
				
		for(Object churros: lista)
			System.out.println(churros);
	}

}
