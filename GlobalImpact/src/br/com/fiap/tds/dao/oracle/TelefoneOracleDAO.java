package br.com.fiap.tds.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.dao.TelefoneDAO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.to.TelefoneTO;

/**
 * Classe que realiza operacoes basicas com o telefone no banco
 * @author Endorfina
 *
 */
public class TelefoneOracleDAO implements TelefoneDAO{

	private Connection conexao;

	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public TelefoneOracleDAO(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	/**
	 * Pesquisa os enderecos por parte do numero
	 * @param ddd Termo de pesquisa
	 * @return List<Telefone> Lista dos telefones encontrados
	 * @throws SQLException
	 */
	@Override
	public List<TelefoneTO> buscarPorNumero(int ddd) throws SQLException{
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_TELEFONE WHERE NR_NUMERO LIKE ?");

		String numero = Integer.toString(ddd);
		stmt.setString(1,"%" + numero + "%");		
		
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);
	}
	
	/**
	 * Recebe o resultado de uma pesquisa e retora uma lista
	 * @param result Resultado de uma pesquisa
	 * @return List<Telefone> lista de telefones
	 * @throws SQLException
	 */
	private List<TelefoneTO> parseList(ResultSet result) throws SQLException{
		List<TelefoneTO> lista = new ArrayList<TelefoneTO>();
		
		while(result.next()) {			
			TelefoneTO telefone = parse(result);
			lista.add(telefone);
		}
		return lista;                                                                                                                                                                                           
		
	}

	/**
	 * Cadastra um telefone de um usuario no banco de dados
	 * @param telefone Telefone com valores que serao cadastrados
	 * @throws SQLException
	 */
	@Override
	public void cadastrar(TelefoneTO telefone) throws SQLException {

		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_TELEFONE "
				+ "(CD_TELEFONE, CD_SUPERMERCADO, NR_TELEFONE, CD_DDD, CD_DDI) "
				+ "VALUES (SQ_ENDORF_TEL.NEXTVAL, ?, ?, ?, ?)");
		
		stmt.setInt(1, telefone.getSupermercado().getCodigo());
		stmt.setInt(2, telefone.getNumeroTel());
		stmt.setInt(3, telefone.getDdd());
		stmt.setString(4, telefone.getDdi());
		
		stmt.executeUpdate();
	}
	
	
	/**
	 * Atualiza telefone no banco de dados
	 * @param telefone Telefone com valores que serao atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@Override
	public void atualizar(TelefoneTO telefone) throws SQLException, IdNotFoundException{
		pesquisar(telefone.getIdTelefone());
		
		PreparedStatement stmt = conexao.prepareStatement("UPDATE T_TELEFONE SET CD_DDI = ?, CD_DDD = ?, NR_TELEFONE = ? WHERE CD_TELEFONE = ?");
		stmt.setString(1, telefone.getDdi());
		stmt.setInt(2, telefone.getDdd());
		stmt.setInt(3, telefone.getNumeroTel());
		stmt.setInt(4, telefone.getIdTelefone());

		int qtd = stmt.executeUpdate();		

		if(qtd == 0) {
			throw new IdNotFoundException("Telefone não encontrado");
		}
		
	}
	

	/**
	 * Pesquisa um telefone no banco de dados pela PK
	 * @param codigo PK do telefone
	 * @return Telefone telefone com valores encontrados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@Override
	public TelefoneTO pesquisar(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_TELEFONE WHERE CD_TELEFONE = ?");
		
		stmt.setInt(1, codigo);		

		ResultSet result = stmt.executeQuery();

		if(!result.next()) {
			throw new IdNotFoundException("Telefone não encontrado");
			
		}
		
		TelefoneTO telefone = parse(result);
		
		return telefone;
	}
	
	/**
	 * Retorna todos os telefones do banco de dados
	 * @return List<Telefone> Lista de telefones
	 * @throws SQLException
	 */
	@Override
	public List<TelefoneTO> listar() throws SQLException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_TELEFONE");
		
		ResultSet result = stmt.executeQuery();

		List<TelefoneTO> lista = new ArrayList<TelefoneTO>();

		while(result.next()) {			
			TelefoneTO telefone = parse(result);
			lista.add(telefone);
		}
		return lista;
	}
	
	/**
	 * Recupera as informacoes de um registro do banco e retorna o telefone
	 * @param result ResultSet o(s) registro(s) encontrados
	 * @return Telefone telefone com os valores do banco de dados
	 * @throws SQLException
	 */
	private TelefoneTO parse(ResultSet result) throws SQLException {

		int id = result.getInt("CD_TELEFONE");
		int numeroTel = result.getInt("NR_TELEFONE");
		int numeroDDD = result.getInt("CD_DDD");
		String numeroDDI = result.getString("CD_DDI");
		
		TelefoneTO telefone = new TelefoneTO(numeroDDI, numeroDDD, numeroTel, id);
		
		return telefone;			
	}
	
	/**
	 * Remove um telefone no banco de dados
	 * @param codigo PK do telefone
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@Override
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_TELEFONE WHERE CD_TELEFONE = ?");

		stmt.setInt(1, codigo);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Telefone não encontrado para ser removido");
		}
	}
	
	@Override
	protected void finalize() throws Throwable{
		conexao.close();
	}
}
