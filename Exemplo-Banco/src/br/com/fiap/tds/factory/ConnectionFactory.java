package br.com.fiap.tds.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por obter as conexões com o banco de dados
 * @author Thiago Yamamoto
 * @version 1.0
 */
public class ConnectionFactory {

	/**
	 * Obtem uma conexão com o banco de dados
	 * @return Connection conexão com o banco
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	//static -> modificador que define que o elemento é de classe e não de objeto
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		//Registrar o driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Obter uma conexão com o banco de dados (string conexão, usuario, senha)
		Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl","pf0392","fiap");
		
		return conexao;
	}
	
}