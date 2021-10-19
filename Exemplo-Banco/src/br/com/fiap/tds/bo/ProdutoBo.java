package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.bean.Categoria;
import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.dao.ProdutoDao;
import br.com.fiap.tds.exception.DadoInvalidoException;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que contém as regras de negócio e validações
 * @author Thiago Yamamoto
 */
public class ProdutoBo {
	
	private ProdutoDao produtoDao;
	private CategoriaBo categoriaBo;
	
	/**
	 * Construtor que recebe a conexão
	 * @param conexao conexão com o banco de dados
	 */
	public ProdutoBo(Connection conexao) {
		produtoDao = new ProdutoDao(conexao);
		categoriaBo = new CategoriaBo(conexao);
	}

	/**
	 * Cadastra um produto realizando a validação
	 * @param produto
	 * @throws SQLException
	 * @throws DadoInvalidoException
	 */
	public void cadastrar(Produto produto) throws SQLException, DadoInvalidoException {
		validar(produto);
		produtoDao.cadastrar(produto);
	}
	
	private void validar(Produto produto) throws DadoInvalidoException {
		if (produto.getNome() == null || produto.getNome().length() > 80) {
			throw new DadoInvalidoException("Nome é obrigatório e deve conter menos de 80 carcteres");
		}
		if (produto.getValor() <= 0) {
			throw new DadoInvalidoException("O valor não pode ser menor ou igual a zero");
		}
		if (produto.getDescricao() != null && produto.getDescricao().length() > 255) {
			throw new DadoInvalidoException("A descrição deve conter menos do que 255 caracteres");
		}
		if (produto.getNomeFornecedor() != null && produto.getNomeFornecedor().length() > 80) {
			throw new DadoInvalidoException("O fornecedor deve conter menos do que 80 caracteres");
		}
	}
	
	public List<Produto> buscarPorNome(String nome) throws SQLException{
		return produtoDao.buscarPorNome(nome);
	}
	
	public void atualizar(Produto produto) throws SQLException, IdNotFoundException, DadoInvalidoException {
		validar(produto);
		produtoDao.atualizar(produto);
	}
	
	public Produto pesquisar(int codigo) throws SQLException, IdNotFoundException {
		Produto produto = produtoDao.pesquisar(codigo);
		//Pesquisa a categoria do produto
		try {
			//Trata caso não encontre a categoria
			Categoria categoria = categoriaBo.pesquisar(produto.getCategoria().getCodigo());
			produto.setCategoria(categoria);
		} catch(IdNotFoundException e) {
			e.printStackTrace();
		}
		return produto;
	}
	
	public List<Produto> listar() throws SQLException{
		return produtoDao.listar();
	}
	
	public void remover(int codigo) throws SQLException, IdNotFoundException {
		produtoDao.remover(codigo);
	}
	
}