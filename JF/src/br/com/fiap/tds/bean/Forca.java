package br.com.fiap.tds.bean;

public class Forca {
	
	private String letra, esconde, dica;
	private int vidas = 6;

	public Forca() {

	}


	public Forca(String letra, String esconde, String dica, int vidas) {
	super();
	this.letra = letra;
	this.esconde = esconde;
	this.dica = dica;
	this.vidas = vidas;
	}



	public String getLetra() {
	return letra;
	}
	public void setLetra(String letra) {
	this.letra = letra;
	}
	public int getVidas() {
	return vidas;
	}
	public void setVidas(int vidas) {
	this.vidas = vidas;
	}
	public String getEsconde() {
	return esconde;
	}
	public void setEsconde(String esconde) {
	this.esconde = esconde;
	}
	public String getDica() {
	return dica;
	}
	public void setDica(String dica) {
	this.dica = dica;
	}
	
	
	

}
