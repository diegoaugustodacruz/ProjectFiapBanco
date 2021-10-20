package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.tds.bo.UsuarioBO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.ConnectionFactory;

public class RemoverUsuario {
public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			//Obter a conex�o
			conexao = ConnectionFactory.getConnection();
			
			//Instancia
			UsuarioBO bo = new UsuarioBO(conexao);
			
			//Ler o c�digo para remo��o
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite o c�digo");
			int codigo = sc.nextInt();
			
			//Remover o produto
			bo.remover(codigo);
			System.out.println("Produto removido!");
			
			sc.close();
		} catch (IdNotFoundException e) {
			System.err.println(e.getMessage());
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
