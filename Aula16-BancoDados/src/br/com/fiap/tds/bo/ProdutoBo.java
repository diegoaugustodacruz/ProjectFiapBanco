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
		validar(produto);
		dao.cadastrar(produto);
	}
	
	private void validar(Produto produto) throws DadosInvalidosException {
		
		if(produto.getNome()==null || produto.getNome().length()>80)  {
			throw new DadosInvalidosException("Nome é obrigatorio e deve conter menos de 80 caracteres");
		}
		if(produto.getValor() <= 0) {
			throw new DadosInvalidosException("O valor nao pode ser menor ou igual a zero");
		}
		if(produto.getDescricao() != null && produto.getDescricao().length() > 255) {
			throw new DadosInvalidosException("A descricao deve conter menos do que 255 caracteres");
		}
		if(produto.getNomeFornecedor() != null && produto.getNomeFornecedor().length() > 80) {
			throw new DadosInvalidosException("O fornecedor deve conter menos do que 80 caracteres");
		}		
	}
	
	public List<Produto> buscarPorNome(String nome) throws SQLException{
		return dao.buscarPorNome(nome);
	}
	
	
	public void atualizar(Produto produto) throws SQLException, IdNotFoundException, DadosInvalidosException{
		validar(produto);		
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
