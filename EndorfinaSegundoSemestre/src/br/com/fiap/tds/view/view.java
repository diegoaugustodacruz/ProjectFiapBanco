package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.bo.UsuarioBO;
import br.com.fiap.tds.factory.ConnectionFactory;

public class view {

	public static void main(String[] args) {
		Connection conexao = null;
		
		
		try {
			//Instanciar um USUARIO
			Usuario usuario = new Usuario();
			
			conexao = ConnectionFactory.getConnection();
			
			UsuarioBO bo = new UsuarioBO(conexao);
			
			//Ler os dados
			Scanner leitor = new Scanner(System.in);
			
			
			System.out.println("Digite o código: ");
			int codigo = (leitor.nextInt());				
			
			//Cadastrar um produto chamando o Dao
			bo.pesquisar(codigo);
			
			//Fechar
			leitor.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		//Instanciar um dao
		} finally {
			try {
				if(conexao != null) {
					conexao.close();
					
				}
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}//main
	
}
