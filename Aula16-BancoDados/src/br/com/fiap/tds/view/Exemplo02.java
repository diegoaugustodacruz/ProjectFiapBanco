package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exemplo02 {
	
	//Pesquisar todos os produtos
	public static void main(String[] args) {
		Connection conexao = null;
		
		try {
			//Registrar o driver		
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Obter uma conexao com o banco de dados (string conexao, usuario, senha)
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "rm86877", "050291");
			System.out.println("Conectado no banco");
			
			
			//Criar o objeto que executa o comando SQL no banco
			Statement stmt = conexao.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM TDSS_PRODUTO");
			
			while (rs.next()) { //equanto houver registro..
				//pega o valor da coluna e coloca numa variável
				Integer id = rs.getInt("CD_PRODUTO");
				String nome = rs.getString("NM_PRODUTO");
				String descricaoProduto = rs.getString("DS_PRODUTO");
				double valorProduto = rs.getDouble("VL_PRODUTO");
				String nomeFornecedor = rs.getString("NM_FORNECEDOR");

				System.out.println("ID: " + id + "\nNOME: " + nome + "\nDESCRICAO: " + descricaoProduto + "\nVALOR: " + valorProduto + "\nFORNECEDOR: " + nomeFornecedor);
				}			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); //exibir a pilha de execucao
		}finally {
			if(conexao != null)
				try {
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}//main
	
}//class
