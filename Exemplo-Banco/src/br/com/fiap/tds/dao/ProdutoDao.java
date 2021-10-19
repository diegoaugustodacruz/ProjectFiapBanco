package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.bean.Categoria;
import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que realiza as operações básicas com o Produto no banco de dados
 * @author Thiago Yamamoto
 */
public class ProdutoDao {

	private Connection conexao;
	
	/**
	 * Construtor que recebe a conexão como injeção de dependência
	 * @param conexao
	 */
	public ProdutoDao(Connection conexao) {
		this.conexao = conexao;
	}

	/**
	 * Pesquisa os produtos por parte do nome
	 * @param nome Termo de pesquisa
	 * @return List<Produto> Lista dos produtos encontrados
	 * @throws SQLException 
	 */
	public List<Produto> buscarPorNome(String nome) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("select * from t_produto where nm_produto like ?");
		//Passar o parâmetro para a query
		stmt.setString(1, "%" + nome + "%" );
		//Executar 
		ResultSet result = stmt.executeQuery();
		return parseList(result);
	}
	
	/**
	 * Recebe o resultado de uma pesquisa e retorna a lista de produtos
	 * @param result Resultado de uma pesquisa
	 * @return List<Produto> lista de produtos
	 * @throws SQLException
	 */
	private List<Produto> parseList(ResultSet result) throws SQLException {
		//Criar uma lista de produtos
		List<Produto> lista = new ArrayList<>();
		//Ler os registros encontrados
		
		while (result.next()) {
			Produto produto = parse(result);
			//Adicionar na lista
			lista.add(produto);
		}
		//Retornar a lista
		return lista;
	}
	
	/**
	 * Cadastra um novo produto no banco de dados
	 * @param produto Objeto com os valores que serão cadastrados
	 * @throws SQLException
	 */
	public void cadastrar(Produto produto) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("insert into t_produto (cd_produto, "
				+ "nm_produto, ds_produto, vl_produto, nm_fornecedor, "
				+ "cd_categoria) values (sq_t_produto.nextval, ?, ?, ?, ?, ?)");
		
		//Passar os valores para o comando SQL
		stmt.setString(1, produto.getNome());
		stmt.setString(2, produto.getDescricao());
		stmt.setDouble(3, produto.getValor());
		stmt.setString(4, produto.getNomeFornecedor());
		stmt.setInt(5, produto.getCategoria().getCodigo());
		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
	/**
	 * Atualiza um produto no banco de dados 
	 * @param produto Produto com os valores que serão atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException 
	 */
	public void atualizar(Produto produto) throws SQLException, IdNotFoundException {
		
		//Verifica se o produto existe para ser pesquisado
		//pesquisar(produto.getCodigo());
		
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("update t_produto set nm_produto = ?, ds_produto = ?,"
				+ " vl_produto = ?, nm_fornecedor = ?, cd_categoria = ? where cd_produto = ?");
		
		//Passar os valores para a query
		stmt.setString(1, produto.getNome());
		stmt.setString(2, produto.getDescricao());
		stmt.setDouble(3, produto.getValor());
		stmt.setString(4, produto.getNomeFornecedor());
		stmt.setInt(5, produto.getCategoria().getCodigo());
		stmt.setInt(6, produto.getCodigo());
		
		//Executar a query e recuperar a qtd de linhas modificadas no banco
		int qtd = stmt.executeUpdate();
		
		//Verifica se atualizou o produto no banco
		if (qtd == 0)
			throw new IdNotFoundException("Produto não encontrado");
	}
	
	
	/**
	 * Pesquisa um produto pela PK
	 * @param codigo PK do produto
	 * @return Produto produto com os valores encontrados
	 * @throws SQLException
	 * @throws IdNotFoundException Não foi encontrado nenhum produto com a chave informada
	 */
	public Produto pesquisar(int codigo) throws SQLException, IdNotFoundException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("select * from t_produto where cd_produto = ?");
		
		//Passar o código para a query
		stmt.setInt(1, codigo);
		
		//Executar 
		ResultSet result = stmt.executeQuery();
		
		//Posicionar o cursor no primeiro registro e verificar se encontrou um produto
		if (!result.next()) {
			throw new IdNotFoundException("Produto não encontrado");
		}
		
		//Instanciar o produto
		Produto produto = parse(result);
		
		//Retornar o produto
		return produto;
	}
	
	/**
	 * Retorna todos os produtos do banco de dados
	 * @return List<Produto> Lista de produtos
	 * @throws SQLException 
	 */
	public List<Produto> listar() throws SQLException{
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("select * from t_produto");
		
		//Executar o comando
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);
	}

	/**
	 * Recupera as informações de um registro do banco e retorna o produto 
	 * @param result ResultSet o(s) registro(s) encontrado(s)
	 * @return Produto Produto com os valores do banco de dados
	 * @throws SQLException
	 */
	private Produto parse(ResultSet result) throws SQLException {
		//Recuperar os dados do produto
		int cd = result.getInt("cd_produto");
		String nome = result.getString("nm_produto");
		String descricao = result.getString("ds_produto");
		String fornecedor = result.getString("nm_fornecedor");
		double valor = result.getDouble("vl_produto");
		int categoria = result.getInt("cd_categoria");
		//Instanciar o produto
		Produto produto = new Produto(cd, nome, descricao, valor, fornecedor);
		produto.setCategoria(new Categoria(categoria));
		return produto;
	}
	
	/**
	 * Remove um produto do banco de dados 
	 * @param codigo PK do produto
	 * @throws SQLException 
	 * @throws IdNotFoundException Id não encontrado para ser removido
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("delete from t_produto where cd_produto = ?");

		//Setar o parâmetro na query
		stmt.setInt(1, codigo);

		//Executar a query
		int qtd = stmt.executeUpdate();
		
		//Verificar se o produto foi removido
		if (qtd == 0)
			throw new IdNotFoundException("Produto não encontrado para ser removido");
	}
	
}//class