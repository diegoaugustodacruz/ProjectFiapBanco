package br.com.fiap.tds.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Exericicio01 {
	
	public static void main(String[] args) {
	
		//Ler um arquivo
		
		try{
			
			FileReader inputStream = new FileReader("exercicio1.txt");			
			BufferedReader arquivo = new BufferedReader(inputStream);
			
			FileWriter outputStream = new FileWriter("exercicio01-resultado.txt", true);
			PrintWriter arquivoDestino = new PrintWriter(outputStream);

			String linha;
//			StringBuffer buffer = new StringBuffer();
			
			while((linha = arquivo.readLine())!= null) {
				//Retirar os caracteres especiais e numeros
				//troca os caracteres que nao estao entre A-z e espaco por ""
				arquivoDestino.println(linha.replaceAll("[^A-z ]", ""));
				//buffer.append(linha).append("\n");
			}
			
			//arquivoDestino.print(buffer.toString().replaceAll("[Â-z ]", ""));
			System.out.println("Arquivo processado!");
			//Fechar os recursos
			outputStream.close();
			arquivo.close();
			inputStream.close();
			arquivo.close();
		
		
			
		
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
				
		
		
		
	}
}
