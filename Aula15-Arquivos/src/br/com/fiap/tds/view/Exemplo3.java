package br.com.fiap.tds.view;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;


public class Exemplo3 {
	
	//Manipular o arquivo e obter algumas informacoes
	public static void main(String[] args) {
		
		//Objeto que representa o arquivo
		File arquivo = new File("exemplo.txt");
		
		
		//Verificar se o arquivo existe
		if(arquivo.isFile() && arquivo.exists()) {
			//Exibir o path
			System.out.println(arquivo.getAbsolutePath());
			//Exibir o tamanho do arquivo
			System.out.println(arquivo.length() + " bytes");
			//Apagar o arquivo
			arquivo.delete();
			
		}else {
			try {
				arquivo.createNewFile();
				
				PrintWriter print = new PrintWriter(arquivo);
				print.println("teste");
				print.close();
				
				FileReader reader = new FileReader(arquivo);
				BufferedReader buffer = new BufferedReader(reader);
				
			} catch(IOException e) {
				System.out.println(e.getMessage());
				
			}

		}
		//Se não existir, criar o arquivo
		
	}
}
