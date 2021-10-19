package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.fiap.tds.bean.NotaFiscal;
import br.com.fiap.tds.bean.Pedido;
import br.com.fiap.tds.bo.PedidoBo;
import br.com.fiap.tds.factory.ConnectionFactory;

public class PedidoCadastro {

	//Cadastrar um pedido com a nota fiscal
	public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			Scanner sc = new Scanner(System.in);
			//Ler os dados da nota 
			System.out.println("Digite o valor da nota");
			double valor = sc.nextDouble();
			
			//Ler os dados do pedido
			System.out.println("Digite a data da nota");
			String data = sc.next() + sc.nextLine();
			
			//Converter a String para LocalDate
			LocalDate dataNota = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			//Instanciar a nota
			NotaFiscal nota = new NotaFiscal(valor);
			
			//Instanciar o pedido com a nota
			Pedido pedido = new Pedido(dataNota, nota);
			
			//Obter uma conexão
			conexao = ConnectionFactory.getConnection();
			
			//Instanciar o PedidoBo
			PedidoBo bo = new PedidoBo(conexao);
			
			//Cadastrar a nota
			bo.cadastrar(pedido);
			System.out.println("Sucesso!");
			
			sc.close();
		} catch (Exception e) {
			try {
				if (conexao != null) conexao.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}//main
}//class
