package br.com.fiap.tds.bo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.tds.dao.DoacaoVendaDAO;
import br.com.fiap.tds.dao.ProdutoDAO;
import br.com.fiap.tds.dao.SupermercadoDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.DaoFactory;
import br.com.fiap.tds.singleton.ConnectionManager;
import br.com.fiap.tds.to.DoacaoVendaTO;

/**
 * Classe que contem as regras de negocios e validacoes da doacao e venda
 * @author Diego
 *
 */
public class DoacaoVendaBO {

	private DoacaoVendaDAO doacaoVendaDao;
	private SupermercadoDAO supermercadoDao;
	private ProdutoDAO produtoDao;
	private Connection conexao;

	/**
	 * Construtor que inicializa a conexao
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public DoacaoVendaBO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		doacaoVendaDao = DaoFactory.getDoacaoVendaDAO();
		supermercadoDao = DaoFactory.getSupermercadoDAO();
		produtoDao = DaoFactory.getProdutoDAO();		
		this.conexao = ConnectionManager.getInstance().getConnection();


	}
	
	/**
	 * Regras de negocio para cadastramento da doacao/venda
	 * @param doacaoVenda DoacaoVenda que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void cadastrar(DoacaoVendaTO doacaoVenda) throws SQLException, DadosInvalidosException{
//		conexao.setAutoCommit(false);
		
		supermercadoDao.cadastrar(doacaoVenda.getSupermercado());
		produtoDao.cadastrar(doacaoVenda.getProduto());		

		doacaoVendaDao.cadastrar(doacaoVenda);
		
//		try {
//			conexao.commit();
//		}catch(Exception e) {
//			conexao.rollback();
//			throw new SQLException("Erro ao realizar commit");
//		}
	}
	
	/**
	 * Remove uma doacao/venda
	 * @param codigo PK do doacaoVenda
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		doacaoVendaDao.remover(codigo);		
		
		
	}	
}
