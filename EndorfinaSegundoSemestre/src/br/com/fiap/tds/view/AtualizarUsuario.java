package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.bo.UsuarioBO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.ConnectionFactory;

public class AtualizarUsuario {

public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			//Obter uma conex�o
			conexao = ConnectionFactory.getConnection();
			
			//Instanciar um ProdutoDao
			//ProdutoDao dao = new ProdutoDao(conexao);
			
			//Ler os dados para atualizar o produto
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Digite o codigo: ");
			int codigo = sc.nextInt();
			
			System.out.println("Digite o nome: ");
			String nome = sc.next() + sc.nextLine();
			
			System.out.println("Digite a data de nascimento: ");
			String dataNascimento = sc.next() + sc.nextLine();
			
			System.out.println("Digite o email: ");
			String email = sc.next() + sc.nextLine();
			
			System.out.println("Digite a senha: ");
			String senha = sc.next() + sc.nextLine();
			
			//int idUsuario, String nome, String email, String senha, String dataCadastro, String dataNascimento
			Usuario usuario = new Usuario(codigo, nome, email, senha, dataNascimento);
			
			//Atualizar
			UsuarioBO bo = new UsuarioBO(conexao);
			bo.atualizar(usuario);
			
			System.out.println("Produto atualizado!");
		
			sc.close();
		} catch (IdNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//Fechar
			try {
				if (conexao != null) conexao.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}//main
}
