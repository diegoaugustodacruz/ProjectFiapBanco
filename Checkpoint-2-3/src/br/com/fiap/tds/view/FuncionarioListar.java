package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.bo.FuncionarioBO;
import br.com.fiap.tds.factory.ConnectionFactory;

public class FuncionarioListar {
	public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			//Obter uma conex�o
			conexao = ConnectionFactory.getConnection();
			
			//Instanciar o Dao
			FuncionarioBO bo = new FuncionarioBO(conexao);
			
			//Pesquisar todos os produtos
			List<Funcionario> lista = bo.listar();
			
			//Exibir os produtos
			for (Funcionario funcionario: lista) {
				System.out.println(funcionario);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conexao != null) conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}//main
}
