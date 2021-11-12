package br.com.fiap.tds.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.dao.ProdutoDAO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.to.ProdutoTO;

public class ProdutoOracleDAO implements ProdutoDAO{
	
	private Connection conexao;

	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public ProdutoOracleDAO(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	/**
	 * Pesquisa os produtos por parte do nome
	 * @param nome Termo de pesquisa
	 * @return List<Produto> Lista dos produtos encontrados
	 * @throws SQLException
	 */
	@Override
	public List<ProdutoTO> buscarPorNome(String nome) throws SQLException{
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_PRODUTO WHERE NM_PRODUTO LIKE ?");

		stmt.setString(1,"%" + nome + "%");		
		
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);	
		
		
	}
	
	/**
	 * Recebe o resultado de uma pesquisa e retora uma lista
	 * @param result Resultado de uma pesquisa
	 * @return List<Produto> lista de produtos
	 * @throws SQLException
	 */
	private List<ProdutoTO> parseList(ResultSet result) throws SQLException{
		List<ProdutoTO> lista = new ArrayList<ProdutoTO>();
		
		while(result.next()) {			
			ProdutoTO produto = parse(result);
			lista.add(produto);
		}
		return lista;
		
	}
	
	

	/**
	 * Cadastra um produto no banco de dados
	 * @param produto Produto com valores que serao cadastrados
	 * @throws SQLException
	 */
	@Override
	public void cadastrar(ProdutoTO produto) throws SQLException {

		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_PRODUTO "
				+ "(CD_PRODUTO, NM_PRODUTO, QT_ESTOQUE, DT_CADASTRO, DT_VALIDADE, VL_UNITARIO, VL_TOTAL)"
				+ " VALUES (SQ_T_PRODUTO.NEXTVAL, ?, ?, SYSDATE, ?, ?, ?)", new String[] {"CD_PRODUTO"});
		
		stmt.setString(1, produto.getNome());
		stmt.setInt(2, produto.getQuantidade());
		stmt.setString(3, produto.getDataValidade());
		stmt.setDouble(4, produto.getValorUnitario());
		stmt.setDouble(5, produto.getValorTotal());


		
		stmt.executeUpdate();
		
		ResultSet result = stmt.getGeneratedKeys();
		if(result.next()) {
			int codigo = result.getInt(1);
			produto.setIdProduto(codigo);
		}
	}
	
	/**
	 * Atualiza produto no banco de dados
	 * @param produto Produto com valores que serao atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@Override
	public void atualizar(ProdutoTO produto) throws SQLException, IdNotFoundException{
		pesquisar(produto.getIdProduto());
		
		PreparedStatement stmt = conexao.prepareStatement("UPDATE T_PRODUTO SET NM_SUPERMERCADO = ?, QT_ESTOQUE = ?,"
				+ " DT_VALIDADE = ?, VL_UNITARIO = ?, VL_TOTAL = ? WHERE ID_USUARIO = ?");
		stmt.setString(1, produto.getNome());
		stmt.setInt(2, produto.getQuantidade());
		stmt.setString(3, produto.getDataValidade());
		stmt.setDouble(4, produto.getValorUnitario());
		stmt.setDouble(5, produto.getValorTotal());		
		stmt.setInt(6, produto.getIdProduto());

		int qtd = stmt.executeUpdate();		

		if(qtd == 0) {
			throw new IdNotFoundException("Produto não encontrado");
		}

		
	}
	
	/**
	 * Pesquisa um produto no banco de dados pela PK
	 * @param codigo PK do produto
	 * @return Produto produto com valores encontrados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@Override
	public ProdutoTO pesquisar(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_PRODUTO WHERE CD_PRODUTO = ?");
		
		stmt.setInt(1, codigo);		

		ResultSet result = stmt.executeQuery();

		if(!result.next()) {
			throw new IdNotFoundException("Produto não encontrado");
			
		}
		
		ProdutoTO produto = parse(result);
		
		return produto;
	}
	
	/**
	 * Retorna todos os produtos do banco de dados
	 * @return List<Produto> Lista de produtos
	 * @throws SQLException
	 */
	@Override
	public List<ProdutoTO> listar() throws SQLException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_PRODUTOS");
		
		ResultSet result = stmt.executeQuery();

		List<ProdutoTO> lista = new ArrayList<ProdutoTO>();

		while(result.next()) {			
			ProdutoTO produto = parse(result);
			lista.add(produto);
		}
		return lista;
	}

	/**
	 * Recupera as informacoes de um registro do banco e retorna o produto
	 * @param result ResultSet o(s) registro(s) encontrados
	 * @return Produto produto com os valores do banco de dados
	 * @throws SQLException
	 */
	private ProdutoTO parse(ResultSet result) throws SQLException {

		int codigo = result.getInt("CD_PRODUTO");
		String nome = result.getString("NM_PRODUTO");
		int quantidade = result.getInt("QT_ESTOQUE");
		String dataCadastro = result.getString("DT_CADASTRO");
		String dataValidade = result.getString("DT_VALIDADE");
		double valorUnitario = result.getDouble("VL_UNITARIO");
		double valorTotal = result.getDouble("VL_TOTAL");
		
		ProdutoTO produto = new ProdutoTO(codigo, nome, quantidade, dataCadastro, dataValidade, valorUnitario, valorTotal);
		
		return produto;			
	}
	
	/**
	 * Remove um produto no banco de dados
	 * @param codigo PK do produto
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@Override
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_PRODUTO WHERE CD_PRODUTO = ?");

		stmt.setInt(1, codigo);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Produto não encontrado para ser removido");
		}
	}
	
	@Override
	protected void finalize() throws Throwable{
		conexao.close();
	}

}
