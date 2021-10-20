package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.bean.Hobby;
import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.dao.HobbyDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que contem as regras de negocios e validacoes do hobby
 * @author Endorfina
 *
 */
public class HobbyBO {
	
	private HobbyDAO dao;
	
	/**
	 * Construtor que recebe a conexao
	 * @param conexao
	 */
	public HobbyBO(Connection conexao) {
		dao = new HobbyDAO(conexao);
	}

	/**
	 * Regras de negocio para cadastramento de um hobby
	 * @param hobby Hobby que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void cadastrar(Hobby hobby) throws SQLException, DadosInvalidosException{
		validar(hobby);
		dao.cadastrarHobby(hobby);
	}
	
	/**
	 * Regras de negocio para buscar informacoes pelo nome de um hobby
	 * @param nome Nome do hobby
	 * @return retorna lista com as informacoes
	 * @throws SQLException
	 */
	public List<Hobby> buscarPorNome(String nome) throws SQLException{
		return dao.buscarPorNome(nome);
	}
	
	/**
	 * Regras de negocio para atualizar um hobby
	 * @param hobby Hobby com valores a serem atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws DadosInvalidosException
	 */
	public void atualizar(Hobby hobby) throws SQLException, IdNotFoundException{
		dao.atualizar(hobby);
	}
	
	/**
	 * Regras de negocio para pesquisar um hobby pela sua PK
	 * @param codigo PK do hobby
	 * @return informacoes do hobby
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Hobby pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return dao.pesquisar(codigo);
	}
	
	/**
	 * Regras de negocio para listar os hobbies cadastrados
	 * @return Lista hobbies
	 * @throws SQLException
	 */
	public List<Hobby> listar() throws SQLException{
		return dao.listar();
	}
	
	/**
	 * Remove um hobby
	 * @param codigo PK do hobby
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		dao.remover(codigo);
	}
	
	/**
	 * Validacao das regras de negocio
	 * @param hobby Hobby para ser cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void validar(Hobby hobby) throws SQLException, DadosInvalidosException{
		if(hobby.getNomeHobby()==null || hobby.getNomeHobby().length()>40) {
			throw new DadosInvalidosException("Nome é obrigatorio e deve conter menos de 40 caracteres");
		}
	}
}
