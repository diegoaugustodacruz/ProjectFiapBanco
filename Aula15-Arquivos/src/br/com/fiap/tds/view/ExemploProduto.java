package br.com.fiap.tds.view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.dao.ProdutoDao;

public class ExemploProduto {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		//Variavel para armazenar opcao do usuario
		int opcao;
		
		//Instanciar DAO
		ProdutoDao dao = new ProdutoDao();
		
		do {
			//Menu 1-Cadastrar 2-Listar 0-Sair
			System.out.println("Escolha: 1-Cadastrar 2-Listar 0-Sair");
			opcao = leitor.nextInt();
			
			switch (opcao) {
				case 1:
					
					//1-Pedir as informacoes do produto, instanciar o produto e chamar o metodo cadastrar do DAO
					System.out.println("Digite o nome do produto: ");
					String nome = leitor.next() + leitor.nextLine();
					
					System.out.println("Digite o valor do produto: ");
					double valor = leitor.nextDouble();
					
					System.out.println("Digite a categoria do produto: ");
					String categoria = leitor.next() + leitor.nextLine();
					
					Produto produto = new Produto(nome, valor, categoria);
					
					try {
						dao.cadastrar(produto);
					} catch (IOException e) {
						e.printStackTrace();
					}					
					
				break;
				
				case 2:
					//2-Recuperar a lista de produto utilizando o DAO e exibir os valores
					try {
						List<Produto> lista = dao.listar();
						for(Produto item: lista) {
							System.out.println(item.getNome() + " " + item.getValor() + " " + item.getCategoria());
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
									
				case 0:
					System.out.println("Finalizando...");
					break;

			default:
				break;
			}
		}while(opcao!=0);
		
		leitor.close();
		
		
	}
}
