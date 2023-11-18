package br.com.fiap.tds.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsavel por obter as conexoes com o banco de dados
 * @author Diego
 * @version 1.0
 */
public class ConnectionFactory {
	/**
	 * Obtem uma conexao com o banco de dados
	 * @return Connection conexao com o banco
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		//Registrar o driver
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//Obter uma conexao com o banco de dados (string conexao, usuario, senha)
		Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "rm86877", "SENHA DOIDA");
		
		return conexao;
	}

}
