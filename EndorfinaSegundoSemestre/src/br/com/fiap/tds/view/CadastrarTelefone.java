package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.tds.bean.Telefone;
import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.bo.TelefoneBO;
import br.com.fiap.tds.factory.ConnectionFactory;

public class CadastrarTelefone {
	
	public static void main(String[] args) {
		Connection conexao = null;
		
		
		try {
			
			Scanner leitor = new Scanner(System.in);
			
			System.out.println("Digite o nome da usuario: ");
			String nomeUsuario = (leitor.next() + leitor.nextLine());
			
			System.out.println("Digite a data de nascimento do usuario: ");
			String dataNascimento = (leitor.next() + leitor.nextLine());
			
			System.out.println("Digite o email do usuario: ");
			String email = (leitor.next() + leitor.nextLine());
			
			System.out.println("Digite a senha: ");
			String senha = (leitor.next() + leitor.nextLine());
			
			//String nome, String email, String senha, String dataNascimento
			Usuario usuario = new Usuario(nomeUsuario, email, senha, dataNascimento);
			
			System.out.println("Digite o numero: ");
			int numero = leitor.nextInt();	
			
			System.out.println("Digite o ddd: ");
			int ddd = leitor.nextInt();	
			
			System.out.println("Digite o ddi: ");
			int ddi = leitor.nextInt();			
			
			
			Telefone telefone = new Telefone(ddi, ddd, numero, usuario);
			//Obter uma conexão
			conexao = ConnectionFactory.getConnection();
			
			TelefoneBO bo = new TelefoneBO(conexao);
			
			bo.cadastrarUsuario(telefone);
			
			System.out.println("Sucesso!!");
			
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
