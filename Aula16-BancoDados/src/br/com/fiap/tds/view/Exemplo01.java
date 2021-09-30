package br.com.fiap.tds.view;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Exemplo01 {

	public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			//Registrar o driver		
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Obter uma conexao com o banco de dados (string conexao, usuario, senha)
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "rm86877", "050291");
			System.out.println("Conectado no banco");
			
			
			//Criar o objeto que executa o comando SQL no banco
			Statement comando = conexao.createStatement();
			
			int linhasAfetadas = comando.executeUpdate("INSERT INTO TDSS_PRODUTO "
					+ "(CD_PRODUTO, NM_PRODUTO, VL_PRODUTO, NM_FORNECEDOR, DS_PRODUTO) "
					+ "VALUES (SQ_TB_PRODUTO.NEXTVAL, 'Celular Xiaomi', 1500, 'Aliexpress', 'Celular barato bom')");
			
			System.out.println("Linhas cadastradas: " + linhasAfetadas);		
			
			
			
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
