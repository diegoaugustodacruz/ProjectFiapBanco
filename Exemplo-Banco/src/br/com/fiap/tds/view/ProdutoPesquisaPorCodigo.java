package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.bo.ProdutoBo;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.ConnectionFactory;

public class ProdutoPesquisaPorCodigo {

	//Pesquisar por código
	public static void main(String[] args) {
		
		Connection conexao = null;
		try {
			//Obter uma conexão
			conexao = ConnectionFactory.getConnection();
			
			//Instanciar o DAO
			ProdutoBo bo = new ProdutoBo(conexao);
			
			//Ler o código
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite o código");
			int codigo = sc.nextInt();
			
			//Pesquisar
			Produto produto = bo.pesquisar(codigo);
			
			//Exibir os dados do produto
			System.out.println(produto);
			System.out.println(produto.getCategoria());
			
			sc.close();
			
		} catch (IdNotFoundException e1) {
			System.err.println(e1.getMessage());
		}catch (Exception e) {
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