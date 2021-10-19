package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.tds.bean.Categoria;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que realiza as operações básicas com a Categoria e a tabela T_CATEGORIA
 * @author Thiago Yamamoto
 *
 */
public class CategoriaDao {

	private Connection conexao;

	/**
	 * Construtor que recebe a conexão como injeção de dependência
	 * @param conexao
	 */
	public CategoriaDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	/**
	 * Recebe o resultado de uma pesquisa e retorna a lista de categorias
	 * 
	 * @param result Resultado de uma pesquisa
	 * @return List<Categoria> lista de categoria
	 * @throws SQLException
	 */
	private List<Categoria> parseList(ResultSet result) throws SQLException {
		List<Categoria> lista = new ArrayList<>();
		while (result.next()) {
			Categoria categoria = parse(result);
			lista.add(categoria);
		}
		return lista;
	}

	/**
	 * Cadastra uma nova categoria no banco de dados
	 * 
	 * @param categoria Objeto com os valores que serão cadastrados
	 * @throws SQLException
	 */
	public void cadastrar(Categoria categoria) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement(
				"insert into t_categoria (cd_categoria, nm_categoria, dt_cadastro)" +
						" values (sq_t_categoria.nextval, ?, to_date(?, 'dd/mm/yyyy'))");

		stmt.setString(1, categoria.getNome());
		stmt.setString(2, categoria.getData());

		stmt.executeUpdate();
	}

	/**
	 * Atualiza uma categoria no banco de dados
	 * 
	 * @param categoria Categoria com os valores que serão atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void atualizar(Categoria categoria) throws SQLException, IdNotFoundException {

		PreparedStatement stmt = conexao.prepareStatement("update t_categoria set nm_categoria = ?, "
				+ "dt_cadastro = to_date(?,'dd/mm/yyyy') where cd_categoria = ?");

		stmt.setString(1, categoria.getNome());
		stmt.setString(2, categoria.getData());
		stmt.setInt(3, categoria.getCodigo());

		int qtd = stmt.executeUpdate();

		if (qtd == 0)
			throw new IdNotFoundException("Categoria não encontrada");
	}

	/**
	 * Pesquisa uma categoria pela PK
	 * 
	 * @param codigo PK da categoria
	 * @return Categoria categoria com os valores encontrados
	 * @throws SQLException
	 * @throws IdNotFoundException Não foi encontrado nenhuma categoria com a chave informada
	 */
	public Categoria pesquisar(int codigo) throws SQLException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement("select * from t_categoria where cd_categoria = ?");
		
		stmt.setInt(1, codigo);
		
		ResultSet result = stmt.executeQuery();
		
		if (!result.next()) {
			throw new IdNotFoundException("Categoria não encontrado");
		}
		
		return parse(result);
	}

	/**
	 * Retorna todos as categorias do banco de dados
	 * 
	 * @return List<Categoria> Lista de categorias
	 * @throws SQLException
	 */
	public List<Categoria> listar() throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("select * from t_categoria");

		ResultSet result = stmt.executeQuery();

		return parseList(result);
	}

	/**
	 * Recupera as informações de um registro do banco e retorna a categoria
	 * 
	 * @param result ResultSet o(s) registro(s) encontrado(s)
	 * @return Categoria Categoria com os valores do banco de dados
	 * @throws SQLException
	 */
	private Categoria parse(ResultSet result) throws SQLException {
		int codigo = result.getInt("cd_categoria");
		String nome = result.getString("nm_categoria");
		String data = result.getString("dt_cadastro");

		Categoria categoria = new Categoria(codigo, nome, data);
		return categoria;
	}

	/**
	 * Remove uma categoria do banco de dados
	 * 
	 * @param codigo PK da categoria
	 * @throws SQLException
	 * @throws IdNotFoundException Id não encontrado para ser removido
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement("delete from t_categoria where cd_categoria = ?");

		stmt.setInt(1, codigo);

		int qtd = stmt.executeUpdate();

		if (qtd == 0)
			throw new IdNotFoundException("Categoria não encontrada para ser removido");
	}
}
