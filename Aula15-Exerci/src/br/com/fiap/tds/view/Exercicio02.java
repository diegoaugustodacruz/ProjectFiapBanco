package br.com.fiap.tds.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exercicio02 {

	public static void main(String[] args) {
		//Ler um arquivo
		
				try{
					
					FileReader inputStream = new FileReader("exercicio02.txt");			
					BufferedReader arquivo = new BufferedReader(inputStream);
					
					FileWriter outputStream = new FileWriter("exercicio02-resultado.txt", true);
					PrintWriter arquivoDestino = new PrintWriter(outputStream);

					String linha;
					
					while((linha = arquivo.readLine())!= null) {
						String[] valores = linha.split(",");
						double valor = Double.parseDouble(valores[0]) + Double.parseDouble(valores[1]);
						
						arquivoDestino.println(valores[0] + ", " + valores[1] + ", " + valor);

					}
					
					System.out.println("Arquivo processado!");
					outputStream.close();
					arquivo.close();
					inputStream.close();
					arquivo.close();
				
				
					
				
				}catch(IOException e) {
					System.out.println(e.getMessage());
				}
		
	}
}
