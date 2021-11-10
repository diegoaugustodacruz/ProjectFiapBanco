package br.com.fiap.tds.factory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import br.com.fiap.tds.dao.DoacaoVendaDAO;
import br.com.fiap.tds.dao.EnderecoDAO;
import br.com.fiap.tds.dao.ProdutoDAO;
import br.com.fiap.tds.dao.SupermercadoDAO;
import br.com.fiap.tds.dao.TelefoneDAO;
import br.com.fiap.tds.dao.oracle.DoacaoVendaOracleDAO;
import br.com.fiap.tds.dao.oracle.EnderecoOracleDAO;
import br.com.fiap.tds.dao.oracle.ProdutoOracleDAO;
import br.com.fiap.tds.dao.oracle.SupermercadoOracleDAO;
import br.com.fiap.tds.dao.oracle.TelefoneOracleDAO;
import br.com.fiap.tds.singleton.ConnectionManager;


public abstract class DaoFactory {	
	
	public static SupermercadoDAO getSupermercadoDAO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return new SupermercadoOracleDAO(ConnectionManager.getInstance().getConnection());
	}
	
	public static ProdutoDAO getProdutoDAO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return new ProdutoOracleDAO(ConnectionManager.getInstance().getConnection());
	}
	
	public static TelefoneDAO getTelefoneDAO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return new TelefoneOracleDAO(ConnectionManager.getInstance().getConnection());
	}
	
	public static EnderecoDAO getEnderecoDAO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return new EnderecoOracleDAO(ConnectionManager.getInstance().getConnection());
	}
	
	public static DoacaoVendaDAO getDoacaoVendaDAO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return new DoacaoVendaOracleDAO(ConnectionManager.getInstance().getConnection());
	}

}
