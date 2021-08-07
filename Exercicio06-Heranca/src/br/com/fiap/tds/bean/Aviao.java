package br.com.fiap.tds.bean;

public class Aviao extends Veiculo{
	
	private String prefixo;
	private int quantidadeTurbinas;
	
	
	public Aviao() {
		
	}
	
	public Aviao(String modelo, int quantidadeLugares, int comprimento, int anoFabricacao, Cor cor, String prefixo, int quantidadeTurbinas){
		super(modelo, quantidadeLugares, comprimento, anoFabricacao, cor);
		this.prefixo = prefixo;
		this.quantidadeTurbinas = quantidadeTurbinas;
	}

	public String getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	
	public int getQuantidadeTurbinas() {
		return quantidadeTurbinas;
	}

	public void setQuantidadeTurbinas(int quantidadeTurbinas) {
		this.quantidadeTurbinas = quantidadeTurbinas;
	}
		
	
	
	
	
}


