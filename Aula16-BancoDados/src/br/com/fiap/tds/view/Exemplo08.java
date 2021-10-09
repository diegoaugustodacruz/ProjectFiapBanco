package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.dao.ProdutoDao;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.ConnectionFactory;

public class Exemplo08 {

	public static void main(String[] args) {
		
		Connection conexao = null;
		
		
		try {
			
			//Obter uma conexão
			conexao = ConnectionFactory.getConnection();

			//Instanciar um ProdutoDao
			ProdutoDao dao = new ProdutoDao(conexao);

			//Ler os dados
			Scanner leitor = new Scanner(System.in);
			
			System.out.println("Digite o código: ");
			int codigo = leitor.nextInt();			
			
			dao.remover(codigo);
			
			List<Produto> lista = dao.listar();
			
			for (Produto produto : lista) {
				
				System.out.println(produto);
			}
			//Fechar
			leitor.close();
			
			
		} catch(IdNotFoundException e1) {
			System.err.println(e1.getMessage());
			
		}catch (Exception e) {
			e.printStackTrace();			
		
		} finally {
			try {
				if(conexao != null) {
					conexao.close();
					
				}
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}
}
