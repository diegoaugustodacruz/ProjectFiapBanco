package br.com.fiap.tds.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
	
	public void editar(int codigo, String nomeProduto, double valor, int quantidade) {
		Produto produto;

		if(mapa.containsKey(codigo)) {
			produto = mapa.get(codigo);
			produto = new Produto(codigo, nomeProduto, valor, quantidade);
			mapa.put(codigo, produto);

		}else {			
			produto = null; 	
			}	

		
	
	}	
	
	public void remover(int codigo) {
		if(mapa.containsKey(codigo)) {			
			mapa.remove(codigo);
		}
		
	}
	
	public Produto pesquisarPorNome(String nome) {
		
		List<Produto> valores = new ArrayList<>(mapa.values());
		Produto resultado = null;
		
		for(Produto busca: valores) {
			if(busca.getNome().equals(nome)) {
				resultado = busca;
			}else {
				resultado = null;
			}
		}
		
		return resultado;
		
	}
	
}
