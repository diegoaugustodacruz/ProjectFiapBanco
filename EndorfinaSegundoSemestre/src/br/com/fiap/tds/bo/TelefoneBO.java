package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.bean.Endereco;
import br.com.fiap.tds.bean.Telefone;
import br.com.fiap.tds.dao.EnderecoDAO;
import br.com.fiap.tds.dao.TelefoneDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;

public class TelefoneBO {
	
	private TelefoneDAO telefoneDAO;
	private UsuarioBO usuarioBO;
	private ProfissionalBO profissionalBO;
	private Connection conexao;
	
	public TelefoneBO(Connection conexao) {
		this.conexao = conexao;
		this.telefoneDAO = new TelefoneDAO(conexao);
		this.profissionalBO = new ProfissionalBO(conexao);
		this.usuarioBO = new UsuarioBO(conexao);
		
	}
	
	public void cadastrarUsuario(Telefone telefone) throws SQLException, DadosInvalidosException{
		conexao.setAutoCommit(false);
		usuarioBO.cadastrar(telefone.getUsuario());
		telefoneDAO.cadastrarUsuario(telefone);
		
		try {
			conexao.commit();
		}catch(Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar commit");
		}
	}
	
	public void cadastrarProfissional(Telefone telefone) throws SQLException, DadosInvalidosException{
		conexao.setAutoCommit(false);
		profissionalBO.cadastrar(telefone.getProfissional());
		telefoneDAO.cadastrarProfissional(telefone);
		
		try {
			conexao.commit();
		}catch(Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar commit");
		}		
		
	}
	
	public List<Telefone> buscarPorNumero(int numero) throws SQLException{
		return telefoneDAO.buscarPorNumero(numero);
	}
	
	public void atualizar(Telefone telefone) throws SQLException, IdNotFoundException, DadosInvalidosException{
		telefoneDAO.atualizar(telefone);
	}

	public Telefone pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return telefoneDAO.pesquisar(codigo);
	}
	
	public List<Telefone> listar() throws SQLException{
		return telefoneDAO.listar();
	}
	
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		telefoneDAO.remover(codigo);
	}
	
	
	
}
