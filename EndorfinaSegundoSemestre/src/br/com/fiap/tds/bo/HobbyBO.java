package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;

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

	public void cadastrar(Hobby hobby) throws SQLException, DadosInvalidosException{
		if(hobby.getNomeHobby()==null || hobby.getNomeHobby().length()>40) {
			throw new DadosInvalidosException("Nome é obrigatorio e deve conter menos de 40 caracteres");
		}
		hobby.setNomeHobby(hobby.getNomeHobby().toUpperCase());
		dao.cadastrarHobby(hobby);
	}
	
	public void atualizar(Hobby hobby) throws SQLException, IdNotFoundException{
		dao.atualizar(hobby);
	}
	
	public Hobby pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return dao.pesquisar(codigo);
	}
	
	
}
