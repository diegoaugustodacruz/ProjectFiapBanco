package br.com.fiap.tds.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.fiap.tds.bean.Produto;

public class ProdutoDao {
		
	
	Map<Integer, Produto> mapa = new HashMap<Integer, Produto>();

	
	public void cadastrar(int codigo, String nomeProduto, double valor, int quantidade) {
		
		Produto produto;

		if(mapa.containsKey(codigo)) {
			produto = mapa.get(codigo);
		}else {			
			produto = new Produto(); 	
			}
		
		produto = new Produto(codigo, nomeProduto, valor, quantidade);

		
		mapa.put(codigo, produto);
	}
	
	public Collection<Produto> listar(){
		Collection<Produto> valores = mapa.values();
		return valores;
		
	}
	
	public Produto pesquisarPorCodigo(int codigo) {	
		Produto produto;		
		if(mapa.containsKey(codigo)) {
			produto = mapa.get(codigo); 
			return produto;
			
		}else{
			return null;
		}

	}
	
	public void editar() {
		
	}	
	
	public void remover(int codigo) {
		if(mapa.containsKey(codigo)) {			
			mapa.remove(codigo);
		}
		
	}
	
//	public Produto pesquisarPorNome(String nome) {
//		Produto busca = null;
//		if(mapa.containsValue(nome)) {
//			int chave = mapa.keySet();
//			return busca;
//		}
//		
//	}
	
}
