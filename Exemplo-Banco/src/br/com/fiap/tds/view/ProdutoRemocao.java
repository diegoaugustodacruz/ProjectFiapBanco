package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.tds.bo.ProdutoBo;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.ConnectionFactory;

public class ProdutoRemocao {

	//Remoção
	public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			//Obter a conexão
			conexao = ConnectionFactory.getConnection();
			
			//Instancia
			ProdutoBo bo = new ProdutoBo(conexao);
			
			//Ler o código para remoção
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite o código");
			int codigo = sc.nextInt();
			
			//Remover o produto
			bo.remover(codigo);
			System.out.println("Produto removido!");
			
			sc.close();
		} catch (IdNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conexao != null) conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}//main
}//class
