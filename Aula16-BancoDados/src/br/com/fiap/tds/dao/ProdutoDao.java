package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que realiza as oepracoes basicas com o produto no banco
 * @author accountfy
 *
 */
public class ProdutoDao {
	
	private Connection conexao;
	
	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public ProdutoDao(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	/**
	 * Pesquisa os produtos por parte do nome
	 * @param nome Termo de pesquisa
	 * @return List<Produto> Lista dos produtos encontrados
	 * @throws SQLException, IdNotFoundException
	 */
	public List<Produto> buscarPorNome(String nome) throws SQLException{
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM TDSS_PRODUTO WHERE NM_PRODUTO LIKE ?");

		//Passar o parametro para a query
		stmt.setString(1,"%" + nome + "%");		
		
		//Executar
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);	
		
		
	}
	
	/**
	 * Rece o resultado de uma pesquisa e retora uma lista
	 * @param result Resultado de uma pesquisa
	 * @return List<Produto> lista de produtos
	 * @throws SQLException
	 */
	private List<Produto> parseList(ResultSet result) throws SQLException{
		//Criar uma lista de produtos
		List<Produto> lista = new ArrayList<Produto>();
		
		//Ler os registros encontrados
		while(result.next()) {			
			Produto produto = parse(result);
			//Adicionar na lista
			lista.add(produto);
			//Retornar a lista
		}
		return lista;
		
	}
	
	public void cadastrar(Produto produto) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO TDSS_PRODUTO "
				+ "(CD_PRODUTO, NM_PRODUTO, DS_PRODUTO, VL_PRODUTO, NM_FORNECEDOR)"
				+ " VALUES (SQ_TB_PRODUTO.NEXTVAL, ?, ?, ?, ?)");
		
		//passar os valores para o comando SQL
		stmt.setString(1, produto.getNome());
		stmt.setString(2, produto.getDescricao());
		stmt.setDouble(3, produto.getValor());
		stmt.setString(4, produto.getNomeFornecedor());
		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
	
	/**
	 * Atualiza produto no banco de dados
	 * @param produto Produto com valores que serao atualizados
	 * @throws SQLException
	 */
	public void atualizar(Produto produto) throws SQLException, IdNotFoundException{
		
		//Verificar se o produto existe para ser pesquisado
		pesquisar(produto.getCodigo());
		
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("UPDATE TDSS_PRODUTO SET NM_PRODUTO = ?, DS_PRODUTO = ?,"
				+ " VL_PRODUTO = ?, NM_FORNECEDOR = ? WHERE CD_PRODUTO = ?");
		
		//passar os valores para o comando SQL
		stmt.setString(1, produto.getNome());
		stmt.setString(2, produto.getDescricao());
		stmt.setDouble(3, produto.getValor());
		stmt.setString(4, produto.getNomeFornecedor());
		stmt.setInt(5, produto.getCodigo());
		
		//Executar o comando SQL
		int qtd = stmt.executeUpdate();		
		
		//Verifica se atualizou o produto no banco
		if(qtd == 0) {
			throw new IdNotFoundException("Produto não encontrado");
		}
		
	}
	
	/**
	 * Pesquisa um produto pela PK
	 * @param codigo PK do produt
	 * @return Produto produto com os valores encontrados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Produto pesquisar(int codigo) throws SQLException, IdNotFoundException {
		
		//Criar o comand SQL
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM TDSS_PRODUTO WHERE CD_PRODUTO = ?");

		//Passar o código para a query
		stmt.setInt(1, codigo);		
		
		//Executar
		ResultSet result = stmt.executeQuery();
		
		//Posiciona o cursor no primeiro registro e verifica se encontrou um produto
		if(!result.next()) {
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
	 */
	public List<Produto> listar() throws SQLException{
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM TDSS_PRODUTO");
		
		//Executa o comando
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);
		
	}

	/**
	 * Recupera as informacoes de umr registro do banco e retorna o produto
	 * @param result ResultSet o(s) registro(s) encontrados
	 * @return Produto produto com os valores do banco de dados
	 * @throws SQLException
	 */
	private Produto parse(ResultSet result) throws SQLException {
		//Recuperar os dados do produto
		int cd = result.getInt("CD_PRODUTO");
		String nome = result.getString("NM_PRODUTO");
		String descricao = result.getString("DS_PRODUTO");
		String fornecedor = result.getString("NM_FORNECEDOR");
		double valor = result.getDouble("VL_PRODUTO");
		
		//Instanciar o produto
		Produto produto = new Produto(cd, nome, descricao, valor, fornecedor);
		return produto;
	}
	
	/**
	 * Remove um produto no banco de dados
	 * @param codigo PK do produto
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM TDSS_PRODUTO WHERE CD_PRODUTO = ?");
		
		//Setar o parâmetro na query
		stmt.setInt(1, codigo);	
		
		//Executar a query
		int qtd = stmt.executeUpdate();
		
		//Verificar se o produto foi removido
		if(qtd == 0) {
			throw new IdNotFoundException("Produto não encontrado para ser removido");
		}
	}
	
}
