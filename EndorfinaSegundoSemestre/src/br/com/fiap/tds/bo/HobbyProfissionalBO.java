package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.tds.bean.HobbyProfissional;
import br.com.fiap.tds.bean.HobbyUsuario;
import br.com.fiap.tds.bean.Profissional;
import br.com.fiap.tds.dao.HobbyProfissionalDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;

public class HobbyProfissionalBO {

	private HobbyProfissionalDAO hobbyProfissionalDAO;
	private ProfissionalBO profissionalBO;
	private HobbyBO hobbyBO;
	private Connection conexao;

	public HobbyProfissionalBO(Connection conexao) {
		this.conexao = conexao;
		this.hobbyProfissionalDAO = new HobbyProfissionalDAO(conexao);
		this.profissionalBO = new ProfissionalBO(conexao);
		this.hobbyBO = new HobbyBO(conexao);

	}
	
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
}
