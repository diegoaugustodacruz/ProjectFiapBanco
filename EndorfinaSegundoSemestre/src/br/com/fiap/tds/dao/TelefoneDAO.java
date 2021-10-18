package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.bean.Endereco;
import br.com.fiap.tds.bean.Telefone;
import br.com.fiap.tds.exception.IdNotFoundException;

public class TelefoneDAO {

	private Connection conexao;

	public TelefoneDAO(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	public List<Telefone> buscarPorNumero(int ddd) throws SQLException{
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_TEL WHERE NR_NUMERO LIKE ?");

		String numero = Integer.toString(ddd);
		//Passar o parametro para a query
		stmt.setString(1,"%" + numero + "%");		
		
		//Executar
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);
	}
	
	private List<Telefone> parseList(ResultSet result) throws SQLException{
		List<Telefone> lista = new ArrayList<Telefone>();
		
		while(result.next()) {			
			Telefone telefone = parse(result);
			lista.add(telefone);
		}
		return lista;                                                                                                                                                                                           
		
	}

	public void cadastrarUsuario(Telefone telefone) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_TEL "
				+ "(ID_TEL, ID_USUARIO, NR_NUMERO, NR_DDD, NR_DDI)"
				+ " VALUES (SQ_ENDORF_TEL.NEXTVAL, ?, ?, ?, ?)");
		
		//passar os valores para o comando SQL
		stmt.setInt(1, telefone.getUsuario().getIdUsuario());
		stmt.setInt(2, telefone.getNumeroTel());
		stmt.setInt(3, telefone.getDdd());
		stmt.setInt(4, telefone.getDdi());

		
		//Executar o comando SQL                    
		stmt.executeUpdate();
	}
	public void cadastrarProfissional(Telefone telefone) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_TEL "
				+ "(ID_TEL, ID_PROFISSIONAL, NR_NUMERO, NR_DDD, NR_DDI)"
				+ " VALUES (SQ_ENDORF_TEL.NEXTVAL, ?, ?, ?, ?)");
		
		//passar os valores para o comando SQL
		stmt.setInt(1, telefone.getProfissional().getIdProfissional());
		stmt.setInt(2, telefone.getNumeroTel());
		stmt.setInt(3, telefone.getDdd());
		stmt.setInt(4, telefone.getDdi());

		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
	public void atualizar(Telefone telefone) throws SQLException, IdNotFoundException{
		pesquisar(telefone.getIdTelefone());
		
		PreparedStatement stmt = conexao.prepareStatement("UPDATE ENDORF_TEL SET NR_NUMERO = ?, NR_DDD = ?,"
				+ " NR_DDI = ? WHERE ID_TEL = ?");
		stmt.setInt(1, telefone.getNumeroTel());
		stmt.setInt(2, telefone.getDdi());
		stmt.setInt(3, telefone.getDdi());
		stmt.setInt(4, telefone.getIdTelefone());	


		int qtd = stmt.executeUpdate();		

		if(qtd == 0) {
			throw new IdNotFoundException("Telefone não encontrado");
		}
		
	}
	

	public Telefone pesquisar(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_TEL WHERE ID_TEL = ?");
		
		stmt.setInt(1, codigo);		

		ResultSet result = stmt.executeQuery();

		if(!result.next()) {
			throw new IdNotFoundException("Usuario não encontrado");
			
		}
		
		Telefone telefone = parse(result);
		
		return telefone;
	}
	
	public List<Telefone> listar() throws SQLException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM ENDORF_TEL");
		
		ResultSet result = stmt.executeQuery();

		List<Telefone> lista = new ArrayList<Telefone>();

		while(result.next()) {			
			Telefone telefone = parse(result);
			lista.add(telefone);
		}
		return lista;
	}
	
	private Telefone parse(ResultSet result) throws SQLException {

		int id = result.getInt("ID_TEL");
		int numeroTel = result.getInt("NR_NUMERO");
		int numeroDDD = result.getInt("NR_DDD");
		int numeroDDI = result.getInt("NR_DDI");
		
		Telefone telefone = new Telefone(id, numeroDDI, numeroDDD, numeroTel);
		
		return telefone;			
	}
	
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM ENDORF_TEL WHERE ID_TEL = ?");

		stmt.setInt(1, codigo);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Telefone não encontrado para ser removido");
		}
	}
	
}
