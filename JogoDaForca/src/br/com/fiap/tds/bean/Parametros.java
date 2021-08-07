package br.com.fiap.tds.bean;

public class Parametros {
	
	private String palavra, palavraAst, dica;
	
	private String vogais = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	private int vidas;
	
	char c;
	
	public Parametros() {
		
	}
	
	
	public Parametros(String palavra, String dica, int vidas ) {
		this.palavra = palavra;
		this.dica = dica;
		this.vidas = vidas;

		
	}
	
	
		
	public String mudancaAsterisco() {
		palavraAst = palavra;
		for(int i = 0; i<vogais.length(); i++) { 
		
			palavraAst = palavraAst.replace(vogais.charAt(i) , '*'); 
				  }
			 
		return palavraAst;
	
		}


	public String getPalavra() {
		return palavra;
	}


	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}


	public String getPalavraAst() {
		return palavraAst;
	}


	public void setPalavraAst(String palavra_ast) {
		this.palavraAst = palavra_ast;
	}


	public String getDica() {
		return dica;
	}


	public void setDica(String dica) {
		this.dica = dica;
	}


	public String getVogais() {
		return vogais;
	}


	public void setVogais(String vogais) {
		this.vogais = vogais;
	}


	public int getVidas() {
		return vidas;
	}


	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	

	public char getC() {
		return c;
	}


	public void setC(char c) {
		this.c = c;
	}
	


	
	
	
		
	}
	
	

	
	
	
		

