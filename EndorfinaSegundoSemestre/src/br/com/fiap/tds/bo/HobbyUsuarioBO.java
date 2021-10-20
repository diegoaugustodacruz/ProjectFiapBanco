package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.tds.bean.HobbyUsuario;
import br.com.fiap.tds.dao.HobbyUsuarioDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que contem as regras de negocios e validacoes do hobbyUsuario
 * @author Enforfina
 *
 */
public class HobbyUsuarioBO {
	
	private HobbyUsuarioDAO hobbyUsuarioDAO;
	private UsuarioBO usuarioBO;
	private HobbyBO hobbyBO;
	private Connection conexao;
	
	/**
	 * Construtor que recebe a conexao 
	 * @param conexao conexao com o banco de dados
	 */
	public HobbyUsuarioBO(Connection conexao) {
		this.conexao = conexao;
		this.hobbyUsuarioDAO = new HobbyUsuarioDAO(conexao);
		this.usuarioBO = new UsuarioBO(conexao);
		this.hobbyBO = new HobbyBO(conexao);
	}
	
	/**
	 * Regras de negocio para cadastramento do hobbyUsuario
	 * @param hobbyUsuario HobbyUsuario que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
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
	
	/**
	 * Remove um hobbyUsuario
	 * @param codigo PK do usuario
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		hobbyUsuarioDAO.remover(codigo);
	}
}
