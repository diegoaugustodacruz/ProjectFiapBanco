package br.com.fiap.tds.bo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.dao.ProdutoDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.DaoFactory;
import br.com.fiap.tds.to.ProdutoTO;
import br.com.fiap.tds.to.SupermercadoTO;

/**
 * Classe que contem as regras de negocios e validacoes do produto
 * @author Diego
 *
 */
public class ProdutoBO {
	
	private ProdutoDAO produtoDao;
	
	/**
	 * Construtor que inicializa a conexao
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public ProdutoBO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		produtoDao = DaoFactory.getProdutoDAO();
	}
	
	/**
	 * Regras de negocio para cadastramento do produto
	 * @param produto Produto que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void cadastrar(ProdutoTO produto) throws SQLException, DadosInvalidosException{
		validar(produto);		
		
		produtoDao.cadastrar(produto);
	}
	
	/**
	 * Regras de negocio para buscar informacoes pelo nome de um produto
	 * @param nome Nome do produto
	 * @return retorna lista com as informacoes
	 * @throws SQLException
	 */
	public List<ProdutoTO> buscarPorNome(String nome) throws SQLException{
		return produtoDao.buscarPorNome(nome);
	}
	
	/**
	 * Regras de negocio para atualizar um produto
	 * @param produto Produto com valores a serem atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws DadosInvalidosException
	 */
	public void atualizar(ProdutoTO produto) throws SQLException, IdNotFoundException, DadosInvalidosException{
		validar(produto);

		produtoDao.atualizar(produto);
	}

	/**
	 * Regras de negocio para pesquisar um produto pela sua PK
	 * @param codigo PK do produto
	 * @return informacoes do produto
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public ProdutoTO pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return produtoDao.pesquisar(codigo);
	}
	
	/**
	 * Regras de negocio para listar os produtos cadastrados
	 * @return Lista produto
	 * @throws SQLException
	 */
	public List<ProdutoTO> listar() throws SQLException{
		return produtoDao.listar();
	}
	
	/**
	 * Remove um produto
	 * @param codigo PK do produto
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		produtoDao.remover(codigo);			
		
	}
	
	/**
	 * Validacao das regras de negocio
	 * @param produto Produto para ser cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void validar(ProdutoTO produto)  throws SQLException, DadosInvalidosException{
		
		if(produto.getNome()==null || produto.getNome().length()>70) {
			throw new DadosInvalidosException("Nome é obrigatorio e deve conter menos de 70 caracteres");
		}
		
		if(produto.getQuantidade()==0 || produto.getQuantidade()>999999999) {
			throw new DadosInvalidosException("Quantidade é obrigatorio e deve conter menos de 1000000000 numeros");
		}		
		
		if(produto.getValorUnitario()==0 || produto.getValorUnitario()>999999999) {
			throw new DadosInvalidosException("Valor unitário é obrigatorio e deve conter menos de 1000000000 numeros");
		}			
		
		if(produto.getValorTotal()==0 || produto.getValorTotal()>999999999) {
			throw new DadosInvalidosException("Valor total é obrigatorio e deve conter menos de 1000000000 numeros");
		}	
	}
}
