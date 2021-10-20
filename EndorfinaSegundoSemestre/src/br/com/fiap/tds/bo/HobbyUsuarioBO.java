package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.tds.bean.HobbyUsuario;
import br.com.fiap.tds.dao.HobbyUsuarioDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;

public class HobbyUsuarioBO {
	
	private HobbyUsuarioDAO hobbyUsuarioDAO;
	private UsuarioBO usuarioBO;
	private HobbyBO hobbyBO;
	private Connection conexao;
	
	public HobbyUsuarioBO(Connection conexao) {
		this.conexao = conexao;
		this.hobbyUsuarioDAO = new HobbyUsuarioDAO(conexao);
		this.usuarioBO = new UsuarioBO(conexao);
		this.hobbyBO = new HobbyBO(conexao);
	}
	
	public void cadastrar(HobbyUsuario hobbyUsuario) throws SQLException, DadosInvalidosException{
		conexao.setAutoCommit(false);
		usuarioBO.cadastrar(hobbyUsuario.getUsuario());
		hobbyBO.cadastrar(hobbyUsuario.getHobby());
		hobbyUsuarioDAO.cadastrar(hobbyUsuario);
		
		
		try {
			conexao.commit();
		}catch(Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar commit");
		}
	}

}
