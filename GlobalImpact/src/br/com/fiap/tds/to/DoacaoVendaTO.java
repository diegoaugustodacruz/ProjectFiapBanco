package br.com.fiap.tds.to;

public class DoacaoVendaTO {
	
	private SupermercadoTO supermercado;
	
	private ProdutoTO produto;
	
	private int idDoacaoVenda;
	
	public DoacaoVendaTO() {
		
	}
	
	

	public DoacaoVendaTO(SupermercadoTO supermercado, ProdutoTO produto, int idDoacaoVenda) {
		super();
		this.supermercado = supermercado;
		this.produto = produto;
		this.idDoacaoVenda = idDoacaoVenda;
	}



	public SupermercadoTO getSupermercado() {
		return supermercado;
	}

	public void setSupermercado(SupermercadoTO supermercado) {
		this.supermercado = supermercado;
	}

	public ProdutoTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoTO produto) {
		this.produto = produto;
	}

	public int getIdDoacaoVenda() {
		return idDoacaoVenda;
	}

	public void setIdDoacaoVenda(int idDoacaoVenda) {
		this.idDoacaoVenda = idDoacaoVenda;
	}
	
	
	
}
