package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.tds.bean.Endereco;
import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.bo.EnderecoBO;
import br.com.fiap.tds.factory.ConnectionFactory;

public class CadastroEndereco {
	
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
			
			System.out.println("Digite o nome da rua: ");
			String nomeRua = (leitor.next() + leitor.nextLine());
			
			System.out.println("Digite o numero da casa: ");
			int numeroCasa = leitor.nextInt();	
			
			System.out.println("Digite o numero do CEP: ");
			int numeroCEP = leitor.nextInt();	
			
			System.out.println("Digite o nome do bairro: ");
			String nomeBairro = (leitor.next() + leitor.nextLine());
			
			System.out.println("Digite o nome da cidade: ");
			String nomeCidade = (leitor.next() + leitor.nextLine());
			
			System.out.println("Digite o nome do estado: ");
			String nomeEstado = (leitor.next() + leitor.nextLine());
			
			//int numeroCasa, int numeroCEP, String nomeRua, String bairro, String cidade, String estado
			Endereco endereco = new Endereco(numeroCasa,numeroCEP,  nomeRua, nomeBairro, nomeCidade, nomeEstado, usuario);
			//Obter uma conexão
			conexao = ConnectionFactory.getConnection();
			
			EnderecoBO bo = new EnderecoBO(conexao);
			
			bo.cadastrarUsuario(endereco);
			
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
