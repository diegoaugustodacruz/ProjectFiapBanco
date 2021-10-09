package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.dao.ProdutoDao;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.ConnectionFactory;

/**
 * Classe que contém as regras de negocios e validacoes
 * @author Diego
 *
 */
public class ProdutoBo {
	
	
	private ProdutoDao dao;
	
	/**
	 * Construtor que recebe a conexão
	 * @param conexao
	 */
	public ProdutoBo(Connection conexao) {
				
		dao = new ProdutoDao(conexao);
	}
	

	public void cadastrar(Produto produto) throws SQLException, DadosInvalidosException {
		//Validacoes
		if(produto.getNome()==null || produto.getNome().length()>80) {
			throw new DadosInvalidosException();
		}
		dao.cadastrar(produto);
	}
	
	public void atualizar(Produto produto) throws SQLException, IdNotFoundException{
		dao.atualizar(produto);
	}
	
	public Produto pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return dao.pesquisar(codigo);
	}
	
	public List<Produto> listar() throws SQLException{
		return dao.listar();
	}
	
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		dao.remover(codigo);
	}
	
}
