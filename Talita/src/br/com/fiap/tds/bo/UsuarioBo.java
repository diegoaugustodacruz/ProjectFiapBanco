package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.dao.UsuarioDao;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;

public class UsuarioBo {
	
	private UsuarioDao dao;
	
	public UsuarioBo(Connection conexao) {
		
		dao = new UsuarioDao(conexao);
	}
	

	public void cadastrar(Usuario usuario) throws SQLException, DadosInvalidosException {
		validar(usuario);
		dao.cadastrar(usuario);
	}
	
	private void validar(Usuario usuario) throws DadosInvalidosException {
		
		if(usuario.getNome()==null || usuario.getNome().length()>60)  {
			throw new DadosInvalidosException("Nome é obrigatorio e deve conter menos de 60 caracteres");
		}
		if(usuario.getCpf()==null || usuario.getCpf().length()>11)  {
			throw new DadosInvalidosException("O cpf nao pode ser menor ou igual a zero");
		}
		
	}
	
	public List<Usuario> buscarPorNome(String nome) throws SQLException{
		return dao.buscarPorNome(nome);
	}
	
	
	public void atualizar(Usuario usuario) throws SQLException, IdNotFoundException, DadosInvalidosException{
		validar(usuario);		
		dao.atualizar(usuario);
	}
	
	public Usuario pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return dao.pesquisar(codigo);
	}
	
	public List<Usuario> listar() throws SQLException{
		return dao.listar();
	}
	
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		dao.remover(codigo);
	}

}
