package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.tds.bo.AlimentoBO;
import br.com.fiap.tds.singleton.ConnectionManager;
import br.com.fiap.tds.to.AlimentoTO;

public class View {

	//Cadastro de produto
		public static void main(String[] args) {
			
			
			//Instanciar um Alimento
			AlimentoTO alimento = new AlimentoTO();
			
			//Ler os dados
			Scanner leitor = new Scanner(System.in);
			
			System.out.println("Digite o nome");
			alimento.setNome(leitor.next() + leitor.nextLine());
			
			System.out.println("Digite o peso");
			alimento.setPeso(leitor.nextDouble());
			
			
			try {
			
				
				
				AlimentoBO bo = new AlimentoBO();
				
				bo.cadastrar(alimento);
				
				System.out.println("Alimento registrado!");
				
				leitor.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}//main
	
}
