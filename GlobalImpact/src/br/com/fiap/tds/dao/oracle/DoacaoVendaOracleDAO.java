package br.com.fiap.tds.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tds.dao.DoacaoVendaDAO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.to.DoacaoVendaTO;

public class DoacaoVendaOracleDAO implements DoacaoVendaDAO{

	private Connection conexao;

	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public DoacaoVendaOracleDAO(Connection conexao) {
		this.conexao = conexao;
		
	}

	/**
	 * Cadastra uma doacao/venda no banco de dados
	 * @param doacaoVenda DoacaoVenda com valores que serao cadastrados
	 * @throws SQLException
	 */
	@Override
	public void cadastrar(DoacaoVendaTO doacaoVenda) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_DOACAO_VENDA "
				+ "(CD_DOACAO_VENDA, CD_SUPERMERCADO, CD_PRODUTO) "
				+ "VALUES (SQ_T_DOACAO_VENDA, ?, ?)");
		
		stmt.setInt(1, doacaoVenda.getSupermercado().getCodigo());
		stmt.setInt(2, doacaoVenda.getProduto().getIdProduto());
		
		stmt.executeUpdate();
	}	
	
	
	/**
	 * Remove uma doacao/venda no banco de dados
	 * @param codigo PK da doacao/venda
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@Override
	public void remover(int codigoDoacaoVenda) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_DOACAO_VENDA WHERE CD_DOACAO_VENDA = ?");

		stmt.setInt(1, codigoDoacaoVenda);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Doacao/Venda não encontrada para ser removido");
		}
	}
	
}
