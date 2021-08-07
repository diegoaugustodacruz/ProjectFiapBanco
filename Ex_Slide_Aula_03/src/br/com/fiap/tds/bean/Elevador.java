package br.com.fiap.tds.bean;

public class Elevador {
	
	public int andar;
	
	public int totpessoas;
	
	public int capac;
	
	public int totAndares;
	
	public void inicializa(int totfloor, int capacity) {
		totAndares = totfloor;
		capac = capacity;
						
	}
	
	public int entra() {
		totpessoas = totpessoas + 1;
		return totpessoas;
		
	}
	
	public int sai() {
		totpessoas = totpessoas - 1;
		return totpessoas;
	}
	
	public int sobe() {
		andar = andar + 1;
		return andar;
	}
	
	public int desce() {
		andar = andar - 1;
		return andar;
	}
	
	
	

}
