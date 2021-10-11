package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.tds.bean.Hobby;
import br.com.fiap.tds.bo.HobbyBO;
import br.com.fiap.tds.factory.ConnectionFactory;

public class view {

	public static void main(String[] args) {
		Connection conexao = null;
		
		
		try {
			//Instanciar um Produto
			Hobby hobby = new Hobby();
			
			
			//Ler os dados
			Scanner leitor = new Scanner(System.in);
			System.out.println("Digite o nome: ");
			hobby.setNomeHobby(leitor.next() + leitor.nextLine());			
			
			
			//Obter uma conexão
			conexao = ConnectionFactory.getConnection();
			
			//ProdutoDao dao = new ProdutoDao(conexao);
			HobbyBO bo = new HobbyBO(conexao);
			//Cadastrar um produto chamando o Dao
			bo.cadastrar(hobby);
			
			//Fechar
			leitor.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		//Instanciar um dao
		} finally {
			try {
				if(conexao != null) {
					conexao.close();
					
				}
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}//main
	
}
