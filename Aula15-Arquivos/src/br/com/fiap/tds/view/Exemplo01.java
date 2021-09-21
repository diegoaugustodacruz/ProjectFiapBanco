package br.com.fiap.tds.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Exemplo01 {

	// Gravar informacoes em um arquivo
	public static void main(String[] args) {

		try {
			// Criar um fluxo de saida de dados para um arquivo, insere o valor no final do arquivo
			FileWriter outputStream = new FileWriter("exemplo.txt", true);

			//Instanciar um objeto que escreve no arquivo texto
			PrintWriter arquivo = new PrintWriter(outputStream);
			
			//Escrever o texto no arquivo
			String nome = JOptionPane.showInputDialog("Digite um nome: ");		
			arquivo.println(nome);
			System.out.println("Escrevendo no arquivo...");
			
			//Fechar os recursos
			outputStream.close();
			arquivo.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
