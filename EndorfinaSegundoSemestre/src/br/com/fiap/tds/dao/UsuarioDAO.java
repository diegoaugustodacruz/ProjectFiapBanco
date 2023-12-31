package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que realiza operacoes basicas com o usuario no banco
 * @author Endorfina
 *
 */
public class UsuarioDAO {
	
	private Connection conexao;

	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public UsuarioDAO(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	/**
	 * Pesquisa os usuarios por parte do nome
	 * @param nome Termo de pesquisa
	 * @return List<Usuario> Lista dos usuarios encontrados
	 * @throws SQLException
	 */
	public List<Usuario> buscarPorNome(String nome) throws SQLException{
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_USUARIO WHERE NM_USUARIO LIKE ?");

		stmt.setString(1,"%" + nome + "%");		
		
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);	
		
		
	}
	
	/**
	 * Recebe o resultado de uma pesquisa e retora uma lista
	 * @param result Resultado de uma pesquisa
	 * @return List<Usuario> lista de usuarios
	 * @throws SQLException
	 */
	private List<Usuario> parseList(ResultSet result) throws SQLException{
		List<Usuario> lista = new ArrayList<Usuario>();
		
		while(result.next()) {			
			Usuario usuario = parse(result);
			lista.add(usuario);
		}
		return lista;
		
	}
	
	

	/**
	 * Cadastra um usuario no banco de dados
	 * @param usuario Usuario com valores que serao cadastrados
	 * @throws SQLException
	 */
	public void cadastrar(Usuario usuario) throws SQLException {

		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_USUARIO "
				+ "(ID_USUARIO, NM_USUARIO, DT_NASCIMENTO, DT_CADASTRO, DS_EMAIL, DS_SENHA)"
				+ " VALUES (SQ_ENDORF_USUARIO.NEXTVAL, ?, TO_DATE(?,'DD/MM/YYYY'), SYSDATE, ?, ?)", new String[] {"ID_USUARIO"});
		
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getDataNascimento());
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getSenha());

		
		stmt.executeUpdate();
		
		ResultSet result = stmt.getGeneratedKeys();
		if(result.next()) {
			int codigo = result.getInt(1);
			usuario.setIdUsuario(codigo);
		}
	}
	
	/**
	 * Atualiza usuario no banco de dados
	 * @param usuario Usuario com valores que serao atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void atualizar(Usuario usuario) throws SQLException, IdNotFoundException{
		pesquisar(usuario.getIdUsuario());
		
		PreparedStatement stmt = conexao.prepareStatement("UPDATE ENDORF_USUARIO SET NM_USUARIO = ?, DT_NASCIMENTO = ?,"
				+ " DS_EMAIL = ?, DS_SENHA = ? WHERE ID_USUARIO = ?");
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getDataNascimento());
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getSenha());
		stmt.setInt(5, usuario.getIdUsuario());

		int qtd = stmt.executeUpdate();		

		if(qtd == 0) {
			throw new IdNotFoundException("Usuario não encontrado");
		}

		
	}
	
	/**
	 * Pesquisa um usuario no banco de dados pela PK
	 * @param codigo PK do usuario
	 * @return Usuario usuario com valores encontrados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Usuario pesquisar(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_USUARIO WHERE ID_USUARIO = ?");
		
		stmt.setInt(1, codigo);		

		ResultSet result = stmt.executeQuery();

		if(!result.next()) {
			throw new IdNotFoundException("Usuario não encontrado");
			
		}
		
		Usuario usuario = parse(result);
		
		return usuario;
	}
	
	/**
	 * Retorna todos os usuarios do banco de dados
	 * @return List<Usuario> Lista de usuarios
	 * @throws SQLException
	 */
	public List<Usuario> listar() throws SQLException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_USUARIO");
		
		ResultSet result = stmt.executeQuery();

		List<Usuario> lista = new ArrayList<Usuario>();

		while(result.next()) {			
			Usuario usuario = parse(result);
			lista.add(usuario);
		}
		return lista;
	}

	/**
	 * Recupera as informacoes de um registro do banco e retorna o usuario
	 * @param result ResultSet o(s) registro(s) encontrados
	 * @return Usuario usuario com os valores do banco de dados
	 * @throws SQLException
	 */
	private Usuario parse(ResultSet result) throws SQLException {

		int id = result.getInt("ID_USUARIO");
		String nome = result.getString("NM_USUARIO");
		String dataNascimento = result.getString("DT_NASCIMENTO");
		String dataCadastro = result.getString("DT_CADASTRO");
		String email = result.getString("DS_EMAIL");
		String senha = result.getString("DS_SENHA");
		
		Usuario usuario = new Usuario(id, nome, email, senha, dataCadastro, dataNascimento);
		
		return usuario;			
	}
	
	/**
	 * Remove um usuario no banco de dados
	 * @param codigo PK do usuario
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM ENDORF_USUARIO WHERE ID_USUARIO = ?");

		stmt.setInt(1, codigo);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Usuario não encontrado para ser removido");
		}
	}
}
