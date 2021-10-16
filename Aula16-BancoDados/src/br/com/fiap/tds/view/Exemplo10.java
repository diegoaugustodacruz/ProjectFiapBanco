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

public class Exemplo10 {

	public static void main(String[] args) {
		
		Connection conexao = null;
		
		
		try {
			conexao = ConnectionFactory.getConnection();

			
			//Ler os dados da nota
			Scanner leitor = new Scanner(System.in);
			System.out.println("Digite o valor da nota: ");
			double valor = leitor.nextDouble();
			
			//Ler os dados do pedido
			System.out.println("Digite a data da nota: ");
			String data = leitor.next() + leitor.nextLine();
			
			//Converter a string para localdate
			LocalDate dataNota = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			//Instanciar a nota
			NotaFiscal nota = new NotaFiscal(valor);
			
			//Instanciar o pedido com a nota
			Pedido pedido = new Pedido(dataNota, nota);
			
			//Instanciar PedidoBo
			PedidoBo bo = new PedidoBo(conexao);
			
			//Cadastrar a nota
			bo.cadastrar(pedido);
			System.out.println("Sucesso");
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		
		} finally {
			try {
				if(conexao != null) {
					conexao.close();
					
				}
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}
}
