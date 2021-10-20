package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.bean.Hobby;
import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que realiza operacoes basicas do hobby com o banco de dados
 * @author Endorfina
 *
 */
public class HobbyDAO {
	
	private Connection conexao;

	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public HobbyDAO(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	/**
	 * Pesquisa os hobbies por parte do nome
	 * @param nome Termo de pesquisa
	 * @return List<Hobby> Lista dos hobbies encontrados
	 * @throws SQLException
	 */
	public List<Hobby> buscarPorNome(String nome) throws SQLException{
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_HOBBY WHERE NM_HOBBY LIKE ?");

		stmt.setString(1,"%" + nome + "%");		
		
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);		
		
	}
	
	/**
	 * Recebe o resultado de uma pesquisa e retora uma lista
	 * @param result Resultado de uma pesquisa
	 * @return List<Hobby> lista de hobbies
	 * @throws SQLException
	 */
	private List<Hobby> parseList(ResultSet result) throws SQLException{
		List<Hobby> lista = new ArrayList<Hobby>();
		
		while(result.next()) {			
			Hobby hobby = parse(result);
			lista.add(hobby);
		}
		return lista;
		
	}

	/**
	 * Cadastra um hobby no banco de dados
	 * @param hobby Hobby com valores que serao cadastrados
	 * @throws SQLException
	 */
	public void cadastrarHobby(Hobby hobby) throws SQLException {
		
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_HOBBY "
				+ "(ID_HOBBY, NM_HOBBY)"
				+ " VALUES (SQ_ENDORF_HOBBY.NEXTVAL, ?)", new String[] {"ID_HOBBY"});
		
		stmt.setString(1, hobby.getNomeHobby());
		
		stmt.executeUpdate();
		
		ResultSet result = stmt.getGeneratedKeys();
		if(result.next()) {
			int codigo = result.getInt(1);
			hobby.setIdHobby(codigo);
		}
	}
	
	/**
	 * Atualiza hobby no banco de dados
	 * @param hobby Hobby com valores que serao atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void atualizar(Hobby hobby) throws SQLException, IdNotFoundException{
		pesquisar(hobby.getIdHobby());
		
		PreparedStatement stmt = conexao.prepareStatement("UPDATE ENDORF_HOBBY SET NM_HOBBY = ? WHERE ID_HOBBY = ?");
		stmt.setString(1, hobby.getNomeHobby());
		stmt.setInt(2, hobby.getIdHobby());

		int qtd = stmt.executeUpdate();		

		if(qtd == 0) {
			throw new IdNotFoundException("Hobby não encontrado");
		}

	}
	
	/**
	 * Pesquisa um hobby no banco de dados pela PK
	 * @param codigo PK do hobby
	 * @return Hobby hobby com valores encontrados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Hobby pesquisar(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_HOBBY WHERE ID_HOBBY = ?");

		stmt.setInt(1, codigo);		

		ResultSet result = stmt.executeQuery();

		if(!result.next()) {
			throw new IdNotFoundException("Hobby não encontrado");
			
		}
		
		Hobby hobby = parse(result);
		
		return hobby;
	}
	
	/**
	 * Retorna todos os hobbies do banco de dados
	 * @return List<Hobby> Lista de hobbies
	 * @throws SQLException
	 */
	public List<Hobby> listar() throws SQLException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_HOBBY");
		
		ResultSet result = stmt.executeQuery();

		List<Hobby> lista = new ArrayList<Hobby>();

		while(result.next()) {			
			Hobby hobby = parse(result);
			lista.add(hobby);
		}
		return lista;
	}
	
	/**
	 * Recupera as informacoes de um registro do banco e retorna um hobby
	 * @param result ResultSet o(s) registro(s) encontrado(s)
	 * @return Hobby hobby com os valores do banco de dados
	 * @throws SQLException
	 */
	private Hobby parse(ResultSet result) throws SQLException{
		
		int id = result.getInt("ID_HOBBY");			
		String nome = result.getString("NM_HOBBY");
		
		Hobby hobby = new Hobby(id, nome);
		
		return hobby;
	}
	
	/**
	 * Remove um hobby no banco de dados
	 * @param codigo PK do hobby
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM ENDORF_HOBBY WHERE ID_HOBBY = ?");
		stmt.setInt(1, codigo);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Hobby não encontrado para ser removido");
		}


	}
		
}
