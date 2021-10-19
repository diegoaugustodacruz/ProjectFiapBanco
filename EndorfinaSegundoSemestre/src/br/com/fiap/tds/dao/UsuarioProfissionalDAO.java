package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.bean.UsuarioProfissional;
import br.com.fiap.tds.exception.IdNotFoundException;

public class UsuarioProfissionalDAO {

	private Connection conexao;

	public UsuarioProfissionalDAO(Connection conexao) {
		this.conexao = conexao;
		
	}

	public void cadastrar(UsuarioProfissional usuarioProfissional) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_USUARIO_PROFI "
				+ "(ID_USUARIO, ID_PROFISSIONAL)"
				+ " VALUES (?, ?)");
		
		//passar os valores para o comando SQL
		stmt.setInt(1, usuarioProfissional.getProfissional().getIdProfissional());
		stmt.setInt(2, usuarioProfissional.getUsuario().getIdUsuario());
		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
	public UsuarioProfissional pesquisar(int codigoUsuario, int codigoProfissional) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_USUARIO WHERE ID_USUARIO = ? AND ID_PROFISSIONAL = ?");
		
		stmt.setInt(1, codigoUsuario);	
		stmt.setInt(2, codigoProfissional);		


		ResultSet result = stmt.executeQuery();

		if(!result.next()) {
			throw new IdNotFoundException("Usuario/Profissional não encontrado");
			
		}
		
		UsuarioProfissional usuarioProfissional = parse(result);
		
		return usuarioProfissional;
	}
	
	public List<UsuarioProfissional> listar() throws SQLException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_USUARIO_PROFI");
		
		ResultSet result = stmt.executeQuery();

		List<UsuarioProfissional> lista = new ArrayList<UsuarioProfissional>();

		while(result.next()) {			
			UsuarioProfissional usuarioProfissional = parse(result);
			lista.add(usuarioProfissional);
		}
		return lista;
	}
	
	private UsuarioProfissional parse(ResultSet result) throws SQLException {

		int idUsuario = result.getInt("ID_USUARIO");
		int idProfissional = result.getInt("ID_PROFISSIONAL");		
		
		UsuarioProfissional usuarioProfissional = null;
		usuarioProfissional.getUsuario().setIdUsuario(idUsuario);
		usuarioProfissional.getProfissional().setIdProfissional(idProfissional);
		
		return usuarioProfissional;			
	}
	
	public void remover(int codigoUsuario) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM ENDORF_USUARIO_PROFI WHERE ID_USUARIO = ?");

		stmt.setInt(1, codigoUsuario);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Usuario/Profissional não encontrado para ser removido");
		}
	}
	
}
