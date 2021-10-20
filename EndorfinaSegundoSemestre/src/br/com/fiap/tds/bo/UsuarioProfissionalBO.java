package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.bean.UsuarioProfissional;
import br.com.fiap.tds.dao.UsuarioProfissionalDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que contem as regras de negocios e validacoes do usuarioProfissional
 * @author Enforfina
 *
 */
public class UsuarioProfissionalBO {
	
	private UsuarioProfissionalDAO usuarioProfissionalDAO;
	private UsuarioBO usuarioBO;
	private ProfissionalBO profissionalBO;
	private Connection conexao;

	/**
	 * Construtor que recebe a conexao 
	 * @param conexao conexao com o banco de dados
	 */
	public UsuarioProfissionalBO(Connection conexao) {
		this.conexao = conexao;
		this.usuarioProfissionalDAO = new UsuarioProfissionalDAO(conexao);
		this.profissionalBO = new ProfissionalBO(conexao);
		this.usuarioBO = new UsuarioBO(conexao);
		
	}
	
	/**
	 * Regras de negocio para cadastramento do usuarioProfissional
	 * @param usuarioProfissional UsuarioProfissional que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void cadastrar(UsuarioProfissional usuarioProfissional) throws SQLException, DadosInvalidosException{
		conexao.setAutoCommit(false);
		usuarioBO.cadastrar(usuarioProfissional.getUsuario());
		profissionalBO.cadastrar(usuarioProfissional.getProfissional());		
		usuarioProfissionalDAO.cadastrar(usuarioProfissional);
		
		try {
			conexao.commit();
		}catch(Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar commit");
		}
	}
	
	
	/**
	 * Remove um usuarioProfissional
	 * @param codigo PK do usuario
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		usuarioProfissionalDAO.remover(codigo);
	}
	
	
}
