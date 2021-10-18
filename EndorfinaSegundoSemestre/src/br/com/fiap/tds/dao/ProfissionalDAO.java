package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.bean.Profissional;
import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que realiza operacoes basias com o profissional no banco
 * @author accountfy
 *
 */
public class ProfissionalDAO {
	
	private Connection conexao;

	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public ProfissionalDAO(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	
	public List<Profissional> buscarPorNome(String nome) throws SQLException{
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_PROFI WHERE NM_PROFISSIONAL LIKE ?");
		stmt.setString(1,"%" + nome + "%");		
		
		//Executar
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);
	}
	
	private List<Profissional> parseList(ResultSet result) throws SQLException{
		List<Profissional> lista = new ArrayList<Profissional>();
		
		while(result.next()) {			
			Profissional profissional = parse(result);
			lista.add(profissional);
		}
		return lista;
		
	}

	/**
	 * Cadastra um profissional no banco de dados
	 * @param profissional Profissional com valores que serao cadastrados
	 * @throws SQLException
	 */
	public void cadastrar(Profissional profissional) throws SQLException {

		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_PROFI "
				+ "(ID_PROFISSIONAL, NM_PROFISSIONAL, DT_NASCIMENTO, DT_CADASTRO, DS_EMAIL, DS_SENHA)"
				+ " VALUES (SQ_ENDORF_USUARIO.NEXTVAL, ?, TO_DATE(?,'DD/MM/YYYY'), SYSDATE, ?, ?)", new String[] {"ID_PROFISSIONAL"});
		
		stmt.setString(1, profissional.getNome());
		stmt.setString(2, profissional.getDataNascimento());
		stmt.setString(3, profissional.getEmail());
		stmt.setString(4, profissional.getSenha());
		
		stmt.executeUpdate();
		
		ResultSet result = stmt.getGeneratedKeys();
		if(result.next()) {
			int codigo = result.getInt(1);
			profissional.setIdProfissional(codigo);
		}
	}
	
		/**
		 * Atualiza profissional no banco de dados
		 * @param profissional Profissional com valores que serao atualizados
		 * @throws SQLException
		 * @throws IdNotFoundException
		 */
	public void atualizar(Profissional profissional) throws SQLException, IdNotFoundException{
		
		pesquisar(profissional.getIdProfissional());
		
		PreparedStatement stmt = conexao.prepareStatement("UPDATE ENDORF_PROFI SET NM_PROFISSIONAL = ?, DT_NASCIMENTO = ?,"
				+ " DS_EMAIL = ?, DS_SENHA = ? WHERE ID_USUARIO = ?");
		stmt.setString(1, profissional.getNome());
		stmt.setString(2, profissional.getDataNascimento());
		stmt.setString(3, profissional.getEmail());
		stmt.setString(4, profissional.getSenha());
		stmt.setInt(5, profissional.getIdProfissional());

		int qtd = stmt.executeUpdate();		

		if(qtd == 0) {
			throw new IdNotFoundException("Usuario não encontrado");
		}

	}
	
	/**
	 * Pesquisa um profissional no banco de dados pela PK
	 * @param codigo PK do profissional
	 * @return Profissional profissional com valores encontrados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Profissional pesquisar(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_PROFI WHERE ID_PROFISSIONAL = ?");

		stmt.setInt(1, codigo);		

		ResultSet result = stmt.executeQuery();

		if(!result.next()) {
			throw new IdNotFoundException("Usuario não encontrado");
			
		}
		
		Profissional profissional= parse(result);
		
		return profissional;
	}
	
	/**
	 * Retorna todos os profissionais do banco de dados
	 * @return List<Profissional> Lista de profissionais
	 * @throws SQLException
	 */
	public List<Profissional> listar() throws SQLException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_PROFI");
		
		ResultSet result = stmt.executeQuery();

		List<Profissional> lista = new ArrayList<Profissional>();

		while(result.next()) {			
			Profissional profissional = parse(result);
			lista.add(profissional);
		}
		return lista;
	}
	
	/**
	 * Recupera as informacoes de um registro do banco e retorna o profissional
	 * @param result ResultSet o(s) registro(s) encontrados
	 * @return Profissional profissional com os valores do banco de dados
	 * @throws SQLException
	 */
	private Profissional parse(ResultSet result) throws SQLException {
		int id = result.getInt("ID_PROFISSIONAL");
		String nome = result.getString("NM_PROFISSIONAL");
		String dataNascimento = result.getString("DT_NASCIMENTO");
		String dataCadastro = result.getString("DT_CADASTRO");
		String email = result.getString("DS_EMAIL");
		String senha = result.getString("DS_SENHA");
		
		Profissional profissional = new Profissional(id, nome, email, senha, dataCadastro, dataNascimento);
		return profissional;			
	}
	
	/**
	 * Remove um profissional no banco de dados
	 * @param codigo PK do profissional
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM ENDORF_PROFI WHERE ID_PROFISSIONAL = ?");

		stmt.setInt(1, codigo);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Profissional não encontrado para ser removido");
		}
	}

}
