package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.tds.bean.HobbyProfissional;
import br.com.fiap.tds.bean.HobbyUsuario;
import br.com.fiap.tds.bean.Profissional;
import br.com.fiap.tds.dao.HobbyProfissionalDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que contem as regras de negocios e validacoes do hobbyProfissional
 * @author Enforfina
 *
 */
public class HobbyProfissionalBO {

	private HobbyProfissionalDAO hobbyProfissionalDAO;
	private ProfissionalBO profissionalBO;
	private HobbyBO hobbyBO;
	private Connection conexao;

	/**
	 * Construtor que recebe a conexao 
	 * @param conexao conexao com o banco de dados
	 */
	public HobbyProfissionalBO(Connection conexao) {
		this.conexao = conexao;
		this.hobbyProfissionalDAO = new HobbyProfissionalDAO(conexao);
		this.profissionalBO = new ProfissionalBO(conexao);
		this.hobbyBO = new HobbyBO(conexao);

	}
	
	/**
	 * Regras de negocio para cadastramento do hobbyProfissional
	 * @param hobbyProfissional HobbyProfissional que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void cadastrar(HobbyProfissional hobbyProfissional) throws SQLException, DadosInvalidosException{
		conexao.setAutoCommit(false);
		profissionalBO.cadastrar(hobbyProfissional.getProfissional());
		hobbyBO.cadastrar(hobbyProfissional.getHobby());
		hobbyProfissionalDAO.cadastrar(hobbyProfissional);
		
		try {
			conexao.commit();
		}catch(Exception e) {
			conexao.rollback();
		
		}
	}
	
	/**
	 * Remove um hobbyProfissional
	 * @param codigo PK do profissional
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		hobbyProfissionalDAO.remover(codigo);
	}
}
