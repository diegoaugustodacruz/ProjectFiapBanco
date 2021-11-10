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
import br.com.fiap.tds.to.DoacaoVendaTO;

public class DoacaoVendaBO {

	private DoacaoVendaDAO doacaoVendaDao;
	private SupermercadoDAO supermercadoDao;
	private ProdutoDAO produtoDao;
	private Connection conexao;

	
	public DoacaoVendaBO(Connection conexao) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		doacaoVendaDao = DaoFactory.getDoacaoVendaDAO();
		this.conexao = conexao;


	}
	
	/**
	 * Regras de negocio para cadastramento da doacao/venda
	 * @param doacaoVenda DoacaoVenda que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void cadastrar(DoacaoVendaTO doacaoVenda) throws SQLException, DadosInvalidosException{
		conexao.setAutoCommit(false);
		
		supermercadoDao.cadastrar(doacaoVenda.getSupermercado());
		produtoDao.cadastrar(doacaoVenda.getProduto());		

		doacaoVendaDao.cadastrar(doacaoVenda);
		
		try {
			conexao.commit();
		}catch(Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar commit");
		}
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
