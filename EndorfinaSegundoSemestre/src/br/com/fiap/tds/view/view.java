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
			
			
			//Ler os dados
			Scanner leitor = new Scanner(System.in);
			System.out.println("Digite o nome: ");
			usuario.setNome(leitor.next() + leitor.nextLine());
			
			System.out.println("Digite a data de nascimento: ");
			usuario.setDataNascimento(leitor.next() + leitor.nextLine());			
			
			System.out.println("Digite o email ");
			usuario.setEmail(leitor.next() + leitor.nextLine());
			
			System.out.println("Digite a senha ");
			usuario.setSenha(leitor.next() + leitor.nextLine());
			
			//Obter uma conexão
			conexao = ConnectionFactory.getConnection();
			
			//ProdutoDao dao = new ProdutoDao(conexao);
			UsuarioBO bo = new UsuarioBO(conexao);
			//Cadastrar um produto chamando o Dao
			bo.cadastrar(usuario);
			
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
