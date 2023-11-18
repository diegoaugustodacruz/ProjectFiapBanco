package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.exception.IdNotFoundException;

public class UsuarioDao {
	
private Connection conexao;
	
	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public UsuarioDao(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	public List<Usuario> buscarPorNome(String nome) throws SQLException{
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_USUARIO WHERE NM_NOME LIKE ?");
		
		stmt.setString(1,"%" + nome + "%");		


		ResultSet result = stmt.executeQuery();
		
		return parseList(result);	
	}
	
	private List<Usuario> parseList(ResultSet result) throws SQLException{
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		//Ler os registros encontrados
		while(result.next()) {			
			Usuario usuario = parse(result);
			//Adicionar na lista
			lista.add(usuario);
			//Retornar a lista
		}
		return lista;		
		
	}
	
	private Usuario parse(ResultSet result) throws SQLException {
		//Recuperar os dados do produto
		int id = result.getInt("id_usuario");
		String nome = result.getString("npm_nome");
		String cpf = result.getString("nr_cpf");
		String email = result.getString("ds_email");
		String senha = result.getString("ds_senha");
		
		//Instanciar o produto
		Usuario usuario = new Usuario(id, nome, cpf, email, senha);
		return usuario;
	}
	
	public void cadastrar(Usuario usuario) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_USUARIO "
				+ "(id_usuario, nm_nome, nr_cpf, ds_email, ds_senha) "
				+ "VALUES (SQ_T_USUARIO.NEXTVAL, ?, ?, ?, ?)");
		
		//passar os valores para o comando SQL
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getCpf());
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getSenha());
		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
	public void atualizar(Usuario usuario) throws SQLException, IdNotFoundException{
		
		//Verificar se o produto existe para ser pesquisado
		pesquisar(usuario.getId());
		
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("UPDATE T_USUARIO SET nm_nome = ?, nr_cpf = ?,"
				+ " ds_email = ?, ds_senha = ? WHERE id_usuario = ?");
		
		//passar os valores para o comando SQL
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getCpf());
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getSenha());		
		
		//Executar o comando SQL
		int qtd = stmt.executeUpdate();		
		
		//Verifica se atualizou o produto no banco
		if(qtd == 0) {
			throw new IdNotFoundException("Produto não encontrado");
		}
		
	}
	
	public Usuario pesquisar(int codigo) throws SQLException, IdNotFoundException {
		
		//Criar o comand SQL
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_USUARIO WHERE ID_USUARIO = ?");

		//Passar o código para a query
		stmt.setInt(1, codigo);		
		
		//Executar
		ResultSet result = stmt.executeQuery();
		
		//Posiciona o cursor no primeiro registro e verifica se encontrou um produto
		if(!result.next()) {
			throw new IdNotFoundException("Usuario não encontrado");
			
		}		
		
		
		//Instanciar o produto
		Usuario usuario = parse(result);
		
		//Retornar o produto
		return usuario;
	}
	
	public List<Usuario> listar() throws SQLException{
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_USUARIO");
		
		//Executa o comando
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);
		
	}
	
	public void remover(int codigo) throws SQLException, IdNotFoundException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_USUARIO WHERE ID_USUARIO = ?");
		
		//Setar o parâmetro na query
		stmt.setInt(1, codigo);	
		
		//Executar a query
		int qtd = stmt.executeUpdate();
		
		//Verificar se o produto foi removido
		if(qtd == 0) {
			throw new IdNotFoundException("Usuario não encontrado para ser removido");
		}
	}		
	


}
