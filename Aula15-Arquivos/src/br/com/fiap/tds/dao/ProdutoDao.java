package br.com.fiap.tds.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.bean.Produto;

public class ProdutoDao {
	
	public void cadastrar(Produto produto) throws IOException{
		//Gravar o produto no arquivo, cada linha representa um produto
		FileWriter outputStream = new FileWriter("produtos.txt", true);
		PrintWriter arquivo = new PrintWriter(outputStream);


		arquivo.println(produto.getNome() + ";" + produto.getValor() + ";" + produto.getCategoria());
		outputStream.close();
		arquivo.close();
	}
	
	public List<Produto> listar() throws IOException{	
		
		FileReader inputStream = new FileReader("produtos.txt");
		
		BufferedReader arquivo = new BufferedReader(inputStream);
		
		List<Produto> lista = new ArrayList<>();
		
		String linha;
		
		while((linha=arquivo.readLine()) != null) {
			
			//Retorna um vetor de String de acordo com o caracter de separacao
			String[] valores = linha.split(";");
			Produto produto = new Produto(valores[0], Double.parseDouble(valores[1]), valores[2]);
			lista.add(produto);
		}
		return lista;
	}

}
