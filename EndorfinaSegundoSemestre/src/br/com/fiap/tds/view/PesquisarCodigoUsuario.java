package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.bo.UsuarioBO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.ConnectionFactory;

public class PesquisarCodigoUsuario {
	
public static void main(String[] args) {
		
		Connection conexao = null;
		try {
			//Obter uma conex�o
			conexao = ConnectionFactory.getConnection();
			
			//Instanciar o DAO
			UsuarioBO bo = new UsuarioBO(conexao);
			
			//Ler o c�digo
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite o codigo");
			int codigo = sc.nextInt();
			
			//Pesquisar
			Usuario usuario = bo.pesquisar(codigo);
			
			//Exibir os dados do produto
			System.out.println(usuario);
			
			sc.close();
			
		} catch (IdNotFoundException e1) {
			System.err.println(e1.getMessage());
		}catch (Exception e) {
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
