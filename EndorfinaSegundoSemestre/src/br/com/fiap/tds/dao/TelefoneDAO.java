package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.bean.Endereco;
import br.com.fiap.tds.bean.Telefone;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que realiza operacoes basicas com o telefone no banco
 * @author Endorfina
 *
 */
public class TelefoneDAO {

	private Connection conexao;

	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public TelefoneDAO(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	/**
	 * Pesquisa os enderecos por parte do numero
	 * @param ddd Termo de pesquisa
	 * @return List<Telefone> Lista dos telefones encontrados
	 * @throws SQLException
	 */
	public List<Telefone> buscarPorNumero(int ddd) throws SQLException{
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_TEL WHERE NR_NUMERO LIKE ?");

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
	private List<Telefone> parseList(ResultSet result) throws SQLException{
		List<Telefone> lista = new ArrayList<Telefone>();
		
		while(result.next()) {			
			Telefone telefone = parse(result);
			lista.add(telefone);
		}
		return lista;                                                                                                                                                                                           
		
	}

	/**
	 * Cadastra um telefone de um usuario no banco de dados
	 * @param telefone Telefone com valores que serao cadastrados
	 * @throws SQLException
	 */
	public void cadastrarUsuario(Telefone telefone) throws SQLException {

		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_TEL "
				+ "(ID_TEL, ID_USUARIO, NR_NUMERO, NR_DDD, NR_DDI)"
				+ " VALUES (SQ_ENDORF_TEL.NEXTVAL, ?, ?, ?, ?)");
		
		stmt.setInt(1, telefone.getUsuario().getIdUsuario());
		stmt.setInt(2, telefone.getNumeroTel());
		stmt.setInt(3, telefone.getDdd());
		stmt.setInt(4, telefone.getDdi());
		
		stmt.executeUpdate();
	}
	
	/**
	 * Cadastra um telefone de um profissional no banco de dados
	 * @param telefone Telefone com valores que serao cadastrados
	 * @throws SQLException
	 */
	public void cadastrarProfissional(Telefone telefone) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_TEL "
				+ "(ID_TEL, ID_PROFISSIONAL, NR_NUMERO, NR_DDD, NR_DDI)"
				+ " VALUES (SQ_ENDORF_TEL.NEXTVAL, ?, ?, ?, ?)");
		
		stmt.setInt(1, telefone.getProfissional().getIdProfissional());
		stmt.setInt(2, telefone.getNumeroTel());
		stmt.setInt(3, telefone.getDdd());
		stmt.setInt(4, telefone.getDdi());
		
		stmt.executeUpdate();
	}
	
	/**
	 * Atualiza telefone no banco de dados
	 * @param telefone Telefone com valores que serao atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void atualizar(Telefone telefone) throws SQLException, IdNotFoundException{
		pesquisar(telefone.getIdTelefone());
		
		PreparedStatement stmt = conexao.prepareStatement("UPDATE ENDORF_TEL SET NR_NUMERO = ?, NR_DDD = ?,"
				+ " NR_DDI = ? WHERE ID_TEL = ?");
		stmt.setInt(1, telefone.getNumeroTel());
		stmt.setInt(2, telefone.getDdi());
		stmt.setInt(3, telefone.getDdi());
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
	public Telefone pesquisar(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_TEL WHERE ID_TEL = ?");
		
		stmt.setInt(1, codigo);		

		ResultSet result = stmt.executeQuery();

		if(!result.next()) {
			throw new IdNotFoundException("Usuario não encontrado");
			
		}
		
		Telefone telefone = parse(result);
		
		return telefone;
	}
	
	/**
	 * Retorna todos os telefones do banco de dados
	 * @return List<Telefone> Lista de telefones
	 * @throws SQLException
	 */
	public List<Telefone> listar() throws SQLException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_TEL");
		
		ResultSet result = stmt.executeQuery();

		List<Telefone> lista = new ArrayList<Telefone>();

		while(result.next()) {			
			Telefone telefone = parse(result);
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
	private Telefone parse(ResultSet result) throws SQLException {

		int id = result.getInt("ID_TEL");
		int numeroTel = result.getInt("NR_NUMERO");
		int numeroDDD = result.getInt("NR_DDD");
		int numeroDDI = result.getInt("NR_DDI");
		
		Telefone telefone = new Telefone(id, numeroDDI, numeroDDD, numeroTel);
		
		return telefone;			
	}
	
	/**
	 * Remove um telefone no banco de dados
	 * @param codigo PK do telefone
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM ENDORF_TEL WHERE ID_TEL = ?");

		stmt.setInt(1, codigo);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Telefone não encontrado para ser removido");
		}
	}
	
}
