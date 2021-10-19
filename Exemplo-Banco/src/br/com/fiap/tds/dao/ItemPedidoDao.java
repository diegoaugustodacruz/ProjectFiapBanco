package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.fiap.tds.bean.ItemPedido;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que realiza as operações básicas com o ItemPedido no banco de dados
 * 
 * @author Thiago Yamamoto
 */
public class ItemPedidoDao {

	private Connection conexao;

	/**
	 * Construtor que recebe a conexão como injeção de dependência
	 * @param conexao
	 */
	public ItemPedidoDao(Connection conexao) {
		this.conexao = conexao;
	}

	/**
	 * Cadastra o relacionamento com o pedido e produto
	 * 
	 * @param ItemPedido com as chaves do relacionamento
	 * @throws SQLException
	 */
	public void cadastrar(ItemPedido item) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement( "insert into t_item_pedido (cd_produto, cd_pedido) values "
				+ "(?, ?)");

		stmt.setInt(1, item.getProduto().getCodigo());
		stmt.setInt(2, item.getPedido().getCodigo());

		stmt.executeUpdate();
	}

	/**
	 * Remove um item do pedido
	 * 
	 * @param codigo PK do produto e do pedido
	 * @throws SQLException
	 * @throws IdNotFoundException Id não encontrado para ser removido
	 */
	public void remover(int codigoProduto, int codigoPedido) throws SQLException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement("delete from t_item_produto where cd_produto = ? and cd_pedido = ?");

		stmt.setInt(1, codigoProduto);
		stmt.setInt(2, codigoPedido);

		int qtd = stmt.executeUpdate();

		if (qtd == 0)
			throw new IdNotFoundException("Item não encontrado para ser removido");
	}
}
