package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.fiap.tds.bean.Categoria;
import br.com.fiap.tds.dao.CategoriaDao;
import br.com.fiap.tds.exception.DadoInvalidoException;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que contém as regras de negócio e validações
 * @author Thiago Yamamoto
 */
public class CategoriaBo {
	
	private CategoriaDao categoriaDao;
	
	/**
	 * Construtor que recebe a conexão
	 * @param conexao conexão com o banco de dados
	 */
	public CategoriaBo(Connection conexao) {
		categoriaDao = new CategoriaDao(conexao);
	}

	public void cadastrar(Categoria categoria) throws SQLException, DadoInvalidoException {
		validar(categoria);
		categoriaDao.cadastrar(categoria);
	}
	
	private void validar(Categoria categoria) throws DadoInvalidoException {
		if (categoria.getNome() == null || categoria.getNome().length() > 40) {
			throw new DadoInvalidoException("Nome é obrigatório e deve conter menos de 40 carcteres");
		}
	}
	
	public void atualizar(Categoria categoria) throws SQLException, IdNotFoundException, DadoInvalidoException {
		validar(categoria);
		categoriaDao.atualizar(categoria);
	}
	
	public Categoria pesquisar(int codigo) throws SQLException, IdNotFoundException {
		return categoriaDao.pesquisar(codigo);
	}
	
	public List<Categoria> listar() throws SQLException{
		return categoriaDao.listar();
	}
	
	public void remover(int codigo) throws SQLException, IdNotFoundException {
		categoriaDao.remover(codigo);
	}
	
}