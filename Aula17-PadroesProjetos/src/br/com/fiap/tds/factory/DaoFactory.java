package br.com.fiap.tds.factory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import br.com.fiap.tds.dao.AlimentoDAO;
import br.com.fiap.tds.dao.RestauranteDAO;
import br.com.fiap.tds.dao.oracle.AlimentoOracleDAO;
import br.com.fiap.tds.dao.oracle.RestauranteOracleDAO;
import br.com.fiap.tds.singleton.ConnectionManager;

//Fabrica de DAOs, classe que instancia os DAOs

//Classe abstrata -> não pode ser instanciada e pode conter métodos abstratos (sem implementacao)
//Serve como estrutura para as classes filhas
public abstract class DaoFactory {
	
	//metodo abstrato
	//public abstract void teste();
	
	public static AlimentoDAO getAlimentoDAO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return new AlimentoOracleDAO(ConnectionManager.getInstance().getConnection());
	}
	
	public static RestauranteDAO getRestauranteDAO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return new RestauranteOracleDAO(ConnectionManager.getInstance().getConnection());
	}

}
