package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.bean.Endereco;
import br.com.fiap.tds.bean.Profissional;
import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que realiza operacoes basicas com o endereco no banco
 * @author Endorfina
 *
 */
public class EnderecoDAO {

	private Connection conexao;

	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public EnderecoDAO(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	/**
	 * Pesquisa os enderecos por parte do nome da rua
	 * @param nome Termo de pesquisa
	 * @return List<Endereco> Lista dos enderecos encontrados
	 * @throws SQLException
	 */
	public List<Endereco> buscarPorNome(String nome) throws SQLException{
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_END WHERE NM_RUA LIKE ?");

		stmt.setString(1,"%" + nome + "%");		
		
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);
	}
	
	/**
	 * Recebe o resultado de uma pesquisa e retora uma lista
	 * @param result Resultado de uma pesquisa
	 * @return List<Endereco> lista de enderecos
	 * @throws SQLException
	 */
	private List<Endereco> parseList(ResultSet result) throws SQLException{
		List<Endereco> lista = new ArrayList<Endereco>();
		
		while(result.next()) {			
			Endereco endereco = parse(result);
			lista.add(endereco);
		}
		return lista;
		
	}
	
	/**
	 * Cadastra um endereco de um usuario no banco de dados
	 * @param endereco Endereco com valores que serao cadastrados
	 * @throws SQLException
	 */
	public void cadastrarUsuario(Endereco endereco) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_END "
				+ "(ID_END, NM_RUA, NR_NUMERO, NR_CEP, NM_BAIRRO, NM_CIDADE, NM_ESTADO, ID_USUARIO)"
				+ " VALUES (SQ_ENDORF_END.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");
		
		stmt.setString(1, endereco.getNomeRua());
		stmt.setInt(2, endereco.getNumeroCasa());
		stmt.setInt(3, endereco.getNumeroCEP());
		stmt.setString(4, endereco.getBairro());
		stmt.setString(5, endereco.getCidade());
		stmt.setString(6, endereco.getEstado());
		stmt.setInt(7, endereco.getUsuario().getIdUsuario());
		
		stmt.executeUpdate();
		
		
	}
	
	/**
	 * Cadastra um endereco de um profissional no banco de dados
	 * @param endereco Endereco com valores que serao cadastrados
	 * @throws SQLException
	 */
	public void cadastrarProfissional(Endereco endereco) throws SQLException {

		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_END "
				+ "(ID_END, NM_RUA, NR_NUMERO, NR_CEP, NM_BAIRRO, NM_CIDADE, NM_ESTADO, ID_PROFISSIONAL)"
				+ " VALUES (SQ_ENDORF_END.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");
		
		stmt.setString(1, endereco.getNomeRua());
		stmt.setInt(2, endereco.getNumeroCasa());
		stmt.setInt(3, endereco.getNumeroCEP());
		stmt.setString(4, endereco.getBairro());
		stmt.setString(5, endereco.getCidade());
		stmt.setString(6, endereco.getEstado());
		stmt.setInt(7, endereco.getProfissional().getIdProfissional());
		
		stmt.executeUpdate();
	}
	
	/**
	 * Atualiza endereco no banco de dados
	 * @param endereco Endereco com valores que serao atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void atualizar(Endereco endereco) throws SQLException, IdNotFoundException{
		pesquisar(endereco.getIdEndereco());
		
		PreparedStatement stmt = conexao.prepareStatement("UPDATE ENDORF_END SET NM_RUA = ?, NR_NUMERO = ?,"
				+ " NR_CEP = ?, NM_BAIRRO = ?, NM_CIDADE = ?, NM_ESTADO = ? WHERE ID_END = ?");
		stmt.setString(1, endereco.getNomeRua());
		stmt.setInt(2, endereco.getNumeroCasa());
		stmt.setInt(3, endereco.getNumeroCEP());
		stmt.setString(4, endereco.getBairro());
		stmt.setString(5, endereco.getCidade());
		stmt.setString(6, endereco.getEstado());
		stmt.setInt(7, endereco.getIdEndereco());		

		int qtd = stmt.executeUpdate();		

		if(qtd == 0) {
			throw new IdNotFoundException("Endereco não encontrado");
		}
		
	}
	
	/**
	 * Pesquisa um endereco no banco de dados pela PK
	 * @param codigo PK do endereco
	 * @return Endereco endereco com valores encontrados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Endereco pesquisar(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_END WHERE ID_END = ?");
		
		stmt.setInt(1, codigo);		

		ResultSet result = stmt.executeQuery();

		if(!result.next()) {
			throw new IdNotFoundException("Usuario não encontrado");
			
		}
		
		Endereco endereco = parse(result);
		
		return endereco;
	}
	
	/**
	 * Retorna todos os enderecos do banco de dados
	 * @return List<Enderecos> Lista de enderecos
	 * @throws SQLException
	 */
	public List<Endereco> listar() throws SQLException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_END");
		
		ResultSet result = stmt.executeQuery();

		List<Endereco> lista = new ArrayList<Endereco>();

		while(result.next()) {			
			Endereco endereco = parse(result);
			lista.add(endereco);
		}
		return lista;
	}
	
	/**
	 * Recupera as informacoes de um registro do banco e retorna o endereco
	 * @param result ResultSet o(s) registro(s) encontrados
	 * @return Endereco endereco com os valores do banco de dados
	 * @throws SQLException
	 */
	private Endereco parse(ResultSet result) throws SQLException {

		int id = result.getInt("ID_END");
		int numeroCasa = result.getInt("NR_RUA");
		int numeroCEP = result.getInt("NR_CEP");
		String nomeRua = result.getString("NM_RUA");
		String nomeBairro = result.getString("NM_BAIRRO");
		String nomeCidade = result.getString("NM_CIDADE");
		String nomeEstado = result.getString("NM_ESTADO");

		Endereco endereco = new Endereco(id, numeroCasa, numeroCEP, nomeRua, nomeBairro, nomeCidade, nomeEstado);
		
		return endereco;			
	}
	
	/**
	 * Remove um endereco no banco de dados
	 * @param codigo PK do endereco
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM ENDORF_END WHERE ID_END = ?");

		stmt.setInt(1, codigo);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Endereco não encontrado para ser removido");
		}
	}
}
