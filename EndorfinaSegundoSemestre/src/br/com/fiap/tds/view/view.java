package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.tds.bean.Profissional;
import br.com.fiap.tds.bo.ProfissionalBO;
import br.com.fiap.tds.factory.ConnectionFactory;

public class view {

	public static void main(String[] args) {
		Connection conexao = null;
		
		
		try {
			//Instanciar um USUARIO
			Profissional profissional = new Profissional();
			
			
			//Ler os dados
			Scanner leitor = new Scanner(System.in);
			System.out.println("Digite o nome: ");
			profissional.setNome(leitor.next() + leitor.nextLine());
			
			System.out.println("Digite a data de nascimento: ");
			profissional.setDataNascimento(leitor.next() + leitor.nextLine());			
			
			System.out.println("Digite o email ");
			profissional.setEmail(leitor.next() + leitor.nextLine());
			
			System.out.println("Digite a senha ");
			profissional.setSenha(leitor.next() + leitor.nextLine());
			
			//Obter uma conexão
			conexao = ConnectionFactory.getConnection();
			
			ProfissionalBO bo = new ProfissionalBO(conexao);
			//Cadastrar um produto chamando o Dao
			bo.cadastrar(profissional);
			
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
