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
	/**
	 * Metodo que retorna a conexao para o supermercado
	 * @return conexao
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public static SupermercadoDAO getSupermercadoDAO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return new SupermercadoOracleDAO(ConnectionManager.getInstance().getConnection());
	}
	
	/**
	 * Metodo que retorna a conexao para o produto
	 * @return conexao
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public static ProdutoDAO getProdutoDAO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return new ProdutoOracleDAO(ConnectionManager.getInstance().getConnection());
	}
	
	/**
	 * Metodo que retorna a conexao para o telefone
	 * @return conexao
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public static TelefoneDAO getTelefoneDAO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return new TelefoneOracleDAO(ConnectionManager.getInstance().getConnection());
	}
	
	/**
	 * Metodo que retorna a conexao para o endereco
	 * @return conexao
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public static EnderecoDAO getEnderecoDAO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return new EnderecoOracleDAO(ConnectionManager.getInstance().getConnection());
	}
	
	/**
	 * Metodo que retorna a conexao para o doacao/venda
	 * @return conexao
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public static DoacaoVendaDAO getDoacaoVendaDAO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return new DoacaoVendaOracleDAO(ConnectionManager.getInstance().getConnection());
	}

}
