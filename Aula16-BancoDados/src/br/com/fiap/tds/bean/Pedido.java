package br.com.fiap.tds.bean;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

	private int codigo;
	
	private LocalDate data;
	
	private NotaFiscal nota;
	
	private List<ItemPedido> itens;
	
	public Pedido() {
		
	}
	

	public Pedido(LocalDate data, NotaFiscal nota) {
		super();
		this.data = data;
		this.nota = nota;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
}
