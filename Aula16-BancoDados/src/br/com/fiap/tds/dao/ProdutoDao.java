package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tds.bean.Produto;

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
	
	public void cadastrar(Produto produto) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO TDSS_TB_PRODUTO "
				+ "(CD_PRODUTO, NM_PRODUTO, DS_PRODUTO, VL_PRODUTO, NM_FORNECEDOR"
				+ " VALUES (SQ_TB_PRODUTO.NEXTVAL, ?, ?, ?, ?)");
		
		//passar os valores para o comando SQL
		stmt.setString(1, produto.getNome());
		stmt.setString(2, produto.getDescricao());
		stmt.setDouble(3, produto.getValor());
		stmt.setString(4, produto.getNomeFornecedor());
		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
	//Lista e remover
	
	public void atualizar(Produto produto) {
		
	}
	
	public Produto pesquisar(int codigo) {
		return null;
	}

}
