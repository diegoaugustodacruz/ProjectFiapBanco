package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.fiap.tds.bean.Departamento;
import br.com.fiap.tds.bo.DepartamentoBO;
import br.com.fiap.tds.factory.ConnectionFactory;

public class DepartamentoCadastrar {

	//Cadastro de produto
	public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
		
			//Instanciar um Produto
			Departamento departamento = new Departamento ();
			
			//Ler os dados
			Scanner leitor = new Scanner(System.in);
			
			System.out.println("Digite o nome");
			departamento.setNome(leitor.next() + leitor.nextLine());
			
			System.out.println("Digite a sigla");
			departamento.setSigla(leitor.next() + leitor.nextLine());		
			
			conexao = ConnectionFactory.getConnection();
			
			DepartamentoBO departamentoBO = new DepartamentoBO(conexao);
			
			departamentoBO.cadastrar(departamento);
			
			System.out.println("Departamento registrado!");
			
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conexao != null)
					conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//main
	
}
