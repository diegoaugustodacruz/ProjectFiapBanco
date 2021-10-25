package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.bean.Departamento;
import br.com.fiap.tds.dao.DepartamentoDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que contem as regras de negocios e validacoes do departamento
 * @author Grupo
 *
 */
public class DepartamentoBO {

	private DepartamentoDAO dao;
	private Connection conexao;	
	
	
	/**
	 * Construtor que recebe a conexao 
	 * @param conexao conexao com o banco de dados
	 */
	public DepartamentoBO(Connection conexao) {
		dao = new DepartamentoDAO(conexao);
	}
	
	/**
	 * Regras de negocio para cadastramento do departamento
	 * @param deapartamento Departamento que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void cadastrar(Departamento departamento) throws SQLException, DadosInvalidosException{
		validar(departamento);		
		
		dao.cadastrar(departamento);
	}
	
	/**
	 * Regras de negocio para buscar informacoes pelo nome de um departamento
	 * @param nome Nome do departamento
	 * @return retorna lista com as informacoes
	 * @throws SQLException
	 */
	public List<Departamento> buscarPorNome(String nome) throws SQLException{
		return dao.buscarPorNome(nome);
	}
	
	/**
	 * Regras de negocio para atualizar um departamento
	 * @param departamento Departamento com valores a serem atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws DadosInvalidosException
	 */
	public void atualizar(Departamento departamento) throws SQLException, IdNotFoundException, DadosInvalidosException{
		validar(departamento);

		dao.atualizar(departamento);
	}
	
	/**
	 * Regras de negocio para pesquisar um departamento pela sua PK
	 * @param codigo PK do departamento
	 * @return informacoes do departamento
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Departamento pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return dao.pesquisar(codigo);
	}
	
	/**
	 * Regras de negocio para listar os departamentos cadastrados
	 * @return Lista departamentos
	 * @throws SQLException
	 */
	public List<Departamento> listar() throws SQLException{
		return dao.listar();
	}
	
	/**
	 * Remove um departamento
	 * @param codigo PK do departamento
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		dao.remover(codigo);	
		
	}
	
	/**
	 * Validacao das regras de negocio
	 * @param usuario Usuario para ser cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void validar(Departamento departamento)  throws SQLException, DadosInvalidosException{
	
		
		if(departamento.getNome()==null || departamento.getNome().length()>20) {
			throw new DadosInvalidosException("Nome é obrigatorio e deve conter menos de 20 caracteres");
		}
		
		if(departamento.getSigla()==null || departamento.getSigla().length()>20) {
			throw new DadosInvalidosException("Sigla é obrigatoria e deve conter menos de 20 caracteres");
		}
		
		
	}
}
