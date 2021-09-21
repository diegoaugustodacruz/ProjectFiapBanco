package br.com.fiap.tds.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exemplo02 {
	
	//Abrir o arquivo e ler o conteudo
	public static void main(String[] args) {
		
		try{
			
			//Criar o fluxo de entrada de dados
			FileReader inputStream = new FileReader("exemplo.txt");
			
			//Criar o objeto que le o arquivo
			BufferedReader arquivo = new BufferedReader(inputStream);
			
			//Ler a linha: se tiver valor, retorna o valor e vai para a próxima linha. Se não retorna null
			String linha;
			StringBuffer texto = new StringBuffer();
			
			while((linha = arquivo.readLine())!= null) {
				texto.append(linha).append("\n");
			}
			
			System.out.println(texto);
			
			//Fechar
			inputStream.close();
			arquivo.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
