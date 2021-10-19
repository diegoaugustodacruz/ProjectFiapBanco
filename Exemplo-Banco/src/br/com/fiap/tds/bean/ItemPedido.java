package br.com.fiap.tds.bean;

public class ItemPedido {
	
	private Pedido pedido;
	
	private Produto produto;
	
	public ItemPedido() {}

	public ItemPedido(Pedido pedido, Produto produto) {
		this.pedido = pedido;
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
