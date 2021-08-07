package br.com.fiap.tds.view;

import br.com.fiap.tds.bean.Aviao;
import br.com.fiap.tds.bean.Carro;
import br.com.fiap.tds.bean.Cor;
import br.com.fiap.tds.bean.Lancha;

public class Exercicio {
	
	public static void main(String[] args) {

		//Instanciar as classes e atribuir os valores
		
		Cor cor = new Cor();
		cor.setNome("Branco");
		cor.setR(225);
		cor.setG(225);
		cor.setB(225);
		
		
		Lancha lancha = new Lancha();
		lancha.setAnoFabricacao(2016);
		lancha.setComprimento(20);
		lancha.setModelo("Nautica");
		lancha.setQuantidadeLugares(2);
		lancha.setCor(cor);
		
		
		Aviao aviao = new Aviao();
		
		Carro carro = new Carro();
		
		//Exibir valores do ano, modelo e nome da cor
		
		System.out.println("Ano: " + lancha.getAnoFabricacao() + ", Modelo: " + lancha.getModelo() + ", Cor: " + lancha.getCor().getNome());
		
		
	}

}
