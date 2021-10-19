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
		validar(telefone);
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
		validar(telefone);
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
		validar(telefone);
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
	
	private void validar(Telefone telefone) throws SQLException, DadosInvalidosException{
		String numeroTelefone = Integer.toString(telefone.getNumeroTel());
		String numeroDDD = Integer.toString(telefone.getDdd());
		String numeroDDI = Integer.toString(telefone.getDdi());

		if(numeroTelefone == null || numeroTelefone.length()>9) {
			throw new DadosInvalidosException("Numero telefone é obrigatorio e deve conter 9 algarismos");
		}
		
		if(numeroDDD == null || numeroDDD.length()>3) {
			throw new DadosInvalidosException("Numero ddd é obrigatorio e deve conter 3 algarismos");
		}
		
		if(numeroDDI == null || numeroDDI.length()>3) {
			throw new DadosInvalidosException("Numero ddi é obrigatorio e deve conter 3 algarismos");
		}
	}
	
	
	
}
