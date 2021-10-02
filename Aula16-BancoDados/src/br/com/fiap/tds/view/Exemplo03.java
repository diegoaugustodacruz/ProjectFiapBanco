package br.com.fiap.tds.view;

import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.dao.ProdutoDao;

public class Exemplo03 {

	public static void main(String[] args) {
		
		//Instanciar um Produto
		Produto produto = new Produto();
		
		//Instanciar um dao
		ProdutoDao dao = new ProdutoDao();
		
		//Cadastrar um produto chamando o Dao
		dao.cadastrar(produto);
		
		
	}//main
}//class
