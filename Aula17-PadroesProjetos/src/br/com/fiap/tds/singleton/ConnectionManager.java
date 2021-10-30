package br.com.fiap.tds.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Classe que possui uma unica instancia dentro da aplicacao
 * @author diego
 *
 */
public class ConnectionManager {

	// 1-Atributo estatico que armazena a unica instancia
	private static ConnectionManager manager;
	
	//Atributo que armazena as informacoes do arquivo .properties
	private static Properties propriedades;
	
	// 2- Construtor privado
	private ConnectionManager() {
		
	}
	
	// 3- Método getInstance que retorna a unica instancia
	public static ConnectionManager getInstance() throws FileNotFoundException, IOException{
		if(manager==null) {
			manager = new ConnectionManager();
			//Ler as informacoes do arquivo app.properties
			propriedades = new Properties();
			propriedades.load(new FileInputStream("app.properties"));
		}
		return manager;
	}
	
	//Método que obtem uma conexao cm o banco de dados
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		//Registrar o driver
		Class.forName(propriedades.getProperty("driver"));
		//Obter uma conexão com o banco de dados (string conexão, usuario, senha)
		Connection conexao = DriverManager.getConnection(propriedades.getProperty("url"), propriedades.getProperty("usuario"), propriedades.getProperty("senha"));
		return conexao;
	}
}
