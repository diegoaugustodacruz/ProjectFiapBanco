package br.com.fiap.tds.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.dao.EnderecoDAO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.to.EnderecoTO;

/**
 * Classe que realiza operacoes basicas com o endereco no banco
 * @author Diego
 *
 */
public class EnderecoOracleDAO implements EnderecoDAO{

	private Connection conexao;

	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public EnderecoOracleDAO(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	/**
	 * Pesquisa os enderecos por parte do nome da rua
	 * @param nome Termo de pesquisa
	 * @return List<Endereco> Lista dos enderecos encontrados
	 * @throws SQLException
	 */
	@Override
	public List<EnderecoTO> buscarPorNome(String nome) throws SQLException{
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_ENDERECO WHERE NM_LOGRADOURO LIKE ?");

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
	private List<EnderecoTO> parseList(ResultSet result) throws SQLException{
		List<EnderecoTO> lista = new ArrayList<EnderecoTO>();
		
		while(result.next()) {			
			EnderecoTO endereco = parse(result);
			lista.add(endereco);
		}
		return lista;
		
	}
	
	/**
	 * Cadastra um endereco de um supermercado no banco de dados
	 * @param endereco Endereco com valores que serao cadastrados
	 * @throws SQLException
	 */
	@Override
	public void cadastrar(EnderecoTO endereco) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_ENDERECO "
				+ "(CD_ENDERECO, NR_CEP, NM_LOGRADOURO, NR_LOGRADOURO, NM_BAIRRO, NM_CIDADE, NM_ESTADO, CD_SUPERMERCADO)"
				+ " VALUES (SQ_T_ENDERECO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");
		
		stmt.setString(1, endereco.getNumeroCEP());
		stmt.setString(2, endereco.getNomeRua());
		stmt.setInt(3, endereco.getNumeroCasa());
		stmt.setString(4, endereco.getBairro());
		stmt.setString(5, endereco.getCidade());
		stmt.setString(6, endereco.getEstado());
		stmt.setInt(7, endereco.getSupermercado().getCodigo());
		
		stmt.executeUpdate();
		
		
	}	
	
	
	/**
	 * Atualiza endereco no banco de dados
	 * @param endereco Endereco com valores que serao atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@Override
	public void atualizar(EnderecoTO endereco) throws SQLException, IdNotFoundException{
		pesquisar(endereco.getIdEndereco());
		
		PreparedStatement stmt = conexao.prepareStatement("UPDATE T_ENDERECO SET NM_LOGRADOURO = ?, NR_LOGRADOURO = ?,"
				+ " NR_CEP = ?, NM_BAIRRO = ?, NM_CIDADE = ?, NM_ESTADO = ? WHERE CD_ENDERECO = ?");
		stmt.setString(1, endereco.getNomeRua());
		stmt.setInt(2, endereco.getNumeroCasa());
		stmt.setString(3, endereco.getNumeroCEP());
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
	@Override
	public EnderecoTO pesquisar(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_ENDERECO WHERE CD_ENDERECO = ?");
		
		stmt.setInt(1, codigo);		

		ResultSet result = stmt.executeQuery();

		if(!result.next()) {
			throw new IdNotFoundException("Endereco não encontrado");
			
		}
		
		EnderecoTO endereco = parse(result);
		
		return endereco;
	}
	
	/**
	 * Retorna todos os enderecos do banco de dados
	 * @return List<Enderecos> Lista de enderecos
	 * @throws SQLException
	 */
	@Override
	public List<EnderecoTO> listar() throws SQLException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_ENDERECO");
		
		ResultSet result = stmt.executeQuery();

		List<EnderecoTO> lista = new ArrayList<EnderecoTO>();

		while(result.next()) {			
			EnderecoTO endereco = parse(result);
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
	private EnderecoTO parse(ResultSet result) throws SQLException {

		int id = result.getInt("CD_ENDERECO");
		int numeroCasa = result.getInt("NR_LOGRADOURO");
		String numeroCEP = result.getString("NR_CEP");
		String nomeRua = result.getString("NM_LOGRADOURO");
		String nomeBairro = result.getString("NM_BAIRRO");
		String nomeCidade = result.getString("NM_CIDADE");
		String nomeEstado = result.getString("NM_ESTADO");

		EnderecoTO endereco = new EnderecoTO(id, numeroCasa, nomeRua, nomeBairro, nomeCidade ,  nomeEstado, numeroCEP );
		
		return endereco;			
	}
	
	/**
	 * Remove um endereco no banco de dados
	 * @param codigo PK do endereco
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@Override
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_ENDERECO WHERE CD_ENDERECO = ?");

		stmt.setInt(1, codigo);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Endereco não encontrado para ser removido");
		}
	}
	
	@Override
	protected void finalize() throws Throwable{
		conexao.close();
	}
}
