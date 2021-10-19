package br.com.fiap.tds.bean;

public class NotaFiscal {

	private int codigo;
	
	private double valor;
	
	public NotaFiscal() {}
	
	public NotaFiscal(double valor) {
		this.valor = valor;
	}
	
	public NotaFiscal(int codigo, double valor) {
		this.codigo = codigo;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}