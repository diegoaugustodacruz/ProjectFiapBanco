package br.com.tdss.view;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Exemplo03 {
	
	public static void main(String[] args) {
		
		//Map -> Mapeia chave e valor		
		Map<String, String> mapa = new HashMap<String, String>();
		
		//Adicionar mapeamentos
		mapa.put("SP", "Sao Paulo");
		mapa.put("RJ", "Rio de Janeiro");
		mapa.put("MG", "Minas Gerais");
		mapa.put("RS", "Rio Grande do Sul");
		mapa.put("PR", "Parana");
		
				
		//Adicionar um valor em uma chave que ja existe
		mapa.put("SP", "EITA");
		
		//Recuperar um valor através da chave
		System.out.println("Recupera o valor da chave de SP: " + mapa.get("SP"));
		
		//Exibir a quantidade de mapeamento
		System.out.println("\nQuantidade de elementos: " + mapa.size());
		
		//Validar se existe o mapeamento
		if(mapa.isEmpty()) {
			System.out.println("\nMapeamento está vazio");
		}else
			System.out.println("\nMapeamento nao esta vazio");
		
		
		//Remover o mapeamento
		//mapa.clear();
		
		//Remover um mapeamento
		mapa.remove("SP");
			
		
		//Validar se o mapeamento possui uma chave
		if(mapa.containsKey("SP")) {
			System.out.println("\nExiste a chave SP");
		}else
			System.out.println("\nNao existe a chave SP");
		
		//validar se o mapeamento possui um valor
		System.out.println(mapa.containsValue("Rio de Janeiro")?"\nContem Rio de Janeiro":"\nNao contem Rio de Janeiro");
		
				
		//Recuperar as chaves do mapeamento
		Set<String> chaves = mapa.keySet();
		
		//Exibir as chaves
		System.out.println("\nChaves do mapeamento: ");
		chaves.forEach(sigla -> System.out.println(sigla));
				
		//Recuperar os valores do mapeamento
		Collection<String> valores = mapa.values();
				
		//Exibir os valores
		System.out.println("\nValores do mapeamento: ");
		for(String churros: valores) {
			System.out.println(churros);
		}
		
		//Exibir a chave e o valor
		System.out.println("\nMapeamento: ");
		for(String Churros: chaves) {
			System.out.println(Churros + " -> " + mapa.get(Churros));
		}
		
	}

}
