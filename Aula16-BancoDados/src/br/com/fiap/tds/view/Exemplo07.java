package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.dao.ProdutoDao;
import br.com.fiap.tds.factory.ConnectionFactory;

public class Exemplo07 {
	public static void main(String[] args) {
		
		Connection conexao = null;
		
		
		try {
			
			//Obter uma conexão
			conexao = ConnectionFactory.getConnection();

			//Instanciar um ProdutoDao
			ProdutoDao dao = new ProdutoDao(conexao);

			List<Produto> lista = dao.listar();
			
			for (Produto produto : lista) {
				
				System.out.println(produto);
			}
			
	
			
			
			
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
