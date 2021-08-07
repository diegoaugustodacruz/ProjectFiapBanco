package br.com.fiap.tds.bean;

public class Veiculo {
	
	protected String modelo;
	protected int quantidadeLugares, comprimento, anoFabricacao;
	protected Cor cor;
	
	
	public Veiculo() {
		
	}
	
	public Veiculo(String modelo, int quantidadeLugares, int comprimento, int anoFabricacao, Cor cor) {
		this.modelo = modelo;
		this.quantidadeLugares = quantidadeLugares;
		this.anoFabricacao = anoFabricacao;
		this.comprimento = comprimento;
		this.cor = cor;
		
	}
	
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getQuantidadeLugares() {
		return quantidadeLugares;
	}
	public void setQuantidadeLugares(int quantidadeLugares) {
		this.quantidadeLugares = quantidadeLugares;
	}
	public int getComprimento() {
		return comprimento;
	}
	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	

}
