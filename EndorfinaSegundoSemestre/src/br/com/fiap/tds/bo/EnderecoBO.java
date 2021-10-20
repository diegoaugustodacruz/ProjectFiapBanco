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

/**
 * Classe que contem as regras de negocios e validacoes do endereco
 * @author Endorfina
 *
 */
public class EnderecoBO {
	
	private EnderecoDAO enderecoDAO;
	private UsuarioBO usuarioBO;
	private ProfissionalBO profissionalBO;
	private Connection conexao;	

	/**
	 * Construtor que recebe a conexao
	 * @param conexao
	 */
	public EnderecoBO(Connection conexao) {
		this.conexao = conexao;
		this.enderecoDAO = new EnderecoDAO(conexao);
		this.profissionalBO = new ProfissionalBO(conexao);
		this.usuarioBO = new UsuarioBO(conexao);
		
	}	
	
	/**
	 * Regras de negocio para cadastramento do endereco de um usuario
	 * @param endereco Endereco que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
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
	
	/**
	 * Regras de negocio para cadastramento do endereco de um profissional
	 * @param endereco Endereco que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
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
	
	/**
	 * Regras de negocio para buscar informacoes pelo nome da rua de um endereco
	 * @param nome Nome de rua
	 * @return retorna lista com as informacoes
	 * @throws SQLException
	 */
	public List<Endereco> buscarPorNome(String nome) throws SQLException{
		return enderecoDAO.buscarPorNome(nome);
	}
	
	/**
	 * Regras de negocio para atualizar um endereco
	 * @param endereco Endereco com valores a serem atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws DadosInvalidosException
	 */
	public void atualizar(Endereco endereco) throws SQLException, IdNotFoundException, DadosInvalidosException{
		validar(endereco);
		enderecoDAO.atualizar(endereco);
	}
	
	/**
	 * Regras de negocio para pesquisar um endereco pela sua PK
	 * @param codigo PK do endereco
	 * @return informacoes do endereco
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Endereco pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return enderecoDAO.pesquisar(codigo);
	}
	
	/**
	 * Regras de negocio para listar os enderecos cadastrados
	 * @return Lista enderecos
	 * @throws SQLException
	 */
	public List<Endereco> listar() throws SQLException{
		return enderecoDAO.listar();
	}
	
	/**
	 * Remove um endereco
	 * @param codigo PK do endereco
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		enderecoDAO.remover(codigo);
	}
	
	/**
	 * Validacao das regras de negocio
	 * @param endereco Endereco para ser cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void validar(Endereco endereco) throws SQLException, DadosInvalidosException{
		String cep = Integer.toString(endereco.getNumeroCEP());

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
		
		if(cep.length()>7) {
			throw new DadosInvalidosException("CEP deve conter menos de 8 caracteres");

		}
	}
	
}