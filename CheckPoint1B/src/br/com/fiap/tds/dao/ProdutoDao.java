package br.com.fiap.tds.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.tds.bean.Produto;

public class ProdutoDao {
	Map<Integer, Produto> mapa = new HashMap<Integer, Produto>();
	

	/**
	 * Cadastra um produto na base de dados
	 * @param produto produto a ser cadastrado
	 */
	public void cadastrar(Produto produto) {
		Produto resultado;
		if(mapa.containsKey(produto.getCodigo())) {
			resultado = mapa.get(produto.getCodigo());
		}else {
			resultado = produto;
		}
		
		mapa.put(produto.getCodigo(), resultado);	
		
	}
	/**
	 * Lista os produtos na base de dados
	 * @return as informacoes dos produtos na base de dados
	 */
	public Collection<Produto> listar(){
		Collection<Produto> valores = mapa.values();
		return valores;
		
	}
	
	/**
	 * Pesquisa as informacoes de um produto através de um código
	 * @param codigo codigo do produto
	 * @return as informacoes do produto
	 */
	public Produto pesquisarPorCodigo(int codigo) {	
		Produto produto;		
		if(mapa.containsKey(codigo)) {
			produto = mapa.get(codigo); 
			return produto;
			
		}else{
			return null;
		}

	}
	
	/**
	 * Edita as informacoes de um produto
	 * @param codigo codigo de um produto cadastrado
	 * @param nomeProduto novo nome de um produto
	 * @param valor novo valor de um produto
	 * @param quantidade nova quantidade de um produto
	 */
	public void editar(Produto produto) {

		if(mapa.containsKey(produto.getCodigo())) {
			mapa.put(produto.getCodigo(), produto);

		}else {			
			produto = null; 	
			}	
	}	
	
	
	/**
	 * Remove um produto através de seu código
	 * @param codigo código do produto
	 */
	public void remover(int codigo) {
		if(mapa.containsKey(codigo)) {			
			mapa.remove(codigo);
		}
		
	}
	
	/**
	 * Pesquisa as informacoes de um produto através de um nome
	 * @param nome nome do produto
	 * @return as informacoes do produto
	 */
	public Produto pesquisarPorNome(String nome) {
		
		List<Produto> valores = new ArrayList<>(mapa.values());
		Produto resultado = null;
		
		for(Produto busca: valores) {
			if(busca.getNome().equals(nome)) {
				resultado = busca;
			}
		}
		
		return resultado;
		
	}
}
