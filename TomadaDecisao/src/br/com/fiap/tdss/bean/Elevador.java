package br.com.fiap.tdss.bean;

public class Elevador {
	
	private int andarAtual, totalAndares, capacidade, qtdAtualPessoas;
	
	
	public Elevador() {
		
	}
	
	public Elevador(int capacidade, int totalAndares) {
		this.capacidade = capacidade;
		this.totalAndares = totalAndares;
		
	}
	
	
	public int entra() {
//		if(1 + qtdAtualPessoas != capacidade)
//			qtdAtualPessoas = qtdAtualPessoas + 1;
//		return qtdAtualPessoas;
		return entra(1);
	}
	
	public int entra(int qtd) {
		if((qtd + qtdAtualPessoas) <= capacidade) 
			qtdAtualPessoas = qtdAtualPessoas + qtd;
		return qtdAtualPessoas ;			
		
	}
	
	public int sai() {
//		if(qtdAtualPessoas -1 >= 0)
//			qtdAtualPessoas = qtdAtualPessoas - 1;
//		return qtdAtualPessoas;
		return sai(1);
	}
		
	
	

	public int sai(int qtd) {
		if((qtdAtualPessoas - qtd)>=0) 
			qtdAtualPessoas = qtdAtualPessoas - qtd;
		return qtdAtualPessoas;
		}
		

	public boolean sobe() {
		if(andarAtual==totalAndares) 
			return false;
		andarAtual = andarAtual + 1;
		return true;
						
	}
	
	public boolean desce() {
		if(andarAtual==0) 
			return false;
		andarAtual = andarAtual - 1;
		return true;
		
		
	}
	
	
	public int getAndarAtual() {
		return andarAtual;
	}

	public int getTotalAndares() {
		return totalAndares;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public int getQtdAtualPessoas() {
		return qtdAtualPessoas;
	}
	
	
	
}
