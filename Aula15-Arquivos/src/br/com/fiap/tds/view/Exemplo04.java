package br.com.fiap.tds.view;

import java.io.File;
import java.io.IOException;

public class Exemplo04 {

	public static void main(String[] args) {

		// Criar um objeto que representa um diretorio
		File diretorio = new File("arquivos");

		// Verificar se é um diretorio e se existe
		if (diretorio.isDirectory() && diretorio.exists()) {
			// Exibir o caminho completo
			System.out.println(diretorio.getAbsolutePath());
			// Verificar se existe arquivos
			// Recupera um vetor de File com diretorios/arquivos
			File[] files = diretorio.listFiles();

			int qtdArq = 0;
			int qtdDir = 0;
			if (files.length == 0) {
				for (File file : files) {
					if (file.isFile()) {
						qtdArq = qtdArq + 1;
					} else {
						qtdDir = qtdDir + 1;
					}
				}
				System.out.println("Qtd diretorios: " + qtdDir);
				System.out.println("Qtd arquivos: " + qtdArq);

			} else {
				System.out.println("Contem arquivos ou diretorios");
			}
			
			//Criar um arquivo dentro do diretorio
			File classe = new File(diretorio, "Cliente.java");
				
			try {
				classe.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
			

			// Apagar o diretorio
			diretorio.delete();
			System.out.println("Deletando...");
		}
		// Se nao existir
		else {
			// Criar o diretorio
			diretorio.mkdir();
			System.out.println("Criando...");

		}

	}
}
