package br.com.fiap.tds.dao;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import br.com.fiap.tds.bean.Produto;

public class ProdutoDao {
		
	
	Map<Integer, Produto> mapa = new HashMap<Integer, Produto>();

	
	public void cadastrar(int codigo, String nomeProduto) {
		
		Produto produto;

		if(mapa.containsKey(codigo)) {
			produto = mapa.get(codigo);
		}else {			
			produto = new Produto(codigo); 	
			}
		
		do {
			Double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor: "));
			int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade"));
			
			produto = new Produto(codigo, nomeProduto, valor, quantidade);
			
		}while(JOptionPane.showConfirmDialog(null, "Quer continuar cadastrando?") == JOptionPane.YES_OPTION);					
		
		mapa.put(codigo, produto);
	}
	
	public Map<Integer, Produto> listar(){
		return mapa;
	}
	
	public void pesquisarPorCodigo() {
		
	}
	
	public void editar() {
		
	}	
	
	public void remover(int codigo) {
		
	}
	
	public void pesquisarPorNome() {
		
	}
	
}
