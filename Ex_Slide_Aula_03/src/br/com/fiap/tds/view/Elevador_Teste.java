package br.com.fiap.tds.view;

import java.util.Scanner;
import br.com.fiap.tds.bean.Elevador;

public class Elevador_Teste {
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Digite o andar atual: ");
		int floor = leitor.nextInt();
		
		System.out.print("Digite o total de pessoas no elevador: ");
		int totpeople = leitor.nextInt();

		System.out.print("Digite a capacidade de pessoas no elevador: ");
		int capacity = leitor.nextInt();

		System.out.print("Digite o total de andares: ");
		int totfloor = leitor.nextInt();

		Elevador dados = new Elevador();
		dados.andar = floor;
		dados.capac = capacity;
		dados.totAndares = totfloor;
		dados.totpessoas = totpeople;
		
		int entra = dados.entra();
		System.out.println("Entrou uma pessoa, agora esta com " + entra);
		
		int entra1 = dados.entra();
		System.out.println("Entrou mais uma pessoa, agora esta com " + entra1);
		
		int sai = dados.sai();
		System.out.println("Saiu uma pessoa, agora esta com " + sai);
		
		int sai2 = dados.sai();
		System.out.println("Saiu mais uma pessoa, agora esta com " + sai2);
		
		int sobe = dados.sobe();
		System.out.println("Subiu um andar, agora esta no " + sobe);
		
		int desce = dados.desce();
		System.out.println("Desceu um andar, agora esta no " + desce);



		
		
		
		
		
		
		
		
		
	}
}
