package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.dao.UsuarioDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;

public class UsuarioBO {
	
	private UsuarioDAO dao;
	
	public UsuarioBO(Connection conexao) {
		dao = new UsuarioDAO(conexao);
	}

	public void cadastrar(Usuario usuario) throws SQLException, DadosInvalidosException{
		if(usuario.getNome()==null || usuario.getNome().length()>80) {
			throw new DadosInvalidosException("Nome é obrigatorio e deve conter menos de 80 caracteres");
		}
		
		if(usuario.getDataNascimento()==null) {
			throw new DadosInvalidosException("Data de Nascimento válida é obrigatoria");
		}
		
		if(usuario.getEmail()==null) {
			throw new DadosInvalidosException("Email é obrigatorio");
		}		
		if(usuario.getSenha()==null) {
			throw new DadosInvalidosException("Senha é obrigatorio");
		}
		
		dao.cadastrar(usuario);
	}
}
