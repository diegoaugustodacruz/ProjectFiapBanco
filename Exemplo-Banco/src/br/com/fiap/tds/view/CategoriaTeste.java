package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import br.com.fiap.tds.bean.Categoria;
import br.com.fiap.tds.bo.CategoriaBo;
import br.com.fiap.tds.exception.DadoInvalidoException;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.ConnectionFactory;

public class CategoriaTeste {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		Connection conexao = null;
		
		try {
			conexao = ConnectionFactory.getConnection();
			CategoriaBo bo = new CategoriaBo(conexao);
			int op;
			do {
				System.out.println("/*************\nEscolha: \n1-Cadastrar \n2-Atualizar \n3-Listar \n4-Pesquisar por código \n5-Remover \n0-Sair");
				op = sc.nextInt();
	
				switch (op) {
				case 1:
					cadastrar(bo);
					break;
				case 2:
					atualizar(bo);
					break;
				case 3:
					listar(bo);
					break;
				case 4:
					pesquisar(bo);
					break;
				case 5:
					remover(bo);
					break;
				case 0:
					System.out.println("Finalizando o sistema!");
					break;
				default:
					System.out.println("Opção inválida");
				}
	
			} while (op != 0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
			try {
				if (conexao != null) conexao.close();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
	}// main

	private static void cadastrar(CategoriaBo bo) throws SQLException  {
		System.out.println("Digite o nome");
		String nome = sc.next() + sc.nextLine();
		
		System.out.println("Digite a data (dd/mm/aaaa)");
		String data = sc.next() + sc.nextLine();

		try {
			Categoria categoria = new Categoria(nome, data);
			bo.cadastrar(categoria);
			System.out.println("Categoria cadastrada!");
		} catch (DadoInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void atualizar(CategoriaBo bo) throws SQLException {
		System.out.println("Digite o código");
		int codigo = sc.nextInt();
		
		System.out.println("Digite o nome");
		String nome = sc.next() + sc.nextLine();
		
		System.out.println("Digite a data (dd/mm/aaaa)");
		String data = sc.next() + sc.nextLine();

		try {
			Categoria categoria = new Categoria(codigo, nome, data);
			bo.atualizar(categoria);
		System.out.println("Categoria atualizada!");
		} catch (IdNotFoundException | DadoInvalidoException e) {
			System.out.println(e.getMessage());
		}

	}
	
	private static void listar(CategoriaBo bo) throws SQLException {
		List<Categoria> lista = bo.listar();
		for (Categoria categoria : lista) {
			System.out.println(categoria);
		}
	}
	
	private static void pesquisar(CategoriaBo bo) throws SQLException {
		try {
			System.out.println("Digite o código da categoria");
			int codigo = sc.nextInt();
			Categoria categoria = bo.pesquisar(codigo);
			System.out.println(categoria);
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	private static void remover(CategoriaBo bo) throws SQLException {
		try {
			System.out.println("Digite o código da categoria");
			int codigo = sc.nextInt();
			bo.remover(codigo);
			System.out.println("Categoria removida!");
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}	
	}


}// class