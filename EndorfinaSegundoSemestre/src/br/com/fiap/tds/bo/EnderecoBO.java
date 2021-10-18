package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.bean.Endereco;
import br.com.fiap.tds.bean.Profissional;
import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.dao.EnderecoDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;

public class EnderecoBO {
	
	private EnderecoDAO enderecoDAO;
	private UsuarioBO usuarioBO;
	private ProfissionalBO profissionalBO;
	private Connection conexao;
	

	public EnderecoBO(Connection conexao) {
		this.conexao = conexao;
		this.enderecoDAO = new EnderecoDAO(conexao);
		this.profissionalBO = new ProfissionalBO(conexao);
		this.usuarioBO = new UsuarioBO(conexao);
		
	}
	
	
	
	public void cadastrarUsuario(Endereco endereco) throws SQLException, DadosInvalidosException{
		validar(endereco);
		conexao.setAutoCommit(false);
		usuarioBO.cadastrar(endereco.getUsuario());
		enderecoDAO.cadastrarUsuario(endereco);
		
		try {
			conexao.commit();
		}catch(Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar commit");
		}
	}
	
	public void cadastrarProfissional(Endereco endereco) throws SQLException, DadosInvalidosException{
		validar(endereco);
		conexao.setAutoCommit(false);
		profissionalBO.cadastrar(endereco.getProfissional());
		enderecoDAO.cadastrarProfissional(endereco);
		
		try {
			conexao.commit();
		}catch(Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar commit");
		}		
		
	}
	
	public List<Endereco> buscarPorNome(String nome) throws SQLException{
		return enderecoDAO.buscarPorNome(nome);
	}
	
	public void atualizar(Endereco endereco) throws SQLException, IdNotFoundException, DadosInvalidosException{
		validar(endereco);
		enderecoDAO.atualizar(endereco);
	}
	
	public Endereco pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return enderecoDAO.pesquisar(codigo);
	}
	
	public List<Endereco> listar() throws SQLException{
		return enderecoDAO.listar();
	}
	
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		enderecoDAO.remover(codigo);
	}
	
	public void validar(Endereco endereco) throws SQLException, DadosInvalidosException{
		if(endereco.getCidade()==null || endereco.getCidade().length()>40) {
			throw new DadosInvalidosException("Nome cidade é obrigatoria e deve conter menos de 40 caracteres");
		}
		
		if(endereco.getEstado()==null || endereco.getEstado().length()>40) {
			throw new DadosInvalidosException("Nome estado é obrigatoria e deve conter menos de 40 caracteres");
		}
		
		if(endereco.getNomeRua().length()>80) {
			throw new DadosInvalidosException("Nome rua deve conter menos de 80 caracteres");
		}
		
		if(endereco.getBairro().length()>40) {
			throw new DadosInvalidosException("Nome bairro deve conter menos de 40 caracteres");
		}
	}
	
}